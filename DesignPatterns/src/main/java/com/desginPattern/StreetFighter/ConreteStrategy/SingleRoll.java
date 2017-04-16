package com.desginPattern.StreetFighter.ConreteStrategy;

import com.desginPattern.StreetFighter.Strategy.Roll;

public class SingleRoll implements Roll {
    @Override
    public void roll() {
        System.out.println("Single Roll");
    }
}
