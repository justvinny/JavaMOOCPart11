package domain;

public class Flight {
    private Plane plane;
    private Place placeOrigin;
    private Place placeDestination;

    public Flight(Plane plane, Place placeOrigin, Place placeDestination) {
        this.plane = plane;
        this.placeOrigin = placeOrigin;
        this.placeDestination = placeDestination;
    }

    public Plane getPlane() {
        return plane;
    }

    public Place getPlaceOrigin() {
        return placeOrigin;
    }

    public Place getPlaceDestination() {
        return placeDestination;
    }

    @Override
    public String toString() {
        return this.plane.toString() + " (" + this.placeOrigin + "-" + this.placeDestination + ")";
    }
}
