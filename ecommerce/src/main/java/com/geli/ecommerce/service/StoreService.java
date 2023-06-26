package com.geli.ecommerce.service;

import com.geli.ecommerce.model.Store;
import com.geli.ecommerce.repository.StoreRepository;
import com.geli.ecommerce.request.StoreRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;


    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(int storeId) throws ChangeSetPersister.NotFoundException {
        Store store = storeRepository.findById(storeId).orElse(null);
        System.out.println(store);
        return store;
    }

    public Store createStore(StoreRequest storeRequest) {
        Store store = new Store();
        store.setStoreName(storeRequest.getStoreName());
        store.setStoreAddress(storeRequest.getStoreAddress());
        return storeRepository.save(store);
    }

//    public Store updateStoreById(int storeId, Store storeRequest) throws ChangeSetPersister.NotFoundException {
//        Optional<Store> optionalStore = storeRepository.findById(storeId);
//        if (optionalStore.isPresent()) {
//            Store store = optionalStore.get();
//            store.setStoreName(storeRequest.getStoreName());
//            store.setStoreAddress(storeRequest.getStoreAddress());
//            return storeRepository.save(store);
//        } else {
//            throw new ChangeSetPersister.NotFoundException();
//        }
//    }
//
//    public void deleteStoreById(int storeId) throws ChangeSetPersister.NotFoundException {
//        Optional<Store> optionalStore = storeRepository.findById(storeId);
//        if (optionalStore.isPresent()) {
//            storeRepository.delete(optionalStore.get());
//        } else {
//            throw new ChangeSetPersister.NotFoundException();
//        }
//    }
}
