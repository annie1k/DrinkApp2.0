package model;

import exceptions.UnaffordableException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.HashSet;
import java.util.Set;

public class Bag implements Writable {
    private Set<Goods> bag;
    private int coins;

    // Constructor
    // EFFECTS: construct a Bag takes History and empty collection of medals
    public Bag(History history) {
        this.bag = new HashSet<>();
        this.coins = history.numAchieved();
    }

    // MODIFIES: this
    // EFFECTS:buy given goods to the bag
    public void buyGoods(Goods goods) throws UnaffordableException {
        if (!goods.ableToBuy(this)) {
            throw new UnaffordableException();
        }
        this.bag.add(goods);
        this.subCoin(goods.getPrice());
    }


    // EFFECTS: return true is the coin owned sufficient for buying
    public boolean isCoinEnough(int price) {
        return this.coins >= price;
    }

    // MODIFIES: this.coins
    // EFFECTS: subtract the coin by number given
    public void subCoin(int num) {
        this.coins = coins - num;
    }

    public Set<Goods> getBag() {
        return bag;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("coins",coins);
        json.put("items", goodsToJson());
        return json;
    }

    // return a list of json arraylist that consisted by list of goods to jsonObjects
    private JSONArray goodsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Goods g : bag) {
            jsonArray.put(g.toJson());
        }
        return jsonArray;
    }


}
