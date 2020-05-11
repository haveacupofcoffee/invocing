package com.codingforfun.invocing.actions;

import org.openxava.actions.IChainAction;
import org.openxava.actions.SearchAction;
import org.openxava.actions.ViewBaseAction;
import org.openxava.model.MapFacade;

import java.util.HashMap;
import java.util.Map;

public class InvoicingDeleteAction extends ViewBaseAction implements IChainAction {  // It chains to another action, returned by getNextAction() method

    private String nextAction = null;  // To store the next action to execut

    @Override
    public void execute() throws Exception {
        if(!getView().getMetaModel().containsMetaProperty("deleted")) {
            nextAction = "CRUD.delete";  // 'CRUD.delete' will be executed
            return;   // after this action finishes
        }
        Map<String, Object> values =
                new HashMap<String, Object>(); // The values to modify in the entity
        values.put("deleted", true); // We set true to 'deleted' property
        MapFacade.setValues( // Modifies the values of the indicated entity
                getModelName(), // A method from ViewBaseAction
                getView().getKeyValues(), // The key of the entity to modify
                values); // The values to change
        resetDescriptionsCache(); // Clears the caches for combos
        addMessage("object_deleted", getModelName());
        getView().clear();
        getView().setKeyEditable(true);
        getView().setEditable(false); // The view is left as not editable

    }


    @Override
    public String getNextAction() throws Exception {   // Required because of IChainAction
        return nextAction;  // If null no action will be chained
    }
}
