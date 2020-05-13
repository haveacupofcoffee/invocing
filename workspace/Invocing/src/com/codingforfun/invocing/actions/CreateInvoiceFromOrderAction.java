package com.codingforfun.invocing.actions;

import com.codingforfun.invocing.model.Order;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

public class CreateInvoiceFromOrderAction extends ViewBaseAction {  //To use getView()
    @Override
    public void execute() throws Exception {
        //1. We use JPA to obtain the Order entity displayed in the view
        Order order = XPersistence.getManager().find(Order.class, getView().getValue("oid"));
        //2. The real work is delegated to the entity
       /* order.createInvoice();*/
        //3. In order to see the created invoice in 'Invoice' tab
        getView().refresh();
        //4. Confirmation message
        addMessage("invoice_created_from_order",order.getInvoice());

    }
}
