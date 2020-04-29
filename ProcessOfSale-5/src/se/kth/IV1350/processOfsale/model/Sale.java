package se.kth.IV1350.processOfsale.model;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;
import se.kth.IV1350.processOfsale.integration.Catalog;


import java.util.ArrayList;


/**
 * Represents the entire salelog and information of every item the customer has bought
 */
public class Sale {

    private Receipt receipt;
    private double totalPayment;
    private ArrayList<Item> storedItems = new ArrayList<>();

    /**
     * Creates a new instance
     */
    public Sale (Sale sale, Change change, double totalPayment) {

        receipt = new Receipt(sale, change, totalPayment);

    }


    /**
     * Calculates the payment which is to be provided by the customer for the selected item.
     *
     * @param itemIdentification Contains the information needed to calculate the price per selected item.
     * @return The price per selected item.
     */

    public double calculatePaymentPerItem (int itemIdentification) {

        ItemDTO itemone = Catalog.getDescription(itemIdentification);

      double pricePerItem = itemone.getPrice();
      double itemVat = itemone.getVatRate();

      double totalPricePerItem = (pricePerItem * itemVat) + pricePerItem; //* quantityOfItem);

        return totalPayment += totalPricePerItem;

    }

    /**
     * Gets the total payment required from the customer
     *
     * @return The total amount to be paid by the customer
     */
    public double getTotalPayment (){

        return totalPayment;
    }

    /**
     * Creates an object of the receipt
     *
     * @param sale Information regarding the entire sale
     * @param change Change for the customer
     * @param totalPayment Total amount to be paid by the customer
     *
     * @return The receipt
     */
    public Receipt receipt (Sale sale, Change change, double totalPayment){

        receipt = new Receipt(this, change, totalPayment);

        return receipt;
    }

    /**
     * Stores the item in the sale log
     *
     * @param itemIdentification The barcode of the item
     *
     * @return The list of all bought items
     */
    public ItemDTO storeItemInSale (int itemIdentification) {

        Item item = new Item (itemIdentification, 1);

        boolean found = false;

        for (Item storedItem : storedItems) {

            if (storedItem == item) {

                storedItem.addOneToQuantity();
                found = true;
            }
        }

        if (found == false) {
            storedItems.add(item);
        }

        return item.getItemDTO();
    }

    /**
     * Gets the list of all bought items
     *
     * @return The list of all items
     */
    public ArrayList <Item> getStoredItems (){

        return storedItems;
    }


    /**
     * Creates a string of the entire list of bought items
     *
     * @return The list of items in a string format
     */
    public String saleString () {

        StringBuilder saleBuilder = new StringBuilder();

        for (Item storedItem : storedItems) {

            saleBuilder.append(storedItem.toString()+ "\n");

        }
            return saleBuilder.toString();
        }

    }
