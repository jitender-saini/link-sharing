package com.desginPattern.streetFighter.conreteStrategy;

import com.desginPattern.streetFighter.strategy.Roll;

public class DoubleRoll implements Roll {
    @Override
    public void roll() {
        System.out.println("Double Roll");
    }
}
