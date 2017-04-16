package com.desginPattern.StreetFighter.ConcreteContext;

import com.desginPattern.StreetFighter.Context.Fighter;
import com.desginPattern.StreetFighter.Strategy.Jump;
import com.desginPattern.StreetFighter.Strategy.Roll;

public class Ben extends Fighter {
    public Ben(Jump jump, Roll roll) {
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
        System.out.println("\n********** Ben **********");
    }
}

