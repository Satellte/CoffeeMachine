package machine;

import static machine.MachineState.*;

public class Main {
    public static void main(String[] args) {
        machine.CoffeeMachine DeLonghi = new CoffeeMachine();
        DeLonghi.setResources(SHOWMAINMENU, 400, 540, 120, 9, 550);
        machine.CoffeeMachine.showMainMenu();
    }
}