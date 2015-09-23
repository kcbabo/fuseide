/*
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors.
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

import java.util.LinkedList;
import java.util.List;

public class ModelBuilder {
    
    public enum Strategy {FIELDS, PROPERTIES};

    private static FieldModelParser fieldParser = new FieldModelParser();
    private static PropertyModelParser propertyParser = new PropertyModelParser();
    
    private ModelParser parser;
    
    private ModelBuilder(Strategy strategy) {
        switch (strategy) {
            case FIELDS :
                parser = fieldParser;
                break;
            case PROPERTIES :
                parser = propertyParser;
                break;
            default :
                throw new RuntimeException("Unsupported model strategy: " + strategy);
        }
    }

    public static Model fromJavaClass(Class<?> javaClass) {
        return fromJavaClass(javaClass, Strategy.PROPERTIES);
    }
    
    public static Model fromJavaClass(Class<?> javaClass, Strategy strategy) {
        ModelBuilder builder = new ModelBuilder(strategy);
        return builder.generateModel(javaClass);
    }

    public static String getListName(Class<?> listType) {
        return "[" + listType.getName() + "]";
    }

    public static String getListType(String listName) {
        return listName.split("\\[")[1].split("\\]")[0];
    }
    
    private Model generateModel(Class<?> javaClass) {
        Model model = new Model(javaClass.getSimpleName(), javaClass.getName());
        addFieldsToModel(parser.getModelFields(javaClass), model);
        model.setModelClass(javaClass);
        return model;
    }

    private void addFieldsToModel(List<ModelField> fields, Model model) {
        for (ModelField field : fields) {
            // Create the model for this field
            String fieldTypeName = field.isCollection ? getListName(field.type) : field.type.getName();
            Model child = model.addChild(field.name, fieldTypeName);
            child.setIsCollection(field.isCollection);

            // Deal with child fields if necessary
            if (parseChildren(field.type)) {
                addFieldsToModel(getFields(field.type, model), child);
            }
        }
    }

    private List<ModelField> getFields(Class<?> clazz, Model parent) {
        boolean cycle = false;
        // convenient place to check for a cycle where a child field references an ancestor
        for (Model pm = parent; pm != null; pm = pm.getParent()) {
            String parentType = pm.isCollection() ? getListType(pm.getType()) : pm.getType();
            System.out.println(clazz.getName() + " == " + parentType);
            if (clazz.getName().equals(parentType)) {
                    cycle = true;
                    break;
            }
        }
        if (!cycle) {
            return parser.getModelFields(clazz);
        } else {
            return new LinkedList<ModelField>();
        }
    }
    
    private boolean parseChildren(Class<?> fieldClass) {
        boolean excluded = 
            fieldClass.isPrimitive()
            || fieldClass.getName().equals(String.class.getName())
            || fieldClass.getName().startsWith("java.")
            || Number.class.isAssignableFrom(fieldClass)
            || (fieldClass instanceof Class<?> && ((Class<?>)fieldClass).isEnum());
        
        return !excluded;
    }
}
