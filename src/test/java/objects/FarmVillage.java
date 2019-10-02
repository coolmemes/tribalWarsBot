package objects;

import java.time.LocalDateTime;

public class FarmVillage implements Comparable<FarmVillage>{

    private String name;
    private int x;
    private int y;
    private String userID;
    int points;
    int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getUserID() {
        return userID;
    }

    public int getPoints() {
        return points;
    }

    public String getTypeOfBonus() {
        return typeOfBonus;
    }

    public LocalDateTime getLastAttack() {
        return lastAttack;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    String typeOfBonus;
    LocalDateTime lastAttack;
    Boolean isEmpty;

    public String getName() {
        return name;
    }

    public FarmVillage(String name, int x, int y, String userID, int points, String typeOfBonus) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.userID = userID;
        this.points = points;
        this.typeOfBonus = typeOfBonus;
    }

    @Override
    public int compareTo(FarmVillage o) {
        return (getDistance() - o.getDistance());
    }
}
