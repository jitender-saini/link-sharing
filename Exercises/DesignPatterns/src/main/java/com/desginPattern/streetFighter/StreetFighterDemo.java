package com.desginPattern.streetFighter;

import com.desginPattern.streetFighter.concreteContext.Ben;
import com.desginPattern.streetFighter.concreteContext.Robin;
import com.desginPattern.streetFighter.conreteStrategy.DoubleRoll;
import com.desginPattern.streetFighter.conreteStrategy.LongJump;
import com.desginPattern.streetFighter.conreteStrategy.ShortJump;
import com.desginPattern.streetFighter.conreteStrategy.SingleRoll;
import com.desginPattern.streetFighter.context.Fighter;
import com.desginPattern.streetFighter.strategy.Jump;
import com.desginPattern.streetFighter.strategy.Roll;

import java.util.Scanner;

public class StreetFighterDemo {
    public static void main(String[] args) {
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
