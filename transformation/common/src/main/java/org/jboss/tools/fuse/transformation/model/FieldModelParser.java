/*
 * Copyright 2015 Red Hat Inc. and/or its affiliates and other contributors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.jboss.tools.fuse.transformation.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FieldModelParser implements ModelParser {
    @Override
    public List<ModelField> getModelFields(Class<?> clazz) {
        List<ModelField> fields = new LinkedList<ModelField>();
        getFields(clazz, fields);
        return fields;
    }
    
    private static void getFields(Class<?> clazz, List<ModelField> fields) {
        // check if we've hit rock bottom
        if (clazz == null || Object.class.equals(clazz)) {
            return;
        }

        for (Field field : clazz.getDeclaredFields()) {
            if (!field.isSynthetic()) {
                ModelField modelField = new ModelField();
                modelField.name = field.getName();
                if (field.getType().isArray()) {
                    modelField.isCollection = true;
                    modelField.type = field.getType().getComponentType();
                } else if (Collection.class.isAssignableFrom(field.getType())) {
                    modelField.isCollection = true;
                    Type ft = field.getGenericType();
                    if (ft instanceof ParameterizedType) {
                        modelField.type = (Class<?>) ((ParameterizedType) ft).getActualTypeArguments()[0];
                    } else {
                        modelField.type = Object.class;
                    }
                } else {
                    modelField.type = field.getType();
                }
                fields.add(modelField);
            }
        }
        getFields(clazz.getSuperclass(), fields);
    }
}
