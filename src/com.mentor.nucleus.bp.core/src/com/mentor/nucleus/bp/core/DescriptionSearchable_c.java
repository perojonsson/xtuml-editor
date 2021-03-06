package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.DescriptionSearchable_c.java
//
// WARNING: Do not edit this generated file
// Generated by ../MC-Java/java.arc, $Revision: 1.111 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//====================================================================

// No special imports
import java.util.*;
import java.lang.reflect.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import com.mentor.nucleus.bp.core.util.PersistenceUtil;
import org.eclipse.core.runtime.NullProgressMonitor;
import com.mentor.nucleus.bp.core.ui.marker.UmlProblem;
import com.mentor.nucleus.bp.core.common.*;
abstract class EV_DESCRIPTION_SEARCHABLE extends genericEvent_c {
	public abstract int getEvtcode();
}

public class DescriptionSearchable_c extends NonRootModelElement
		implements
			IAdaptable,
			Cloneable {
	// Public Constructors
	public DescriptionSearchable_c(ModelRoot modelRoot, java.util.UUID p_m_id,
			String p_m_searchablevalue) {
		super(modelRoot);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_id = IdAssigner.preprocessUUID(p_m_id);
		m_searchablevalue = p_m_searchablevalue;

		Object[] key = {m_id};
		addInstanceToMap(key);
	}
	static public DescriptionSearchable_c createProxy(ModelRoot modelRoot,
			java.util.UUID p_m_id, String p_m_searchablevalue,
			String p_contentPath, IPath p_localPath) {
		ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot,
				p_contentPath, p_localPath);
		// if a model root was not resolved it is most likely
		// due to a missing file of the proxy, defualt back to
		// the original model root
		if (resolvedModelRoot != null)
			modelRoot = resolvedModelRoot;
		InstanceList instances = modelRoot
				.getInstanceList(DescriptionSearchable_c.class);
		DescriptionSearchable_c new_inst = null;
		synchronized (instances) {
			Object[] key = {p_m_id};
			new_inst = (DescriptionSearchable_c) instances.get(key);
		}
		String contentPath = PersistenceUtil.resolveRelativePath(p_localPath,
				new Path(p_contentPath));
		if (modelRoot.isNewCompareRoot()) {
			// for comparisons we do not want to change
			// the content path
			contentPath = p_contentPath;
		}
		if (new_inst != null && !modelRoot.isCompareRoot()) {
			PersistableModelComponent pmc = new_inst.getPersistableComponent();
			if (pmc == null) {
				// dangling reference, redo this instance
				new_inst.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_id = IdAssigner.preprocessUUID(p_m_id);
				new_inst.m_searchablevalue = p_m_searchablevalue;

			}
		}
		if (new_inst == null) {
			// there is no instance matching the id, create a proxy
			// if the resource doesn't exist then this will be a dangling reference
			new_inst = new DescriptionSearchable_c(modelRoot, p_m_id,
					p_m_searchablevalue);
			new_inst.m_contentPath = contentPath;
		}
		return new_inst;
	}

	static public DescriptionSearchable_c resolveInstance(ModelRoot modelRoot,
			java.util.UUID p_m_id, String p_m_searchablevalue) {
		InstanceList instances = modelRoot
				.getInstanceList(DescriptionSearchable_c.class);
		DescriptionSearchable_c source = null;
		synchronized (instances) {
			Object[] key = {p_m_id};
			source = (DescriptionSearchable_c) instances.get(key);
			if (source != null && !modelRoot.isCompareRoot()) {
				source.convertFromProxy();
				source.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_id = IdAssigner.preprocessUUID(p_m_id);
				source.m_searchablevalue = p_m_searchablevalue;

				return source;
			}
		}
		// there is no instance matching the id
		DescriptionSearchable_c new_inst = new DescriptionSearchable_c(
				modelRoot, p_m_id, p_m_searchablevalue);
		return new_inst;
	}
	public DescriptionSearchable_c(ModelRoot modelRoot) {
		super(modelRoot);
		m_id = IdAssigner.NULL_UUID;
		m_searchablevalue = "";
		Object[] key = {m_id};
		addInstanceToMap(key);
	}

	public Object getInstanceKey() {
		Object[] key = {m_id};
		return key;
	}

	public boolean setInstanceKey(UUID p_newKey) {

		boolean changed = false;
		// round p1
		// round p2
		// round p3
		// round p4
		// round p5
		if (m_id != p_newKey) {

			m_id = p_newKey;
			changed = true;
		}
		return changed;
	}

	public boolean equals(Object elem) {
		if (!(elem instanceof DescriptionSearchable_c)) {
			return false;
		}
		// check that the model-roots are the same
		if (((NonRootModelElement) elem).getModelRoot() != getModelRoot()
				&& !getModelRoot().isCompareRoot()) {
			return false;
		}

		return identityEquals(elem);
	}

	public boolean identityEquals(Object elem) {
		if (!(elem instanceof DescriptionSearchable_c)) {
			return false;
		}

		DescriptionSearchable_c me = (DescriptionSearchable_c) elem;
		// don't allow an empty id-value to produce a false positive result;
		// in this case, use whether the two instances are actually the same 
		// one in memory, instead
		if (!getModelRoot().isCompareRoot()
				&& ((IdAssigner.NULL_UUID.equals(getId()) || IdAssigner.NULL_UUID
						.equals(((DescriptionSearchable_c) elem).getId())) && this != elem)) {
			return false;
		}
		if (!getId().equals(((DescriptionSearchable_c) elem).getId()))
			return false;
		return true;
	}

	public boolean cachedIdentityEquals(Object elem) {
		if (!(elem instanceof DescriptionSearchable_c)) {
			return false;
		}

		DescriptionSearchable_c me = (DescriptionSearchable_c) elem;
		if (!getIdCachedValue().equals(
				((DescriptionSearchable_c) elem).getIdCachedValue()))
			return false;
		return true;
	}

	// Attributes
	private java.util.UUID m_id;
	private String m_searchablevalue;

	// declare association references from this class

	// referring navigation

	SearchableElement_c IsSupertypeSearchableElement;
	public void relateAcrossR9702To(SearchableElement_c target) {
		relateAcrossR9702To(target, true);
	}
	public void relateAcrossR9702To(SearchableElement_c target,
			boolean notifyChanges) {
		if (target == null)
			return;

		if (target == IsSupertypeSearchableElement)
			return; // already related

		if (IsSupertypeSearchableElement != target) {

			Object oldKey = getInstanceKey();

			if (IsSupertypeSearchableElement != null) {

				IsSupertypeSearchableElement.clearBackPointerR9702To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"DescriptionSearchable_c.relateAcrossR9702To(SearchableElement_c target)",
									"Relate performed across R9702 from Description Searchable to Searchable Element without unrelate of prior instance.");
				}
			}

			IsSupertypeSearchableElement = target;
			m_id = target.getId();
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR9702To(this);
			target.addRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_RELATED, this,
						target, "9702", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}
	public void unrelateAcrossR9702From(SearchableElement_c target) {
		unrelateAcrossR9702From(target, true);
	}
	public void unrelateAcrossR9702From(SearchableElement_c target,
			boolean notifyChanges) {
		if (target == null)
			return;

		if (IsSupertypeSearchableElement == null)
			return; // already unrelated

		if (target != IsSupertypeSearchableElement) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R9702",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR9702To(this);
		}

		if (IsSupertypeSearchableElement != null) {

			m_id = IsSupertypeSearchableElement.getId();
			IsSupertypeSearchableElement = null;
			target.removeRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_UNRELATED, this,
						target, "9702", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			SearchableElement_c[] targets) {
		return getOneSP_DSOnR9702(targets, null);
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			SearchableElement_c[] targets, ClassQueryInterface_c test) {
		DescriptionSearchable_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneSP_DSOnR9702(targets[i], test);
			}
		}

		return ret_val;
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			SearchableElement_c target) {
		return getOneSP_DSOnR9702(target, null);
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			SearchableElement_c target, boolean loadComponent) {
		return getOneSP_DSOnR9702(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			SearchableElement_c target, ClassQueryInterface_c test) {
		if (target != null) {
			return getOneSP_DSOnR9702(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			ModelRoot modelRoot, SearchableElement_c target,
			ClassQueryInterface_c test) {
		return getOneSP_DSOnR9702(modelRoot, target, test, true);
	}

	public static DescriptionSearchable_c getOneSP_DSOnR9702(
			ModelRoot modelRoot, SearchableElement_c target,
			ClassQueryInterface_c test, boolean loadComponent) {
		return find_getOneSP_DSOnR9702(modelRoot, target, test);
	}
	private static DescriptionSearchable_c find_getOneSP_DSOnR9702(
			ModelRoot modelRoot, SearchableElement_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			DescriptionSearchable_c source = (DescriptionSearchable_c) target.backPointer_IsSubtypeDescriptionSearchableIsSubtype_R9702;
			if (source != null && (test == null || test.evaluate(source))) {
				return source;
			}
		}
		// not found
		return null;
	}

	public static DescriptionSearchable_c[] getManySP_DSsOnR9702(
			SearchableElement_c[] targets) {
		return getManySP_DSsOnR9702(targets, null);
	}
	public static DescriptionSearchable_c[] getManySP_DSsOnR9702(
			SearchableElement_c[] targets, boolean loadComponent) {
		return getManySP_DSsOnR9702(targets, null, loadComponent);
	}
	public static DescriptionSearchable_c[] getManySP_DSsOnR9702(
			SearchableElement_c[] targets, ClassQueryInterface_c test) {
		return getManySP_DSsOnR9702(targets, test, true);
	}

	public static DescriptionSearchable_c[] getManySP_DSsOnR9702(
			SearchableElement_c[] targets, ClassQueryInterface_c test,
			boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new DescriptionSearchable_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(DescriptionSearchable_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			DescriptionSearchable_c source = (DescriptionSearchable_c) targets[i].backPointer_IsSubtypeDescriptionSearchableIsSubtype_R9702;
			if (source != null && (test == null || test.evaluate(source))) {
				matches.add(source);
			}
		}
		if (matches.size() > 0) {
			DescriptionSearchable_c[] ret_set = new DescriptionSearchable_c[matches
					.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new DescriptionSearchable_c[0];
		}
	}

	public static DescriptionSearchable_c[] getManySP_DSsOnR9702(
			SearchableElement_c target) {
		if (target != null) {
			SearchableElement_c[] targetArray = new SearchableElement_c[1];
			targetArray[0] = target;
			return getManySP_DSsOnR9702(targetArray);
		} else {
			DescriptionSearchable_c[] result = new DescriptionSearchable_c[0];
			return result;
		}
	}

	public static DescriptionSearchable_c[] getManySP_DSsOnR9702(
			SearchableElement_c target, boolean loadComponent) {
		if (target != null) {
			SearchableElement_c[] targetArray = new SearchableElement_c[1];
			targetArray[0] = target;
			return getManySP_DSsOnR9702(targetArray, loadComponent);
		} else {
			DescriptionSearchable_c[] result = new DescriptionSearchable_c[0];
			return result;
		}
	}

	public void batchRelate(ModelRoot modelRoot, boolean notifyChanges,
			boolean searchAllRoots) {
		batchRelate(modelRoot, false, notifyChanges, searchAllRoots);
	}

	public void batchRelate(ModelRoot modelRoot, boolean relateProxies,
			boolean notifyChanges, boolean searchAllRoots) {
		InstanceList instances = null;
		ModelRoot baseRoot = modelRoot;

		// R9702
		SearchableElement_c relInst39660 = (SearchableElement_c) baseRoot
				.getInstanceList(SearchableElement_c.class).get(
						new Object[]{m_id});
		// if there was no local element, check for any global elements
		// failing that proceed to check other model roots
		if (relInst39660 == null) {
			relInst39660 = (SearchableElement_c) Ooaofooa.getDefaultInstance()
					.getInstanceList(SearchableElement_c.class)
					.get(new Object[]{m_id});
		}
		if (relInst39660 == null && searchAllRoots && !baseRoot.isCompareRoot()) {
			Ooaofooa[] roots = Ooaofooa.getInstances();
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].isCompareRoot()) {
					// never use elements from any compare root
					continue;
				}
				relInst39660 = (SearchableElement_c) roots[i].getInstanceList(
						SearchableElement_c.class).get(new Object[]{m_id});
				if (relInst39660 != null)
					break;
			}
		}
		//synchronized
		if (relInst39660 != null) {
			if (relateProxies || !isProxy()
					|| (inSameComponent(this, relInst39660) && !isProxy())) {
				relInst39660.relateAcrossR9702To(this, notifyChanges);
			}
		}

	}
	public void batchUnrelate(boolean notifyChanges) {
		NonRootModelElement inst = null;
		// R9702
		// SP_SE
		inst = IsSupertypeSearchableElement;
		unrelateAcrossR9702From(IsSupertypeSearchableElement, notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
	}
	public static void batchRelateAll(ModelRoot modelRoot,
			boolean notifyChanges, boolean searchAllRoots) {
		batchRelateAll(modelRoot, notifyChanges, searchAllRoots, false);
	}
	public static void batchRelateAll(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots, boolean relateProxies)
  {
	InstanceList instances = modelRoot.getInstanceList(DescriptionSearchable_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final DescriptionSearchable_c inst = (DescriptionSearchable_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }
	public static void clearInstances(ModelRoot modelRoot) {
		InstanceList instances = modelRoot
				.getInstanceList(DescriptionSearchable_c.class);
		synchronized (instances) {
			for (int i = instances.size() - 1; i >= 0; i--) {
				((NonRootModelElement) instances.get(i)).delete_unchecked();
			}

		}
	}

	public static DescriptionSearchable_c DescriptionSearchableInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		DescriptionSearchable_c result = findDescriptionSearchableInstance(
				modelRoot, test, loadComponent);
		if (result == null && loadComponent) {
			List pmcs = PersistenceManager.findAllComponents(modelRoot,
					DescriptionSearchable_c.class);
			for (int i = 0; i < pmcs.size(); i++) {
				PersistableModelComponent component = (PersistableModelComponent) pmcs
						.get(i);
				if (!component.isLoaded()) {
					try {
						component.load(new NullProgressMonitor());
						result = findDescriptionSearchableInstance(modelRoot,
								test, loadComponent);
						if (result != null)
							return result;
					} catch (Exception e) {
						CorePlugin.logError("Error Loading component", e);
					}
				}
			}
		}
		if (result != null && loadComponent) {
			result.loadProxy();
		}
		return result;
	}
	private static DescriptionSearchable_c findDescriptionSearchableInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(DescriptionSearchable_c.class);
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				DescriptionSearchable_c x = (DescriptionSearchable_c) instances
						.get(i);
				if (test == null || test.evaluate(x)) {
					if (x.ensureLoaded(loadComponent))
						return x;
				}
			}
		}
		return null;
	}
	public static DescriptionSearchable_c DescriptionSearchableInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return DescriptionSearchableInstance(modelRoot, test, true);
	}

	public static DescriptionSearchable_c DescriptionSearchableInstance(
			ModelRoot modelRoot) {
		return DescriptionSearchableInstance(modelRoot, null, true);
	}

	public static DescriptionSearchable_c[] DescriptionSearchableInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		if (loadComponent) {
			PersistenceManager.ensureAllInstancesLoaded(modelRoot,
					DescriptionSearchable_c.class);
		}
		InstanceList instances = modelRoot
				.getInstanceList(DescriptionSearchable_c.class);
		Vector matches = new Vector();
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				DescriptionSearchable_c x = (DescriptionSearchable_c) instances
						.get(i);
				if (test == null || test.evaluate(x)) {
					if (x.ensureLoaded(loadComponent))
						matches.add(x);
				}
			}
			if (matches.size() > 0) {
				DescriptionSearchable_c[] ret_set = new DescriptionSearchable_c[matches
						.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new DescriptionSearchable_c[0];
			}
		}
	}
	public static DescriptionSearchable_c[] DescriptionSearchableInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return DescriptionSearchableInstances(modelRoot, test, true);
	}
	public static DescriptionSearchable_c[] DescriptionSearchableInstances(
			ModelRoot modelRoot) {
		return DescriptionSearchableInstances(modelRoot, null, true);
	}

	public boolean delete() {
		boolean result = super.delete();
		boolean delete_error = false;
		String errorMsg = "The following relationships were not torn down by the Description Searchable.dispose call: ";
		SearchableElement_c testR9702Inst3 = SearchableElement_c
				.getOneSP_SEOnR9702(this, false);

		if (testR9702Inst3 != null) {
			delete_error = true;
			errorMsg = errorMsg + "9702 ";
		}
		if (delete_error == true) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.DELETE, "Description Searchable",
						errorMsg);
			} else {
				Exception e = new Exception();
				e.fillInStackTrace();
				CorePlugin.logError(errorMsg, e);
			}
		}
		return result;
	}

	// end declare instance pool

	// declare attribute accessors
	public boolean isUUID(String attributeName) {
		if (attributeName.equals("id")) {
			return true;
		}
		return false;
	}
	public String getCompUniqueID() {
		UUID tempID = null;
		long longID = 0L;
		StringBuffer result = new StringBuffer();

		tempID = getId();

		if (IdAssigner.NULL_UUID.equals(tempID))
			tempID = getIdCachedValue();
		result.append(Long.toHexString(tempID.getMostSignificantBits()));
		result.append(Long.toHexString(tempID.getLeastSignificantBits()));
		return result.toString();
	}
	// declare attribute accessors
	public long getIdLongBased() {
		if (IsSupertypeSearchableElement != null) {
			return IsSupertypeSearchableElement.getIdLongBased();
		}
		return 0;
	}
	public java.util.UUID getId() {
		if (IsSupertypeSearchableElement != null) {
			return IsSupertypeSearchableElement.getId();
		}
		return IdAssigner.NULL_UUID;
	}

	public boolean hasSuperType() {
		return (IsSupertypeSearchableElement != null);

	}

	public java.util.UUID getIdCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_id))
			return m_id;
		else
			return getId();
	}

	public void setId(java.util.UUID newValue) {
		if (newValue != null) {
			if (newValue.equals(m_id)) {
				return;
			}
		} else if (m_id != null) {
			if (m_id.equals(newValue)) {
				return;
			}
		} else {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this, "Id",
				m_id, newValue, true);
		m_id = IdAssigner.preprocessUUID(newValue);
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	public String getSearchablevalue() {
		return m_searchablevalue;
	}

	public void setSearchablevalue(String newValue) {
		if (newValue != null) {
			if (newValue.equals(m_searchablevalue)) {
				return;
			}
		} else if (m_searchablevalue != null) {
			if (m_searchablevalue.equals(newValue)) {
				return;
			}
		} else {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Searchablevalue", m_searchablevalue, newValue, true);
		m_searchablevalue = newValue;
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	// end declare accessors
	public static void checkClassConsistency(ModelRoot modelRoot) {
		Ooaofooa.log
				.println(ILogger.OPERATION, "Description Searchable", //$NON-NLS-1$
						" Operation entered: Description Searchable::checkClassConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return;
		}
		DescriptionSearchable_c[] objs = DescriptionSearchable_c
				.DescriptionSearchableInstances(modelRoot, null, false);

		for (int i = 0; i < objs.length; i++) {
			objs[i].checkConsistency();
		}
	}
	public boolean checkConsistency() {
		Ooaofooa.log.println(ILogger.OPERATION, "Description Searchable", //$NON-NLS-1$
				" Operation entered: Description Searchable::checkConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return true;
		}
		ModelRoot modelRoot = getModelRoot();
		boolean retval = true;
		class DescriptionSearchable_c_test39662_c
				implements
					ClassQueryInterface_c {
			DescriptionSearchable_c_test39662_c(java.util.UUID p39663) {
				m_p39663 = p39663;
			}
			private java.util.UUID m_p39663;
			public boolean evaluate(Object candidate) {
				DescriptionSearchable_c selected = (DescriptionSearchable_c) candidate;
				boolean retval = false;
				retval = (selected.getId().equals(m_p39663));
				return retval;
			}
		}

		DescriptionSearchable_c[] objs39661 = DescriptionSearchable_c
				.DescriptionSearchableInstances(modelRoot,
						new DescriptionSearchable_c_test39662_c(getId()));

		if (((objs39661.length) == 0)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Description Searchable", //$NON-NLS-1$
								"Consistency: Object: Description Searchable: Cardinality of an identifier is zero. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs39661.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Description Searchable: Cardinality of an identifier is zero. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs39661.length), e);
			}
			retval = false;

		}

		if (((objs39661.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Description Searchable", //$NON-NLS-1$
								"Consistency: Object: Description Searchable: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs39661.length)
										+ " Id: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Description Searchable: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs39661.length)
										+ " Id: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		// Description Searchable is a subtype in association: rel.Numb = 9702
		// The supertype class is: Searchable Element
		class SearchableElement_c_test39667_c implements ClassQueryInterface_c {
			SearchableElement_c_test39667_c(java.util.UUID p39668) {
				m_p39668 = p39668;
			}
			private java.util.UUID m_p39668;
			public boolean evaluate(Object candidate) {
				SearchableElement_c selected = (SearchableElement_c) candidate;
				boolean retval = false;
				retval = (selected.getId().equals(m_p39668));
				return retval;
			}
		}

		SearchableElement_c[] objs39666 = SearchableElement_c
				.SearchableElementInstances(modelRoot,
						new SearchableElement_c_test39667_c(getId()));

		if (((objs39666.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Description Searchable", //$NON-NLS-1$
								"Consistency: Object: Description Searchable: Association: 9702: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs39666.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Description Searchable: Association: 9702: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs39666.length), e);
			}
			retval = false;

		}

		return retval;
	}

	// declare transform functions
	public String Getsearchablevalue() {
		Ooaofooa.log
				.println(ILogger.OPERATION, "Description Searchable",
						" Operation entered: DescriptionSearchable::Getsearchablevalue");
		final ModelRoot modelRoot = getModelRoot();
		return "";

	} // End getSearchableValue

	// end transform functions

	public Object getAdapter(Class adapter) {
		Object superAdapter = super.getAdapter(adapter);
		if (superAdapter != null) {
			return superAdapter;
		}
		return null;
	}
} // end Description Searchable
