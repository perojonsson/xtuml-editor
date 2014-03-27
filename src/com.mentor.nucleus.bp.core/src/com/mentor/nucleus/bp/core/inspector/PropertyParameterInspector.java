package com.mentor.nucleus.bp.core.inspector;
//======================================================================
//
// File: com/mentor/nucleus/bp/core/inspector/PropertyParameterInspector.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/create_object_inspector.inc
// Version:      $Revision: 1.23 $
//
// (c) Copyright 2004-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================
//
// This class is responsible for decoupling the client model entity
// class PropertyParameter_c from the traversal mechanisms that it provides to
// model diff.
//
import com.mentor.nucleus.bp.core.*;

import org.eclipse.swt.graphics.Image;

import com.mentor.nucleus.bp.core.sorter.MetadataSortingManager;
import java.util.*;

/**
 * This file adapts the meta-model entity; 'PropertyParameter_c' to provide 
 * support of traversing to its children and parents.
 * <p>
 * Do not edit this class, it was created using the Mentor Graphics
 * MC-Java code generator product.
 * </p>
 */
public class PropertyParameterInspector extends BaseModelClassInspector {

  private String parentAssoc;
  
  public PropertyParameterInspector(MetadataSortingManager sortingManager){
    super(sortingManager);
  }

  /**
   * @see IModelClassInspector#getParent(Object)
   * Returns the parent(s) of this node
   */
  public Object getParent(Object arg) {
    InterfaceSignal_c result1 = InterfaceSignal_c.getOneC_ASOnR4004(ExecutableProperty_c.getOneC_EPOnR4006((PropertyParameter_c)arg));
     if (result1 != null) {
        return result1;
    }               
    InterfaceOperation_c result2 = InterfaceOperation_c.getOneC_IOOnR4004(ExecutableProperty_c.getOneC_EPOnR4006((PropertyParameter_c)arg));
     if (result2 != null) {
        return result2;
    }               
    ProvidedOperation_c result3 = ProvidedOperation_c.getOneSPR_POOnR4503(ProvidedExecutableProperty_c.getOneSPR_PEPOnR4501(ExecutableProperty_c.getOneC_EPOnR4006((PropertyParameter_c)arg)));
     if (result3 != null) {
        return result3;
    }               
    ProvidedSignal_c result4 = ProvidedSignal_c.getOneSPR_PSOnR4503(ProvidedExecutableProperty_c.getOneSPR_PEPOnR4501(ExecutableProperty_c.getOneC_EPOnR4006((PropertyParameter_c)arg)));
     if (result4 != null) {
        return result4;
    }               
    RequiredOperation_c result5 = RequiredOperation_c.getOneSPR_ROOnR4502(RequiredExecutableProperty_c.getOneSPR_REPOnR4500(ExecutableProperty_c.getOneC_EPOnR4006((PropertyParameter_c)arg)));
     if (result5 != null) {
        return result5;
    }               
    RequiredSignal_c result6 = RequiredSignal_c.getOneSPR_RSOnR4502(RequiredExecutableProperty_c.getOneSPR_REPOnR4500(ExecutableProperty_c.getOneC_EPOnR4006((PropertyParameter_c)arg)));
     if (result6 != null) {
        return result6;
    }               
        return null;    //No parent found           
  }
  	  
  /**
   * @see IModelClassInspector#getChildRelations(Object)
   * Returns the children of this node
   */
  public ObjectElement[] getChildRelations(Object arg) {
    int resultSize = 0;
    List<ObjectElement> result = new ArrayList<ObjectElement> ();
    return result.toArray(new ObjectElement[result.size()]);
  }
  /**
   * @see IModelClassInspector#hasChildren(Object)
   * Returns true if this node has any children
   */
  public boolean hasChildRelations(Object arg) {
    return false;
  }
  
  public Object[] getReferentialDetails(Class<?> referentialClass, Object arg) {
  	Object[] details = new Object[4];
	if(details[0] == null && referentialClass == DataType_c.class) {
		details[0] = DataType_c.getOneS_DTOnR4007(
(PropertyParameter_c)arg)
;



;
		details[1] = arg;
		details[2] = "4007";
		details[3] = "";
	}
	return details;
  }
  
  /**
  * @seee IModelClassInspector#getReferentials(Object)
  * Returns the an array of Role Objects specifying the referenctial attibutes of
  * this model element
  * Role Name: <T_TPS.NameOnly>
  * Role Value: <Chain_result>
  * Role Type: "Referential"
  */
  public ObjectElement[] getReferentials(Object arg) {
     List<ObjectElement> referentials = new ArrayList<ObjectElement>();
        Object referential = DataType_c.getOneS_DTOnR4007(
(PropertyParameter_c)arg)

;
     referentials.add(new ObjectElement ("referential_Type", ObjectElement.REFERENTIAL_ATTRIBUTE_ELEMENT, referential, arg, true));
    return referentials.toArray(new ObjectElement [referentials.size()]);        
  }

  /**
  * @seee IModelClassInspector#getAttributes(Object)
  * Returns the an array of Role objects that give the attibutes of the model 
  * element it self e.g.
  * Role Name: "Name"
  * Role Value: metaModelElement.getName()
  * Role Type: "Primitive"
  */
  public ObjectElement[] getAttributes(Object arg) {
    ObjectElement attrSet[] = new ObjectElement[8];
      attrSet[0] = new ObjectElement("Name", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getName"), arg, "getName", true);
      attrSet[1] = new ObjectElement("Descrip", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getDescrip"), arg, "getDescrip", true);
      attrSet[2] = new ObjectElement("By_Ref", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getBy_ref"), arg, "getBy_ref", true);
      attrSet[3] = new ObjectElement("Dimensions", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getDimensions"), arg, "getDimensions", true);
    ObjectElement compAttrSet[] = new ObjectElement[4];    
    for (int i = 0; i < 4 ; i++) {
        compAttrSet[i] = attrSet[i];
    }
    return compAttrSet;
  }

    /**
     * Return configured image if none exists for the element type
     */
    public Image getImage(Object element) {
		Image image = CorePlugin.getImageFor(element, false);
		if(image != null) {
			return image;
		}
		return CorePlugin.getImageFor("PropertyParameter.gif");
	}
    }       
