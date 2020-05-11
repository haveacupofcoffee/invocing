package com.codingforfun.invocing.actions;

import com.codingforfun.invocing.model.Invoice;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

public class DeleteInvoiceAction
        extends ViewBaseAction { // ViewBaseAction has getView(), addMessage(), etc

    public void execute() throws Exception { // The logic of the action
/*        addMessage( // Add a message to show to the user, You can either add the message to show or an id of an entry in i18n/Invoicing-messages_en.properties.
                "Don't worry! I have cleared only the screen");
        getView().clear(); // getView() returns the xava_view object
        // clear() clears the data in user interace*/
        Invoice invoice = XPersistence.getManager().find(Invoice.class, getView().getValue("oid"));
        /*invoice.setDeleted(true);*/
        addMessage("object_deleted", "Invoice");
        System.out.println("View Key Values are : "+ getView().getKeyValues());
        getView().clear();
        getView().setKeyEditable(true);  //can't see delete button
    }
}
