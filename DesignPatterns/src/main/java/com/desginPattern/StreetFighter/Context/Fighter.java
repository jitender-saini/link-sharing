package com.desginPattern.StreetFighter.Context;

import com.desginPattern.StreetFighter.Strategy.Jump;
import com.desginPattern.StreetFighter.Strategy.Roll;

public class Fighter {
    private Jump jump;
    private Roll roll;

    public Fighter(Jump jump, Roll roll) {
        this.jump = jump;
        this.roll = roll;
    }

    public void kick() {
        System.out.println("Kick");
    }

    public void punch() {
        System.out.println("Punch");
    }

    public void display() {
    }

    public void execute() {
        display();
        kick();
        punch();
        jump.jump();
        roll.roll();
    }

}
