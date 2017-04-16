package com.desginPattern.StreetFighter;

import com.desginPattern.StreetFighter.ConcreteContext.Ben;
import com.desginPattern.StreetFighter.ConcreteContext.Robin;
import com.desginPattern.StreetFighter.ConreteStrategy.DoubleRoll;
import com.desginPattern.StreetFighter.ConreteStrategy.LongJump;
import com.desginPattern.StreetFighter.ConreteStrategy.ShortJump;
import com.desginPattern.StreetFighter.ConreteStrategy.SingleRoll;
import com.desginPattern.StreetFighter.Context.Fighter;
import com.desginPattern.StreetFighter.Strategy.Jump;
import com.desginPattern.StreetFighter.Strategy.Roll;

import java.util.Scanner;

public class StreetFighterDemo {
    public static void main(String[] args) {
        /*Fighter fighter = new Ben(new ShortJump(), new SingleRoll());
        fighter.execute();

        fighter = new Robin(new LongJump(), new DoubleRoll());
        fighter.execute();*/

        Fighter fighter = null;
        Fighter fighter1 = null;
        Fighter fighter2 = null;
        Jump jump = null;
        Roll roll = null;

        Scanner scanner = new Scanner(System.in);
        int fighterChoice, jumpChoice, rollChoice;
        int count = 0;

        while (count < 2) {
            System.out.println("\nEnter " + ++count + " fighter details...");

            System.out.println("********** Fighter **********");
            System.out.println("1. Ben");
            System.out.println("2. Robin");
            System.out.print("\nSelect your option from above: ");
            fighterChoice = scanner.nextInt();

            System.out.println("********** Jump **********");
            System.out.println("1. Long Jump");
            System.out.println("2. Short Jump");
            System.out.print("\nSelect your option from above: ");
            jumpChoice = scanner.nextInt();

            System.out.println("********** Roll **********");
            System.out.println("1. Double Roll");
            System.out.println("2. Single Roll");
            System.out.print("\nSelect your option from above: ");
            rollChoice = scanner.nextInt();

            if (jumpChoice == 1 || jumpChoice == 2) {
                switch (jumpChoice) {
                    case 1:
                        jump = new LongJump();
                        break;
                    case 2:
                        jump = new ShortJump();
                        break;
                    default:
                        System.out.println("Please enter correct fighterChoice");
                        break;
                }
            }

            if (rollChoice == 1 || rollChoice == 2) {
                switch (rollChoice) {
                    case 1:
                        roll = new DoubleRoll();
                        break;
                    case 2:
                        roll = new SingleRoll();
                        break;
                    default:
                        System.out.println("Please enter correct fighterChoice");
                        break;
                }
            }

            if (fighterChoice == 1 || fighterChoice == 2) {
                switch (fighterChoice) {
                    case 1:
                        fighter = new Ben(jump, roll);
                        break;
                    case 2:
                        fighter = new Robin(jump, roll);
                        break;

                    default:
                        System.out.println("Please enter correct fighterChoice");
                        break;
                }
            }
            if (count == 1)
                fighter1 = fighter;
            else
                fighter2 = fighter;
        }
        fighter1.execute();
        fighter2.execute();

    }
}
