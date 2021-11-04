package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.HashSet;
import java.util.Set;

public class Shop implements Writable {
    private Set<Goods> goods;

    public Shop() {
        this.goods = new HashSet<>();
    }

    public void addGoods(Goods g) {
        goods.add(g);
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("shop", shopToJson());
        return jsonObject;
    }

    private JSONArray shopToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Goods g : goods) {
            jsonArray.put(g.toJson());
        }
        return jsonArray;
    }
}
