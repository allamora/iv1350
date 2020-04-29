package se.kth.IV1350.processOfsale.integration;
import se.kth.IV1350.processOfsale.DTO.ItemDTO;


public class Catalog {

    /**
     * The Catalog
     *
     * @param itemIdentification The barcode of the selected item
     *
     * @return The description of the selected item
     */

    public static ItemDTO getDescription (int itemIdentification) {

        if (itemIdentification == 12222113)
            return new ItemDTO("Jordgubbar", 0.12, 60);

        if (itemIdentification == 14234442)
            return new ItemDTO("Korv", 0.06, 30);

        if (itemIdentification == 17737733)
            return new ItemDTO("Mjölk", 0.04, 20);

        return null;

    }
}