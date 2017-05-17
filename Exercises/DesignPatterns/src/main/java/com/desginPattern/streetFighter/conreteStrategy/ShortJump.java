package com.desginPattern.streetFighter.conreteStrategy;

import com.desginPattern.streetFighter.strategy.Jump;

public class ShortJump implements Jump {
    @Override
    public void jump() {
        System.out.println("Short Jump");
    }
}
