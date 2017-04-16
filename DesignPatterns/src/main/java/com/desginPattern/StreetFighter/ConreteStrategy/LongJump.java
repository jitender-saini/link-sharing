package com.desginPattern.StreetFighter.ConreteStrategy;

import com.desginPattern.StreetFighter.Strategy.Jump;

public class LongJump implements Jump {
    @Override
    public void jump() {
        System.out.println("Long Jump");
    }
}
