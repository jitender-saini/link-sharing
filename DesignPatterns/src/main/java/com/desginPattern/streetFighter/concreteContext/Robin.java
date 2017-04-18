package com.desginPattern.streetFighter.concreteContext;

import com.desginPattern.streetFighter.context.Fighter;
import com.desginPattern.streetFighter.strategy.Jump;
import com.desginPattern.streetFighter.strategy.Roll;

public class Robin extends Fighter {
    public Robin(Jump jump, Roll roll) {
        super(jump, roll);
    }

    @Override
    public void kick() {
        super.kick();
    }

    @Override
    public void punch() {
        super.punch();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("\n********** Robin **********");
    }
}
