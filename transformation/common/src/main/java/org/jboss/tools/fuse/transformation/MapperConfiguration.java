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
package org.jboss.tools.fuse.transformation;

import java.io.OutputStream;
import java.util.List;

import org.jboss.tools.fuse.transformation.model.Model;

/**
 * Abstraction over specific mapping framework implementations. Tooling should
 * use this contract vs. interacting directly with the underlying mapping
 * framework.
 */
public interface MapperConfiguration {
    /**
     * Remove all mappings in the mapper configuration.
     */
    void removeAllMappings();

    /**
     * Remove a specific mapping from the mapper configuration.
     * 
     * @param mapping mapping to remove
     */
    void removeMapping(MappingOperation<?,?> mapping);

    /**
     * Get all mappings that include the specified model as a source.
     * 
     * @param source source model
     * @return list of mappings
     */
    List<MappingOperation<?,?>> getMappingsForSource(Model source);

    /**
     * Get all mappings that include the specified model as a target.
     * 
     * @param target target model
     * @return list of mappings
     */
    List<MappingOperation<?,?>> getMappingsForTarget(Model target);

    /**
     * Get a list of all mappings in the mapper configuration.
     * 
     * @return list of mappings
     */
    List<MappingOperation<?,?>> getMappings();
    
    /**
     * Add a variable definition to the mapping configuration. If an existing
     * mapping exists with the same variable name, the variable value is updated
     * instead of adding a new variable definition.
     * 
     * @param name variable name
     * @param value variable value
     * @return reference to the new Variable
     */
    Variable addVariable(String name, String value);

    /**
     * Remove the specified variable from the mapping configuration. If no
     * mapping is defined with the specified variable's name, this method
     * returns false.
     * 
     * @param variable variable to remove
     * @return true if the variable was removed, false otherwise
     */
    boolean removeVariable(Variable variable);

    /**
     * Get the list of variables used as the source for mappings.
     * 
     * @return list of variables
     */
    List<Variable> getVariables();
    
    /**
     * Retrieve a variable by name.
     * @param variableName name of the variable
     * @return variable reference or null if the variable is not defined
     */
    Variable getVariable(String variableName);

    /**
     * Map a source field to a target field.
     * 
     * @param source model for the source field
     * @param target model for the target field
     * @return mapping created
     */
    FieldMapping mapField(Model source, Model target);
    
    /**
     * Map a source field to a target field using indexes.
     * 
     * @param source model for the source field
     * @param target model for the target field
     * @param sourceIndex index for source field
     * @param targetIndex index for target field
     * @return mapping created
     */
    FieldMapping mapField(Model source, Model target, 
            List<Integer> sourceIndex, List<Integer> targetIndex);

    /**
     * Map a variable to a target field.
     * 
     * @param variable source variable
     * @param target target field
     * @return mapping created
     */
    VariableMapping mapVariable(Variable variable, Model target);
    
    /**
     * Map a variable to a target using an index for the target field.
     * 
     * @param variable source variable
     * @param target target field
     * @param targetIndex index for target field
     * @return mapping created
     */
    VariableMapping mapVariable(Variable variable, Model target, List<Integer> targetIndex);
    
    /**
     * Map an expression to a target field.
     * 
     * @param expression expression language
     * @param expression expression text
     * @param target target field
     * @return mapping created
     */
    ExpressionMapping mapExpression(String language, String expression, Model target);
    
    /**
     * Map an expression to a target using an index for the target field.
     * 
     * @param expression expression language
     * @param expression expression text
     * @param target target field
     * @param targetIndex index for target field
     * @return mapping created
     */
    ExpressionMapping mapExpression(
            String language, String expression, Model target, List<Integer> targetIndex);

    /**
     * Write the mapping configuration to the specified output stream.
     * 
     * @param output stream to write to
     * @throws Exception marshaling or writing the config failed
     */
    void saveConfig(OutputStream output) throws Exception;

    /**
     * Add a class mapping between the fromClass and toClass. Honestly, this
     * method is sorta Dozer-specific and probably shouldn't be in this
     * interface.
     * 
     * @param fromClass source class name
     * @param toClass target class name
     */
    void addClassMapping(String fromClass, String toClass);

    /**
     * Returns the source model for the mapping.
     * 
     * @return source model
     */
    Model getSourceModel();

    /**
     * Returns the target model for the mapping.
     * 
     * @return target model
     */
    Model getTargetModel();

    /**
     * Use a custom mapping class for an existing FieldMapping.
     * 
     * @param mapping mapping to customize
     * @param mappingClass class to use for customizing the mapping
     * @return the new CustomMapping
     */
    CustomMapping customizeMapping(FieldMapping mapping, String mappingClass);

    /**
     * Use a custom mapping class for an existing FieldMapping.
     * 
     * @param mapping mapping to customize
     * @param mappingClass class to use for customizing the mapping
     * @param mappingOperation operation in the mappingClass to use
     * @return CustomMapping
     */
    CustomMapping customizeMapping(FieldMapping mapping, String mappingClass,
            String mappingOperation);
}
