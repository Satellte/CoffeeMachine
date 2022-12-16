package CoffeeMachine;

import static CoffeeMachine.MachineState.*;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine DeLonghi = new CoffeeMachine();
        DeLonghi.setResources(SHOWMAINMENU, 400, 540, 120, 9, 550);
        CoffeeMachine.showMainMenu();
    }
}