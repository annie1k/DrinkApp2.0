package model;

import persistence.Writable;

public abstract class Goods implements Writable {
    private Goods goods;
    private int price;
    private String address;
    private String category;

    public Goods(String category, String address, int price) {
        this.address = category;
        this.address = address;
        this.price = price;
    }

    abstract String getName();

    abstract int getPrice();

    //EFFECTS: check if coin enough to buy the goods and haven't buy it yet
    public boolean ableToBuy(Bag bag) {
        if (bag.isCoinEnough(goods.getPrice())) {
            for (Goods goods: bag.getBag()) {
                if (!bag.getBag().contains(goods)) {
                    return true;
                }
            }
        }
        return false;
    }


}
