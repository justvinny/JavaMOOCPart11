import logic.FlightControl;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightControl flightControl = new FlightControl();
        Scanner scanner = new Scanner(System.in);

        UserInterface userInterface = new UserInterface(flightControl, scanner);
        userInterface.start();
    }
}
