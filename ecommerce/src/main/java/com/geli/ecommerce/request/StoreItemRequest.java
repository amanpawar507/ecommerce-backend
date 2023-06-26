package com.geli.ecommerce.request;
import jakarta.persistence.Column;


public class StoreItemRequest {

    private Integer id;

    private String itemCategory;

    private String itemDescription;

    private String itemImageUrl;

    private String itemName;

    private Double itemPrice;

    private Integer itemQuantity;

    private Integer storeId;


    public String getItemCategory(){return itemCategory;}

    public void setItemCategory(String itemCategory){
        this.itemCategory = itemCategory;
    }
    public String getItemDescription(){return itemDescription;}

    public void setItemDescription(String itemDescription){
        this.itemDescription = itemDescription;
    }

    public String getItemImageUrl(){return itemImageUrl;}

    public void setItemImageUrl(String itemImageUrl){
        this.itemImageUrl = itemImageUrl;
    }

    public String getItemName(){return itemName;}

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public Double getItemPrice(){return itemPrice;}

    public void setItemPrice(Double itemPrice){
        this.itemPrice = itemPrice;
    }

    public Integer getItemQuantity(){return itemQuantity;}

    public void setItemQuantity(Integer itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    public Integer getStoreId(){return storeId;}

    public void setsStoreId(Integer storeId){
        this.storeId = storeId;
    }

}
