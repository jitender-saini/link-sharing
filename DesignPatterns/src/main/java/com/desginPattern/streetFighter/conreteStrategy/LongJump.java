package com.desginPattern.streetFighter.conreteStrategy;

import com.desginPattern.streetFighter.strategy.Jump;

public class LongJump implements Jump {
    @Override
    public void jump() {
        System.out.println("Long Jump");
    }
}
