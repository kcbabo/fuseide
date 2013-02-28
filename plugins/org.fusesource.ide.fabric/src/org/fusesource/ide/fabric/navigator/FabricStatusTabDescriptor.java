/*******************************************************************************
 * Copyright (c) 2013 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package org.fusesource.ide.fabric.navigator;

import org.eclipse.ui.part.IPage;
import org.fusesource.ide.commons.ui.views.PageTabDescriptor;


public class FabricStatusTabDescriptor extends PageTabDescriptor {
	private final Fabric node;

	public FabricStatusTabDescriptor(String label, Fabric node) {
		super(label);
		this.node = node;
	}

	@Override
	protected IPage createPage() {
		return new FabricStatusTableSheetPage(node);
	}
}