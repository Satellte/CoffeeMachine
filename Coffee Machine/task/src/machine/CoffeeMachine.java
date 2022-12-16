package machine;

import java.util.Scanner;
public class CoffeeMachine {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DeLonghi DeLonghi = new DeLonghi();
        DeLonghi.setResources(400, 540, 120, 9, 550);
        machine.DeLonghi.getMenu();
    }
}