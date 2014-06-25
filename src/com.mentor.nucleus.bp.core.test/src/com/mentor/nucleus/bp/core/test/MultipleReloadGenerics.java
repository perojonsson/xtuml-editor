//========================================================================
//
// File: com.mentor.nucleus.bp.ui.canvas.test.I686ClearDatabaseTest.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/gen_testClearDatabaseClass.arc
// Version:      $Revision: 1.5 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
package com.mentor.nucleus.bp.core.test;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.CorePlugin;
import com.mentor.nucleus.bp.core.ModelClass_c;
import com.mentor.nucleus.bp.core.Ooaofooa;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.Subsystem_c;
import com.mentor.nucleus.bp.core.common.ComponentResourceListener;
import com.mentor.nucleus.bp.core.common.InstanceList;
import com.mentor.nucleus.bp.core.common.ModelRoot;
import com.mentor.nucleus.bp.core.common.NonRootModelElement;
import com.mentor.nucleus.bp.core.common.PersistableModelComponent;
import com.mentor.nucleus.bp.core.common.PersistenceManager;
import com.mentor.nucleus.bp.test.TestUtil;
import com.mentor.nucleus.bp.test.common.BaseTest;
import com.mentor.nucleus.bp.test.common.TestingUtilities;
import com.mentor.nucleus.bp.ui.canvas.Connector_c;
import com.mentor.nucleus.bp.ui.canvas.ElementInResize_c;
import com.mentor.nucleus.bp.ui.canvas.FloatingText_c;
import com.mentor.nucleus.bp.ui.canvas.GraphicalElement_c;
import com.mentor.nucleus.bp.ui.canvas.LineSegment_c;
import com.mentor.nucleus.bp.ui.canvas.Model_c;
import com.mentor.nucleus.bp.ui.canvas.Ooaofgraphics;
import com.mentor.nucleus.bp.ui.canvas.Shape_c;

public class MultipleReloadGenerics extends BaseTest {

	//private static final String projectName = "com.mentor.nucleus.bp.core.testGenerics"; //$NON-NLS-1$
	private static final String modelName = "mfp_issue34"; //$NON-NLS-1$
	private static boolean initialized = false;
	public MultipleReloadGenerics(String name) throws Exception {
		super("Default Project", name); //$NON-NLS-1$
	}

	protected void setUp() throws Exception {
		super.setUp();
		if (!initialized) {
			loadProject(modelName);
			initialized = true;
		}
	}

	public void testMultipleUnloadsAndLoads() {
		m_bp_tree.expandAll();

		// do this twice to expose problem in mfp issue 34

		unloadAndLoadSubsystem();
		unloadAndLoadSubsystem();
	}
	private void unloadAndLoadSubsystem() {
		int[] startGraphicsModelInstanceCount = countGraphicsInstances();
		ModelClass_c[] mc_set = ModelClass_c.ModelClassInstances(modelRoot);
		assertEquals(2, mc_set.length);
		Package_c[] ss_set = Package_c.PackageInstances(modelRoot);
		int Count = 0;
		int packageIndex = 0;
		for (int i = 0; i < ss_set.length; i++) {
			if (ss_set[i].getName().toString().equals("Test")) {
				Count++;
				packageIndex = i;
			}
		}

		assertEquals(1, Count);
		IResource[] resource_set = new IResource[3];

		ModelRoot.disableChangeNotification();
		// simulate the subsystem folder being deleted
		try {
			for (int i = 0; i < mc_set.length; ++i) {
				resource_set[i] = mc_set[i].getFile();
				unloadComponent(mc_set[i]);
			}
			resource_set[2] = ss_set[packageIndex].getFile();
			unloadComponent(ss_set[packageIndex]);
		} finally {
			ModelRoot.enableChangeNotification();
		}
		int[] endGraphicsModelInstanceCount = countGraphicsInstances();

		// verify that the graphics model data was deleted
		for (int i = 0; i < startGraphicsModelInstanceCount.length; ++i) {
			assertEquals("after deletion, entry " + i,
					startGraphicsModelInstanceCount[i] - diffs[i],
					endGraphicsModelInstanceCount[i]);
		}

		// simulate the subsystem folder being restored from local history
		for (int i = 0; i < resource_set.length; ++i) {
			ComponentResourceListener.addComponentResource(resource_set[i]);
		}

		endGraphicsModelInstanceCount = countGraphicsInstances();

		// verify that the graphics model data was restored
		for (int i = 0; i < startGraphicsModelInstanceCount.length; ++i) {
			assertEquals("after restore, entry " + i,
					startGraphicsModelInstanceCount[i],
					endGraphicsModelInstanceCount[i]);
		}

	}

	// The change in the number of instances in ooaofgraphics when the subystem is deleted
	static int[] diffs = {1, // Model_c
			3, // GraphicalElement 
			2, // Shape
			1, // Connector
			2, // LineSegment
			3, // ConnectorText
			0 // ElementInResize    
	};

	private int[] countGraphicsInstances() {
		int[] result = new int[7];
		InstanceList list = null;
		list = graphicsModelRoot.getInstanceList(Model_c.class);
		result[0] = list.size();
		list = graphicsModelRoot.getInstanceList(GraphicalElement_c.class);
		result[1] = list.size();
		list = graphicsModelRoot.getInstanceList(Shape_c.class);
		result[2] = list.size();
		list = graphicsModelRoot.getInstanceList(Connector_c.class);
		result[3] = list.size();
		list = graphicsModelRoot.getInstanceList(LineSegment_c.class);
		result[4] = list.size();
		list = graphicsModelRoot.getInstanceList(FloatingText_c.class);
		result[5] = list.size();
		list = graphicsModelRoot.getInstanceList(ElementInResize_c.class);
		result[6] = list.size();
		return result;

	}
	private void unloadComponent(NonRootModelElement element) {
		PersistableModelComponent pmc = PersistenceManager
				.getComponent(element);
		pmc.deleteSelf();
	}
}
