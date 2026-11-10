public class Hotel {
    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor that defaults booked rooms to 0
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor that sets all values
    public Hotel(String name, int numberOfSuites, int numberOfRooms,
                 int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    // Derived getter - no backing variable
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    // Derived getter - no backing variable
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    /**
     * Books one or more rooms.
     * @param roomCount Number of rooms to book
     * @param suite true for King Suites, false for Basic Double Rooms
     * @return true if booking was successful, false otherwise
     */
    public boolean bookRoom(int roomCount, boolean suite) {
        if (roomCount <= 0) {
            return false;
        }

        if (suite) {
            if (getAvailableSuites() >= roomCount) {
                bookedSuites += roomCount;
                return true;
            }
        } else {
            if (getAvailableRooms() >= roomCount) {
                bookedBasicRooms += roomCount;
                return true;
            }
        }

        return false;
    }
}