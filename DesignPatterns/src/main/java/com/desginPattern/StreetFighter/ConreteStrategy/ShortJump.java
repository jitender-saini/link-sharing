package com.desginPattern.StreetFighter.ConreteStrategy;

import com.desginPattern.StreetFighter.Strategy.Jump;

public class ShortJump implements Jump {
    @Override
    public void jump() {
        System.out.println("Short Jump");
    }
}
