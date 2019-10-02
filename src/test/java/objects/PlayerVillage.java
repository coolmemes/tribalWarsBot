package objects;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PlayerVillage {
    private String name;
    private int ID;
    private int x;
    private int y;

    public int getOutcomingAttackCounter() {
        return outcomingAttackCounter;
    }

    public void increaseOutComeAttacks() {
        if (outcomingAttackCounter < targetList.size()) {
            outcomingAttackCounter++;
        } else {
            outcomingAttackCounter = 0;
        }

    }

    public void setOutcomingAttackCounter(int outcomingAttackCounter) {
        this.outcomingAttackCounter = outcomingAttackCounter;
    }

    public ArrayList<String> getTargetList() {
        return targetList;
    }

    public void setTargetList(ArrayList<String> targetList) {
        this.targetList = targetList;
    }

    private int outcomingAttackCounter;
    private ArrayList<String> targetList = new ArrayList<>();

    private int townHallLevel;
    private int barracksLevel;
    private int cathedralLevel;
    private int areaLevel;
    private int statueLevel;
    private int marketLevel;
    private int sawmillLevel;
    private int clayquarryLevel;
    private int ironMineLevel;
    private int homesteadLevel;
    private int warehouseLevel;
    private int cacheLevel;
    private int stableLevel;
    private int garageLevel;
    private int snobLevel;
    private int smithLevel;
    private int wallLevel;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTownHallLevel() {
        return townHallLevel;
    }

    public void setTownHallLevel(int townHallLevel) {
        this.townHallLevel = townHallLevel;
    }

    public int getBarracksLevel() {
        return barracksLevel;
    }

    public void setBarracksLevel(int barracksLevel) {
        this.barracksLevel = barracksLevel;
    }

    public int getCathedralLevel() {
        return cathedralLevel;
    }

    public void setCathedralLevel(int cathedralLevel) {
        this.cathedralLevel = cathedralLevel;
    }

    public int getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(int areaLevel) {
        this.areaLevel = areaLevel;
    }

    public int getStatueLevel() {
        return statueLevel;
    }

    public void setStatueLevel(int statueLevel) {
        this.statueLevel = statueLevel;
    }

    public int getMarketLevel() {
        return marketLevel;
    }

    public void setMarketLevel(int marketLevel) {
        this.marketLevel = marketLevel;
    }

    public int getSawmillLevel() {
        return sawmillLevel;
    }

    public void setSawmillLevel(int sawmillLevel) {
        this.sawmillLevel = sawmillLevel;
    }

    public int getClayquarryLevel() {
        return clayquarryLevel;
    }

    public void setClayquarryLevel(int clayquarryLevel) {
        this.clayquarryLevel = clayquarryLevel;
    }

    public int getIronMineLevel() {
        return ironMineLevel;
    }

    public void setIronMineLevel(int ironMineLevel) {
        this.ironMineLevel = ironMineLevel;
    }

    public int getHomesteadLevel() {
        return homesteadLevel;
    }

    public void setHomesteadLevel(int homesteadLevel) {
        this.homesteadLevel = homesteadLevel;
    }

    public int getWarehouseLevel() {
        return warehouseLevel;
    }

    public void setWarehouseLevel(int warehouseLevel) {
        this.warehouseLevel = warehouseLevel;
    }

    public int getCacheLevel() {
        return cacheLevel;
    }

    public void setCacheLevel(int cacheLevel) {
        this.cacheLevel = cacheLevel;
    }

    public int getStableLevel() {
        return stableLevel;
    }

    public void setStableLevel(int stableLevel) {
        this.stableLevel = stableLevel;
    }

    public int getGarageLevel() {
        return garageLevel;
    }

    public void setGarageLevel(int garageLevel) {
        this.garageLevel = garageLevel;
    }

    public int getSnobLevel() {
        return snobLevel;
    }

    public void setSnobLevel(int snobLevel) {
        this.snobLevel = snobLevel;
    }

    public int getSmithLevel() {
        return smithLevel;
    }

    public void setSmithLevel(int smithLevel) {
        this.smithLevel = smithLevel;
    }

    public int getWallLevel() {
        return wallLevel;
    }

    public void setWallLevel(int wallLevel) {
        this.wallLevel = wallLevel;
    }
}
