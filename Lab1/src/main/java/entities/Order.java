package entities;

public class Order {
    private int id;
    private int userId;
    private String timeOfArive;
    private int countOfRooms;
    private String classOfApartment;

    public Order(int id, int userId, String timeOfArive, int countOfRooms, String classOfApartment) {
        this.id = id;
        this.userId = userId;
        this.timeOfArive = timeOfArive;
        this.countOfRooms = countOfRooms;
        this.classOfApartment = classOfApartment;
    }

    public Order(int userId, String timeOfArive, int countOfRooms, String classOfApartment) {
        this.userId = userId;
        this.timeOfArive = timeOfArive;
        this.countOfRooms = countOfRooms;
        this.classOfApartment = classOfApartment;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTimeOfArive() {
        return timeOfArive;
    }

    public void setTimeOfArive(String timeOfArive) {
        this.timeOfArive = timeOfArive;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public String getClassOfApartment() {
        return classOfApartment;
    }

    public void setClassOfApartment(String classOfApartment) {
        this.classOfApartment = classOfApartment;
    }

    @Override
    public String toString(){
        return "Order {" +
                "id = " + id +
                ", user_id = '" + userId + '\'' +
                ", time_of_arive ='" + timeOfArive + '\'' +
                ", count_of_rooms ='" + countOfRooms + '\'' +
                ", class_of_apartment ='" + classOfApartment + '\'' +
                '}';}
}
