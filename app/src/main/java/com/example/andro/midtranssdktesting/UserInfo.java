package com.example.andro.midtranssdktesting;

import com.midtrans.sdk.corekit.models.BillingAddress;
import com.midtrans.sdk.corekit.models.ItemDetails;
import java.util.ArrayList;

public class UserInfo {

    public static ArrayList<BillingAddress> getListBillingAddress() {
        ArrayList<BillingAddress> billingAddressArrayList = new ArrayList<>();
        billingAddressArrayList.add(getBillingAddress());
        return billingAddressArrayList;
    }

    public static ArrayList<ItemDetails> getListItemDetails() {
        ArrayList<ItemDetails> itemDetails = new ArrayList<>();
        itemDetails.add(new ItemDetails("1", 5000, 1, "Item 1"));
        itemDetails.add(new ItemDetails("2", 1000, 5, "Item 2"));
        return itemDetails;
    }

    public static BillingAddress getBillingAddress() {
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setAddress("jalan kalangan");
        billingAddress.setCity("yogyakarta");
        billingAddress.setCountryCode("IDN");
        billingAddress.setPostalCode("72168");
        billingAddress.setFirstName("User Tester");
        billingAddress.setPhone("12345678");
        return billingAddress;
    }
}
