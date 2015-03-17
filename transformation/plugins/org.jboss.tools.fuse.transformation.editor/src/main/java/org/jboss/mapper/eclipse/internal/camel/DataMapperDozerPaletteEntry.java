/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.mapper.eclipse.internal.camel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.model.dataformat.DataFormatsDefinition;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spring.CamelContextFactoryBean;
import org.apache.camel.spring.CamelEndpointFactoryBean;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.IImageDecorator;
import org.fusesource.ide.camel.editor.Activator;
import org.fusesource.ide.camel.editor.features.create.ext.CreateEndpointFigureFeature;
import org.fusesource.ide.camel.editor.provider.ext.ICustomPaletteEntry;
import org.fusesource.ide.camel.editor.provider.ext.PaletteCategoryItemProvider.CATEGORY_TYPE;
import org.fusesource.ide.camel.model.Endpoint;
import org.fusesource.ide.camel.model.RouteContainer;
import org.fusesource.ide.camel.model.RouteSupport;
import org.fusesource.ide.camel.model.connectors.ConnectorDependency;

/**
 * @author bfitzpat
 */
@SuppressWarnings("restriction")
public class DataMapperDozerPaletteEntry implements ICustomPaletteEntry {


    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.editor.provider.ICustomPaletteEntry#newCreateFeature(org.eclipse.graphiti.features.IFeatureProvider)
     */
    @Override
    public ICreateFeature newCreateFeature(IFeatureProvider fp) {
        return new DataMapperEndpointFigureFeature(fp, 
        		"Data Transformation", 
        		"Creates a Data Mapper endpoint...");
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.editor.provider.ICustomPaletteEntry#getImageDecorator(java.lang.Object)
     */
    @Override
    public IImageDecorator getImageDecorator(Object object) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.editor.provider.ICustomPaletteEntry#getTypeName()
     */
    @Override
    public String getTypeName() {
        return "DataTransformation";
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.editor.provider.ICustomPaletteEntry#supports(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
	@Override
    public boolean supports(Class type) {
        return false;
    }

    /* (non-Javadoc)
     * @see org.fusesource.ide.camel.editor.provider.ICustomPaletteEntry#getRequiredCapabilities(java.lang.Object)
     */
    @Override
    public List<ConnectorDependency> getRequiredCapabilities(Object object) {
        List<ConnectorDependency> deps = new ArrayList<ConnectorDependency>();
        ConnectorDependency dep = new ConnectorDependency();
        dep.setGroupId("org.apache.camel");
        dep.setArtifactId("camel-dozer");
        // TODO - this shouldn't be hard-coded; figure out how to get the camel version from the project
        dep.setVersion("2.15-SNAPSHOT");
        deps.add(dep);
        return deps;
    }
    
    class DataMapperEndpointFigureFeature extends CreateEndpointFigureFeature {

		public DataMapperEndpointFigureFeature(IFeatureProvider fp,
				String name, String description) {
			super(fp, name, description, null);
		}

		@Override
		public Object[] create(ICreateContext context) {
			RouteSupport selectedRoute = Activator.getDiagramEditor().getSelectedRoute();
			RouteContainer routeContainer = Activator.getDiagramEditor().getModel();
            CamelContextFactoryBean camelContext = 
                    routeContainer.getModel().getContextElement();
            
            // Add camel context endpoint
            CamelEndpointFactoryBean endpoint = createExampleEndpoint();
            addCamelContextEndpoint(camelContext, endpoint);
            
            // Add data formats
            List<DataFormatDefinition> dataFormats = createExampleDataFormats();
            addDataFormats(camelContext, dataFormats);
            
            // Create the route endpoint
            Endpoint routeEndpoint = new Endpoint("ref:xml2json");
			if (selectedRoute != null) {
				selectedRoute.addChild(routeEndpoint);
			} else {
				Activator.getLogger().warning("Warning! Could not find currently selectedNode, so can't associate this node with the route!: " + routeEndpoint);
			}

			// do the add
			PictogramElement pe = addGraphicalRepresentation(context, routeEndpoint);
			getFeatureProvider().link(pe, routeEndpoint);
			
			// activate direct editing after object creation
			getFeatureProvider().getDirectEditingInfo().setActive(true);
			
			// return newly created business object(s)
			return new Object[] { routeEndpoint };
		}
		
		private void addCamelContextEndpoint(CamelContextFactoryBean context, CamelEndpointFactoryBean endpoint) {
            List<CamelEndpointFactoryBean> endpoints = context.getEndpoints();
            if (endpoints == null) {
                endpoints = new LinkedList<CamelEndpointFactoryBean>();
            }
            endpoints.add(endpoint);
            setEndpoints(context, endpoints);
		}
		
		private void addDataFormats(CamelContextFactoryBean context, List<DataFormatDefinition> dfList) {
		    DataFormatsDefinition dataFormats = context.getDataFormats();
		    // create the parent element if it doesn't exist
		    if (dataFormats == null) {
		        dataFormats = new DataFormatsDefinition();
		    }
		    
		    // add to the list of formats
		    if (dataFormats.getDataFormats() != null) {
		        dataFormats.getDataFormats().addAll(dfList);
		    } else {
                dataFormats.setDataFormats(dfList);
		    }
		    
            context.setDataFormats(dataFormats);
        }
    	
    }

	@Override
	public String getPaletteCategory() {
        return CATEGORY_TYPE.TRANSFORMATION.name();
	}
	
	/**
     * Due to https://issues.apache.org/jira/browse/CAMEL-8498, we cannot set
     * endpoints on CamelContextFactoryBean directly.  Use reflection for now
     * until this issue is resolved upstream.
     */
    private void setEndpoints(CamelContextFactoryBean context, 
            List<CamelEndpointFactoryBean> endpoints) {
        try {
            Field endpointsField = context.getClass().getDeclaredField("endpoints");
            endpointsField.setAccessible(true);
            endpointsField.set(context, endpoints);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void launchWizard() {

        /*
        // fire up the wizard, get the URI
        NewTransformationWizard wizard = new NewTransformationWizard();
        WizardDialog dialog = new WizardDialog(
                Display.getCurrent().getActiveShell(), wizard);
        int status = dialog.open();
        if (status == IStatus.OK) {
            node = createNode(newContext);
        } else {
            return new Object[] {};
        }
        */
    }
    
    // TODO - Remove this once the wizard is hooked up.
    private CamelEndpointFactoryBean createExampleEndpoint() {
        final String uri = "dozer:xml2json?sourceModel=abcorder.ABCOrder&amp;targetModel=xyzorder.XyzOrder&amp;"
                + "marshalId=transform-json&amp;unmarshalId=abcorder&amp;mappingFile=transformation.xml";
        CamelEndpointFactoryBean camelEndpoint = new CamelEndpointFactoryBean();
        camelEndpoint.setId("xml2json");
        camelEndpoint.setUri(uri);
        return camelEndpoint;
    }
    
    // TODO - Remove this once the wizard is hooked up.
    private List<DataFormatDefinition> createExampleDataFormats() {
        List<DataFormatDefinition> dfList = new ArrayList<DataFormatDefinition>(2);
        // JAXB
        JaxbDataFormat jaxb = new JaxbDataFormat();
        jaxb.setContextPath("abcorder");
        jaxb.setId("abcorder");
        // JSON
        JsonDataFormat json = new JsonDataFormat();
        json.setId("transform-json");
        json.setLibrary(JsonLibrary.Jackson);
        dfList.add(jaxb);
        dfList.add(json);
        return dfList;
    }
}
