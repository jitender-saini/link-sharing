package com.desginPattern.StreetFighter.ConreteStrategy;

import com.desginPattern.StreetFighter.Strategy.Roll;

public class DoubleRoll implements Roll {
    @Override
    public void roll() {
        System.out.println("Double Roll");
    }
}
