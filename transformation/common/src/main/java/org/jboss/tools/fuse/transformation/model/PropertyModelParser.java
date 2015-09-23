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

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PropertyModelParser implements ModelParser {
    @Override
    public List<ModelField> getModelFields(Class<?> clazz) {
        List<ModelField> fields = new LinkedList<ModelField>();
        getProperties(clazz, fields);
        return fields;
    }
    
    private void getProperties(Class<?> clazz, List<ModelField> fields) {
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(clazz, Object.class);
        } catch (IntrospectionException inEx) {
            throw new RuntimeException("Failed to introspect " + clazz.getName());
        }
        
        for (PropertyDescriptor prop : beanInfo.getPropertyDescriptors()) {
            ModelField field = new ModelField();
            field.name = prop.getName();
            Class<?> fieldType = prop.getReadMethod().getReturnType();
            
            if (fieldType.isArray()) {
                field.isCollection = true;
                field.type = fieldType.getComponentType();
            } else if (Collection.class.isAssignableFrom(fieldType)) {
                field.isCollection = true;
                Type ft = prop.getReadMethod().getGenericReturnType();
                if (ft instanceof ParameterizedType) {
                    field.type = (Class<?>) ((ParameterizedType) ft).getActualTypeArguments()[0];
                } else {
                    field.type = Object.class;
                }
            } else {
                field.type = fieldType;
            }
            fields.add(field);
        }

    }
}