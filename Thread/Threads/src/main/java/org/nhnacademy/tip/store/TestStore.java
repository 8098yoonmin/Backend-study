package org.nhnacademy.tip.store;

public class TestStore {
    public static void main(String[] args) {
//        Store store = new Store();
//        Seller seller = new Seller(store);
//        Buyer [] buyers = new Buyer[10];
//
//        for(int i=0; i< buyers.length; i++) {
//            buyers[i] = new Buyer("손님" + i, store);
//            buyers[i].start();
//        }
//
//        seller.start();
        Store[] stores = new Store[5];
        Buyer[] buyers = new Buyer[5];


        for (int j = 0; j < stores.length; j++) {
            stores[j] = new Store(j + "번째 매장");
            Seller seller = new Seller(stores[j]);
            for (int i = 0; i < buyers.length; i++) {
                buyers[i] = new Buyer("손님" + i, stores[j]);
                buyers[i].start();
            }
            seller.start();
        }
    }
}
