package com.geli.ecommerce.service;

import com.geli.ecommerce.model.Customer;
import com.geli.ecommerce.model.OrderItem;
import com.geli.ecommerce.model.Store;
import com.geli.ecommerce.model.StoreItem;
import com.geli.ecommerce.repository.StoreItemRepository;
import com.geli.ecommerce.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreItemService {

    @Autowired
    private StoreItemRepository storeItemRepository;
    @Autowired
    private StoreRepository storeRepository;

    public StoreItem saveStoreItem(StoreItem storeItem){
        return storeItemRepository.save(storeItem);
    }

    public String saveStoreItem(List<StoreItem> storeItemList){
        storeItemRepository.saveAll(storeItemList);
        return "All store Item saved";
    }

    public StoreItem findStoreItemById(Integer storeItemId){
        Optional<StoreItem> storeItem = storeItemRepository.findById(storeItemId);
        if(storeItem.isPresent()){
            return storeItem.get();
        }
        return null;
    }

    public List<StoreItem> findAllStoreItems(){
        return storeItemRepository.findAll();
    }

    public String deleteStoreItem(int id) {
        storeItemRepository.deleteById(id);
        return "item with id "+id+" is deleted";
    }


    public StoreItem updateStoreItem(int id, StoreItem storeItem) throws Exception {
        Optional<StoreItem> optionalItem = storeItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            StoreItem existingItem = optionalItem.get();
            existingItem.setItemName(storeItem.getItemName());
            existingItem.setItemPrice(storeItem.getItemPrice());
            existingItem.setItemDescription(storeItem.getItemDescription());
            existingItem.setItemQuantity(storeItem.getItemQuantity());
            existingItem.setItemCategory(storeItem.getItemCategory());
            existingItem.setItemImageURL(storeItem.getItemImageURL());
            existingItem.setStore(storeItem.getStore());

            StoreItem updatedItem = storeItemRepository.save(existingItem);
            return updatedItem;

        } else {
            throw new Exception("User not found with id: " + id);
        }
    }

    public String saveStoreItemToStore(Integer storeItemId, Integer storeId){
        Store store = storeRepository.findById(storeId).orElse(null);
        StoreItem storeItem = storeItemRepository.findById(storeItemId).orElse(null);
        storeItem.setStore(store);
        storeItemRepository.save(storeItem);
        List<StoreItem> storeItemList = store.getStoreItemList();
        storeItemList.add(storeItem);
        store.setStoreItemList(storeItemList);
        storeRepository.save(store);
        return "ITEM ADDED TO STORE";
    }
}
