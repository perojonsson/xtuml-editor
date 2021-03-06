package com.mentor.nucleus.bp.core.inspector;
//======================================================================
//
// File: com/mentor/nucleus/bp/core/inspector/LiteralSymbolicConstantInspector.java
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
// class LiteralSymbolicConstant_c from the traversal mechanisms that it provides to
// model diff.
//
import com.mentor.nucleus.bp.core.*;

import org.eclipse.swt.graphics.Image;

import com.mentor.nucleus.bp.core.sorter.MetadataSortingManager;
import java.util.*;

/**
 * This file adapts the meta-model entity; 'LiteralSymbolicConstant_c' to provide 
 * support of traversing to its children and parents.
 * <p>
 * Do not edit this class, it was created using the Mentor Graphics
 * MC-Java code generator product.
 * </p>
 */
public class LiteralSymbolicConstantInspector extends BaseModelClassInspector {

  private String parentAssoc;
  
  public LiteralSymbolicConstantInspector(MetadataSortingManager sortingManager){
    super(sortingManager);
  }

  /**
   * @see IModelClassInspector#getParent(Object)
   * Returns the parent(s) of this node
   */
  public Object getParent(Object arg) {
    ConstantSpecification_c result1 = ConstantSpecification_c.getOneCNST_CSPOnR1504(SymbolicConstant_c.getOneCNST_SYCOnR1502(LeafSymbolicConstant_c.getOneCNST_LFSCOnR1503((LiteralSymbolicConstant_c)arg)));
     if (result1 != null) {
        return result1;
    }               
        return null;    //No parent found           
  }
  	  
  /**
   * @see IModelClassInspector#getChildRelations(Object)
   * Returns the children of this node
   */
  public ObjectElement[] getChildRelations(Object arg) {
    int resultSize = 0;
    SymbolicConstant_c [] v_symbolicconstant = 
SymbolicConstant_c.getManyCNST_SYCsOnR1502(
LeafSymbolicConstant_c.getManyCNST_LFSCsOnR1503(
(LiteralSymbolicConstant_c)arg)
)
;



    sort(v_symbolicconstant);
    List<ObjectElement> result = new ArrayList<ObjectElement> ();
    for (int i = 0 ; i < v_symbolicconstant.length ; i++) {   
        result.add(new ObjectElement("v_symbolicconstant", ObjectElement.RELATION_ROLE_ELEMENT, v_symbolicconstant[i], arg, false));
    }
    return result.toArray(new ObjectElement[result.size()]);
  }
  /**
   * @see IModelClassInspector#hasChildren(Object)
   * Returns true if this node has any children
   */
  public boolean hasChildRelations(Object arg) {
    SymbolicConstant_c [] v_symbolicconstant = 
SymbolicConstant_c.getManyCNST_SYCsOnR1502(
LeafSymbolicConstant_c.getManyCNST_LFSCsOnR1503(
(LiteralSymbolicConstant_c)arg)
)
;



    if (v_symbolicconstant.length > 0) return true;
    return false;
  }
  
  public Object[] getReferentialDetails(Class<?> referentialClass, Object arg) {
  	Object[] details = new Object[4];
	if(details[0] == null && referentialClass == DataType_c.class) {
		details[0] = DataType_c.getOneS_DTOnR1500(
SymbolicConstant_c.getOneCNST_SYCOnR1502(
LeafSymbolicConstant_c.getOneCNST_LFSCOnR1503(
(LiteralSymbolicConstant_c)arg)
)
)
;



;
		details[1] = arg;
		details[2] = "1500";
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
        Object referential = DataType_c.getOneS_DTOnR1500(
SymbolicConstant_c.getOneCNST_SYCOnR1502(
LeafSymbolicConstant_c.getOneCNST_LFSCOnR1503(
(LiteralSymbolicConstant_c)arg)
)
)

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
    ObjectElement attrSet[] = new ObjectElement[3];
      attrSet[0] = new ObjectElement("Value", ObjectElement.ATTRIBUTE_ELEMENT,  invokeMethod(arg, "getValue"), arg, "getValue", true);
    ObjectElement compAttrSet[] = new ObjectElement[1];    
    for (int i = 0; i < 1 ; i++) {
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
		return CorePlugin.getImageFor("Enumerator.gif");
	}

  /**
  * Returns a "slot number" to be used when comparing and merging tree elements
  * that contain multiple children.  All model element inspector's contain this 
  * function, but it only returns a value for cases where it a parent element
  * in a tree and the parent has multiple children.
  * 
  * @returns 0 if this is not a "parent" in the tree OR if the parent has less 
  * than 2 children. 
  */
	@Override
	public int getTreeDifferenceSlot(Object element) {
    	if (element instanceof SymbolicConstant_c) {
			return 1;
		}
    	if (element instanceof DataType_c) {
			return 2;
		}
		return 0;
	}

	}       

