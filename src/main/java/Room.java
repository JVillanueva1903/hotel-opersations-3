public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    // Getter for numberOfBeds
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Boolean getter for occupied
    public boolean isOccupied() {
        return occupied;
    }

    // Boolean getter for dirty
    public boolean isDirty() {
        return dirty;
    }

    // Returns true if the room is not occupied and not dirty
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // Guest checks into the room
    public void checkIn() {
        if (isAvailable()) {
            occupied = true;
            dirty = true;
        }
    }

    // Guest checks out of the room
    public void checkOut() {
        occupied = false;
    }

    // Housekeeper cleans the room
    public void cleanRoom() {
        if (!occupied) {
            dirty = false;
        }
    }
}