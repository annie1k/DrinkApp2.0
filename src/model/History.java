package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.HashSet;
import java.util.Set;

public class History implements Writable {
    private Set<DrinkDay> history;

    // Construction
    // EFFECTS: construct an empty history list of drinkDays
    public History() {
        this.history = new HashSet<>();
    }

    // MODIFIES: this
    // EFFECTS: add given day to the list of history
    public void addDay(DrinkDay day) {
        this.history.add(day);
    }


    // EFFECTS: return the number of days that achieve their goal
    public int numAchieved() {
        int num = 0;
        for (DrinkDay day: history) {
            if (day.isAchieved()) {
                num++;
            }
        }
        return num;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("history", historyToJson());
        return jsonObject;
    }

    private JSONArray historyToJson() {
        JSONArray jsonArray = new JSONArray();

        for (DrinkDay d : history) {
            jsonArray.put(d.toJson());
        }
        return jsonArray;
    }
}
