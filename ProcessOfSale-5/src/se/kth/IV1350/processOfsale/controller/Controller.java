package se.kth.IV1350.processOfsale.controller;

import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.integration.Printer;
import se.kth.IV1350.processOfsale.model.*;
import se.kth.IV1350.processOfsale.model.Change;

import java.util.ArrayList;


/**
 * This is the applications only controller, all calls to the model pass through this class.
 */
public class Controller {

    private Sale sale;
    private double totalpriceinclvat;
    private ArrayList <Item> storedItems;
    private Change change;
    private double changeToCustomer;
    private Printer printer;
    private Receipt receipt;
    private double totalPayment;
    private ItemDTO itemDTO;
    private Item item;
    private double amountPaid;




    /**
     * Starts a new sale, and this method must be called first before doing anything else during sale.
     */
    public void startNewSale (){

        sale = new Sale (sale, change, totalPayment);
    }

    /**
     * Scans the specific item selected by the customer.
     *
     * @param itemIdentification The specific items barcode.
     *
     * @return The description of the selected item.
     */

    public ItemDTO entersItemIdentifier (int itemIdentification){

        return sale.storeItemInSale(itemIdentification);

    }

    /**
     * Ends the sale
     *
     * @param itemIdentification The last item on the counter
     *
     * @return The amount to be paid by the customer
     */
    public double endsCurrentSale (int itemIdentification){

     return totalpriceinclvat = sale.calculatePaymentPerItem(itemIdentification);

    }

    /**
     * Customer gives money to the cashier
     *
     * @param cashFromCustomer The amount given by the customer
     *
     * @return Verification of customer giving money
     */

    public double entersAmountPaid (double cashFromCustomer){

              return cashFromCustomer;

    }

    /**
     * Calculates the change that is to be given to the customer
     *
     * @param cashFromCustomer The amount given by the customer
     *
     * @return The change for the customer
     */
    public double calculationOfChange (double cashFromCustomer){

       return change.calculateChange(cashFromCustomer);

    }

    /**
     * The receipt for the customer
     *
     * @return The receipt
     */
    public Receipt printOutReceipt (){

        Receipt receipt = new Receipt(sale, change, sale.getTotalPayment());

        printer.printReceipt(receipt);

        return receipt;
    }
}
