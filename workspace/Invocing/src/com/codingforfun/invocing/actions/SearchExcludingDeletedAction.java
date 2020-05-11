package com.codingforfun.invocing.actions;

import org.openxava.actions.SearchByViewKeyAction;

import javax.ejb.ObjectNotFoundException;
import java.util.Map;

public class SearchExcludingDeletedAction extends SearchByViewKeyAction {  // The standard OpenXava action to search

    private boolean isDeletable( ) {  // To see if this entity has a deleted property
        return getView().getMetaModel().containsMetaProperty("deleted");
    }

    @Override
    protected Map getMemberNames() throws Exception {  // The members to be read from the entity
        if (!isDeletable()) {  // If not deletable we run the standard logic
            Map<String, Object> memberNames = super.getMemberNames();
            System.out.println("Without deleted property -- getMemberNames : " + memberNames );
            return memberNames;
        }
        Map<String, Object> members = super.getMemberNames();
        System.out.println("With deleted property -- getMemberNames : " + members );
        members.put("deleted", null);   // We want to get the deleted property from entity, though it might not be in the view
        return members;

    }
    @Override
    protected Map getValuesFromView() throws Exception {  // Gets the values displayed in this view, These values are used as keys for the search
        if(!isDeletable()) {   // If not deletable we run the standard logic
            Map values = super.getValuesFromView();
            System.out.println("Without deleted property -- getValuesFromView : " + values );
            return values;
        }
        Map<String, Object> values = super.getValuesFromView();

        values.put("deleted", false);   // We populate deleted property with false
        System.out.println("With deleted property -- getValuesFromView : " + values );
        return values;
    }


    @Override
    protected void setValuesToView(Map values) throws Exception {   // Assigns the values from the entity to the view
        System.out.println("set values to views :" + values);
        if(isDeletable() && (Boolean)values.get("deleted")) {  //if it has an deleted property and it is true
            throw  new ObjectNotFoundException();  //The same exception OpenXava throws when the object is not found
        }else {
            super.setValuesToView(values);  //Otherwise we run the standard logic
        }

    }
}
