/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.fusesource.ide.server.servicemix.ui;

import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * A class that keeps references and disposes of the UI plugin's images
 * TODO - check for another impl somewhere we can subclass, maybe foundation
 */
public class ServiceMixSharedImages {

	public static final String IMG_SERVICEMIX_LOGO_LARGE = "servicemix.png"; //$NON-NLS-1$

	private static ServiceMixSharedImages instance;
	
	private Hashtable<String, Object> images, descriptors;
	
	private ServiceMixSharedImages () {
		instance = this;
		images = new Hashtable<String, Object>();
		descriptors = new Hashtable<String, Object>();
		
		if( ServiceMixUIPlugin.getDefault() == null || ServiceMixUIPlugin.getDefault().getBundle() == null ) 
			return;
		
		Bundle pluginBundle = ServiceMixUIPlugin.getDefault().getBundle();
		
		descriptors.put(IMG_SERVICEMIX_LOGO_LARGE, createImageDescriptor(pluginBundle, "/icons/servicemix.png")); //$NON-NLS-1$

		Iterator<String> iter = descriptors.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			ImageDescriptor descriptor = descriptor(key);
			images.put(key,  descriptor.createImage());	
		}
	}
	
	private ImageDescriptor createImageDescriptor (Bundle pluginBundle, String relativePath) {
		return ImageDescriptor.createFromURL(pluginBundle.getEntry(relativePath));
	}
	
	public static ServiceMixSharedImages instance() {
		if (instance == null)
			instance = new ServiceMixSharedImages();
		return instance;
	}
	
	public static Image getImage(String key) {
		return instance().image(key);
	}
	
	public static ImageDescriptor getImageDescriptor(String key) {
		return instance().descriptor(key);
	}
	
	public Image image(String key) {
		return (Image) images.get(key);
	}
	
	public ImageDescriptor descriptor(String key) {
		return (ImageDescriptor) descriptors.get(key);
	}
	
	public void cleanup() {
		Iterator<String> iter = images.keySet().iterator();
		while (iter.hasNext()) {
			Image image = (Image) images.get(iter.next());
			image.dispose();
		}
		images = null;
		descriptors = null;
		instance = null;
	}
	
	protected void finalize() throws Throwable {
		cleanup();
		super.finalize();
	}
}
