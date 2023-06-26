package com.geli.ecommerce.controller;


import com.geli.ecommerce.model.Store;
import com.geli.ecommerce.model.StoreItem;
import com.geli.ecommerce.request.AddStoreitemToStore;
import com.geli.ecommerce.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/storeitems")
public class StoreItemController {


    @Autowired
    private StoreItemService storeItemService;

    @PostMapping("/add")
    public String addStoreItem(@RequestBody AddStoreitemToStore addStoreitemToStore){
        Integer storeId = addStoreitemToStore.getStoreId();
        Integer storeItemId = addStoreitemToStore.getStoreItemId();
        return storeItemService.saveStoreItemToStore(storeItemId, storeId );
    }

    @PostMapping("/addItem")
    public StoreItem createStoreItem(@RequestBody StoreItem storeItem){
        return storeItemService.saveStoreItem(storeItem);
    }

    @PostMapping("/addList")
    public String addStoreItemList(@RequestBody List<StoreItem> storeItemList){
        return storeItemService.saveStoreItem(storeItemList);
    }

    @GetMapping("/getAllItems")
    public List<StoreItem> getStoreAllItems(){
        return storeItemService.findAllStoreItems();
    }

    @GetMapping("/{id}")
    public StoreItem getStoreItem(@PathVariable(name="id") int id){
        return storeItemService.findStoreItemById(id);
    }

    @DeleteMapping ("/deleteItem/{id}")
    public String deleteStoreItem(@PathVariable(name="id") int id){
        return storeItemService.deleteStoreItem(id);
    }

    @PutMapping("/editItem/{id}")
    public StoreItem updateStoreItem(@PathVariable(name = "id") int id,@RequestBody StoreItem storeItem) throws Exception {
        StoreItem updatedItem = storeItemService.updateStoreItem(id, storeItem);
        return updatedItem;

    }
}