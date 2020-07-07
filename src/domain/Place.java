package domain;

public class Place {
    private String place;

    public Place(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return this.place;
    }
}
