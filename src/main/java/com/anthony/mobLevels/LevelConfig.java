package com.anthony.mobLevels;

public class LevelConfig {

    public int[] passiveLevels = {1, 10};
    public int[] neutralLevels = {3, 12};
    public int[] hostileLevels = {5, 15};


    public int getNetherAdjustment() {
        return 3;
    }

    public int getEndAdjustment() {
        return 5;
    }

}
