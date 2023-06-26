package com.geli.ecommerce.request;

import java.util.List;

public class StoreRequest {

    private Integer storeId;
    private String storeName;
    private String storeAddress;
    private List<StoreItemRequest> storeItemList;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public List<StoreItemRequest> getStoreItemList() {
        return storeItemList;
    }

    public void setStoreItemList(List<StoreItemRequest> storeItemList) {
        this.storeItemList = storeItemList;
    }
}

