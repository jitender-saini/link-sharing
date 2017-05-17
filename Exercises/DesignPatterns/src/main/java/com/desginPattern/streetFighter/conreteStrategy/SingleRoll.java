package com.desginPattern.streetFighter.conreteStrategy;

import com.desginPattern.streetFighter.strategy.Roll;

public class SingleRoll implements Roll {
    @Override
    public void roll() {
        System.out.println("Single Roll");
    }
}
