package se.kth.IV1350.processOfsale.model;


/**
 * The change for the customer
 */
public class Change {

    private double change;
    private Sale sale;

    /**
     * Calculates the change for the customer
     *
     * @param cashFromCustomer The money given by the customer
     *
     * @return The change
     */
    public double calculateChange (double cashFromCustomer){

        double payment = sale.getTotalPayment();
        double recievedCash = cashFromCustomer;

       change = (recievedCash - payment);

       return change;

    }
}
