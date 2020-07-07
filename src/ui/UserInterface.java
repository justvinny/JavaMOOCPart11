package ui;

import domain.Flight;
import domain.Plane;
import logic.FlightControl;

import java.util.Scanner;

public class UserInterface {
    private FlightControl flightControl;
    private Scanner scanner;

    public UserInterface(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        startAssetControl();
        startFlightControl();
    }

    private void startAssetControl() {
        printAssetControlTitle();

        while (true) {
            printAssetControlMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addPlane();
            } else if (choice.equals("2")) {
                addFlight();
            } else if (choice.equals("x")) {
                break;
            }
        }

        System.out.println();
    }

    private void printAssetControlTitle() {
        System.out.println("Airport Asset Control");
        System.out.println("---------------------\n");
    }

    private void printAssetControlMenu() {
        System.out.println("Choose an action:");
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");
        System.out.println("[x] Exit Airport Asset Control");
        System.out.print("> ");
    }

    private void addPlane() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.println();

        this.flightControl.addPlane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Plane airplane = askForAirplane();
        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = scanner.nextLine();
        System.out.println();

        this.flightControl.addFlights(airplane, departureID, destinationID);
    }

    private void startFlightControl() {
        printFlightControlTitle();

        while (true) {
            printFlightControlMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                printPlanes();
            } else if (choice.equals("2")) {
                printFlights();
            } else if (choice.equals("3")) {
                printPlaneDetails();
            } else if (choice.equals("x")) {
                break;
            }
        }

        System.out.println();
    }

    private void printFlightControlTitle() {
        System.out.println("Flight Control");
        System.out.println("------------\n");
    }

    private void printFlightControlMenu() {
        System.out.println("Choose an action:");
        System.out.println("[1] Print airplanes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print airplane details");
        System.out.println("[x] Quit");
        System.out.print("> ");
    }

    private void printPlanes() {
        for (Plane plane : flightControl.getPlanes().values()) {
            System.out.println(plane);
        }
        System.out.println();
    }

    private void printFlights() {
        for (Flight flight : flightControl.getFlights().values()) {
            System.out.println(flight);
        }
        System.out.println();
    }

    private void printPlaneDetails() {
        System.out.print("Give the airplane id: ");
        Plane plane = askForAirplane();
        System.out.println(plane);
        System.out.println();
    }

    private Plane askForAirplane() {
        Plane plane = null;
        while (plane == null) {
            String id = scanner.nextLine();
            plane = flightControl.getPlane(id);

            if (plane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return plane;
    }
}
