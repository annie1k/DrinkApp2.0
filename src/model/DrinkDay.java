package model;

import exceptions.BalanceNegativeException;
import exceptions.GoalNegativeException;
import exceptions.NegativeException;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

public class DrinkDay implements Writable {
    private String date;
    private int balance;
    private int goal;

    // MAKE IT MORE ROBUST, no negative
    // Constructor
    // EFFECTS: create a DrinkDay with given balance, goal and date
    public DrinkDay(int balanceI, int goalI, String dateI) throws NegativeException {
        if (balanceI < 0 || goalI < 0) {
            throw new NegativeException();
        }
        this.balance = balanceI;
        this.goal = goalI;
        this.date = dateI;
    }

    // MODIFIES: this
    // EFFECTS: change the goal by the amount
    public void changeGoal(int amount) throws GoalNegativeException {
        this.goal = goal + amount;
        if (this.goal < 0) {
            throw new GoalNegativeException();
        }
    }

    // MODIFIES: this
    // EFFECTS: change the balance by the amount
    public void changeBalance(int amount) throws BalanceNegativeException {
        this.balance = balance + amount;
        if (this.balance < 0) {
            throw new BalanceNegativeException();
        }
    }

    public String getDate() {
        return date;
    }

    public int getBalance() {
        return balance;
    }

    public int getGoal() {
        return goal;
    }

    // EFFECTS: check whether achieved the goal
    public boolean isAchieved() {
        return this.balance >= this.goal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrinkDay)) return false;
        DrinkDay drinkDay = (DrinkDay) o;
        return Objects.equals(date, drinkDay.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("date",date);
        jsonObject.put("goal",goal);
        jsonObject.put("balance",balance);
        return jsonObject;
    }
}
