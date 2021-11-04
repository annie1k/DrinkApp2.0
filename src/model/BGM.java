package model;

import org.json.JSONObject;

import java.util.Objects;

import static model.Category.BGM;

public class BGM extends Goods {
    private String bgm;
    private int price;
    private Category category;

    // Constructor
    // EFFECTS: set the bgm address to be bgm, and price to be price
    public BGM(String category, String bgm, int price) {
        super(category,bgm,price);
        this.category = BGM;
        this.bgm = bgm;
        this.price = price;
    }

    // EFFECTS: get the category of this
    public Category getCategory() {
        return category;
    }

    // EFFECTS: get the string address of the bgm
    public String getName() {
        return bgm;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BGM)) return false;
        BGM bgm1 = (BGM) o;
        return Objects.equals(bgm, bgm1.bgm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bgm);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("category", category);
        json.put("goods", bgm);
        json.put("price", price);
        return json;
    }
}
