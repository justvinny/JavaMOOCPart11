package logic;

import domain.Flight;
import domain.Place;
import domain.Plane;
import java.util.HashMap;

public class FlightControl {
    private HashMap<String, Plane> planes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;

    public FlightControl() {
        this.planes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addPlane(String id, int capacity) {
        this.planes.put(id, new Plane(id, capacity));
    }

    public void addFlights(Plane plane, String placeOrigin, String placeDestination) {
        this.places.putIfAbsent(placeOrigin, new Place(placeOrigin));
        this.places.putIfAbsent(placeDestination, new Place(placeDestination));

        Flight newFlight = new Flight(plane, this.places.get(placeOrigin), this.places.get(placeDestination));
        this.flights.put(newFlight.toString(), newFlight);
    }

    public HashMap<String, Plane> getPlanes() {
        return this.planes;
    }

    public HashMap<String, Flight> getFlights() {
        return this.flights;
    }

    public Plane getPlane(String id) {
        return this.planes.get(id);
    }
}
