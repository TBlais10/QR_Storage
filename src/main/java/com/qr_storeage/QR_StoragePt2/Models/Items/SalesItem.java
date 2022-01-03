package com.qr_storeage.QR_StoragePt2.Models.Items;

import com.qr_storeage.QR_StoragePt2.Models.Locations.Location;

public class SalesItem extends Item {

    private int price;

    public SalesItem() {
    }

    public SalesItem(Location location, String name, String description, Long quantity, String cond, String type, String color, String serialNumber, int price) {
        super(location, name, description, quantity, cond, type, color, serialNumber);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
