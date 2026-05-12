package day10;

import java.util.Scanner;

public class Four {

    static abstract class Player {
        protected String shape[] = {"가위", "바위", "보"};
        private String name;

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        abstract public String turn();
    }

    static class MachinePlayer extends Player {
        public MachinePlayer(String name) {
            super(name);
        }

        public String turn() {
            return shape[(int)(Math.random() * 3)];
        }
    }

    static class HumanPlayer extends Player {
        private Scanner scanner = new Scanner(System.in);

        public HumanPlayer(String name) {
            super(name);
        }

        public String turn() {
            System.out.print(getName() + ">> ");
            String input = scanner.next();

            return input;
        }
    }

    public static void main(String[] args) {
        Player machine = new MachinePlayer("터미네이터");
        Player human = new HumanPlayer("황기태");

        String m = machine.turn();
        String h = human.turn();

        System.out.println(machine.getName() + ":" + m + ", " + human.getName() + ":" + h);

        if (h.equals(m)) {
            System.out.println(machine.getName() + " 승리!");
        } else {
            System.out.println(human.getName() + " 승리!");
        }
    }
}