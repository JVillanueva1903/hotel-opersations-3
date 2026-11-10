public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }

    // Setter for room type
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Getter for price per night
    public double getPrice() {
        double price = 0.0;

        if (roomType.equalsIgnoreCase("king")) {
            price = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            price = 124.00;
        }

        if (weekend) {
            price *= 1.10; // Increase by 10%
        }

        return price;
    }

    // Getter for number of nights
    public int getNumberOfNights() {
        return numberOfNights;
    }

    // Setter for number of nights
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    // Getter for weekend
    public boolean isWeekend() {
        return weekend;
    }

    // Setter for weekend
    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    // Calculate total reservation cost
    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}