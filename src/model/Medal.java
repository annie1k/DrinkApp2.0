package model;

import org.json.JSONObject;

import java.util.Objects;

import static model.Category.MEDAL;

public class Medal extends Goods {
    private String medal;
    private Category category;
    private int price;

    // Constructor
    // EFFECTS: set the image address to be image, and price to be price
    public Medal(String category, String medal, int price) {
        super(category,medal,price);
        this.category = MEDAL;
        this.medal = medal;
        this.price = price;
    }

    // EFFECTS: get the string address of the img
    public String getName() {
        return medal;
    }

    // EFFECTS: get the category of this
    public Category getCategory() {
        return category;
    }

    // EFFECTS: get the price of this medal
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medal)) return false;
        Medal medal1 = (Medal) o;
        return Objects.equals(medal, medal1.medal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medal);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("category", category);
        json.put("goods", medal);
        json.put("price", price);
        return json;
    }
}
