package se.kth.IV1350.processOfsale.view;

import se.kth.IV1350.processOfsale.controller.Controller;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.model.*;

/**
 * This is a placeholder for the real view, it contains hardcoded execution calls to all system operations in
 * the controller.
 */

public class View {

    private int itemIdentification;
    private Sale sale;
    private String storedItems;
    private Receipt receipt;
    private Change change;

    private Controller contr;

    /**
     * The construction of the View, creates a new instance that uses the specified controller for all calls to
     * other layers.
     *
     * @param contr The controller to use for all calls to other layers.
     */
    public View (Controller contr) {

        this.contr = contr;
    }

    /**
     * Performs a fake sale by calling all system operations in the controller.
     */
    public void runFakeExecution (){

        contr.startNewSale();

        System.out.println("                    ");
        System.out.println("          Welcome To The Store");
        System.out.println("          --------------------");
        System.out.println("                    ");


        System.out.println("                           ");
        System.out.println("           Your Selected Items");
        System.out.println("******************************************");
        System.out.println("                    ");

        ItemDTO firsttItem = contr.entersItemIdentifier (12222113);
        System.out.println("Item has been identified: " + firsttItem.getItemDescription());
        System.out.println("Price: " + firsttItem.getPrice());
        System.out.println("VAT: " + firsttItem.getVatRate());

        System.out.println("                                  ");

        ItemDTO secondItem = contr.entersItemIdentifier (14234442);
        System.out.println("Item has been identified: " + secondItem.getItemDescription());
        System.out.println("Price: " + secondItem.getPrice());
        System.out.println("VAT: " + secondItem.getVatRate());

        System.out.println("                                  ");

        ItemDTO thirdItem = contr.entersItemIdentifier (17737733);
        System.out.println("Item has been identified: " + thirdItem.getItemDescription());
        System.out.println("Price: " + thirdItem.getPrice());
        System.out.println("VAT: " + thirdItem.getVatRate());

        System.out.println("                                  ");

        double priceAfterFirstItem = contr.endsCurrentSale(17737733);
        double priceAfterSecondItem = contr.endsCurrentSale(14234442);
        double priceAfterThirdItem = contr.endsCurrentSale(12222113);
        System.out.println("            Running Total");
        System.out.println("******************************************");
        System.out.println("\n" + "Price So Far: " + priceAfterFirstItem + "\n" + "Price So Far: " + priceAfterSecondItem + "\n" +"*Your Sale has ended*" + "\n" +"\n" + "Total Amount To Pay: " + priceAfterThirdItem);

        double paidAmount = contr.entersAmountPaid(500);
        System.out.println("Customer has paid: " + paidAmount);
        System.out.println("                    ");


        double change = contr.calculationOfChange(500);
        System.out.println("Change to give customer: " + change);

        Receipt receipt = contr.printOutReceipt();
        System.out.println("Completed Sale" + receipt.createReceipt());

    }


}
