package com.motorolasolutions.motohunt;

public class QuestionData {

    private final String itemName;
    private final int itemImage;

    public QuestionData(String itemName, int itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

}
