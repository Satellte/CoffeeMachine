package machine;

import static machine.MachineState.*;

public class Main {
    /**
     * Start of the program. Initialization of object DeLonghi - new object of class CoffeeMachine.
     * Setting resources of object DeLonghi with method setResources. Then call method showMainMenu
     * from class CoffeeMachine.
     */
    public static void main(String[] args) {
        machine.CoffeeMachine DeLonghi = new CoffeeMachine();
        DeLonghi.setResources(SHOWMAINMENU, 400, 540, 120, 9, 550);
        machine.CoffeeMachine.showMainMenu();
    }
}