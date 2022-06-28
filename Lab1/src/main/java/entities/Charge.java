package entities;

public class Charge {
    private int id;
    private int price;
    private int userId;
    private int roomId;

    public Charge(int id, int price, int userId, int roomId) {
        this.id = id;
        this.price = price;
        this.userId = userId;
        this.roomId = roomId;
    }

    public Charge(int price, int userId, int roomId) {
        this.price = price;
        this.userId = userId;
        this.roomId = roomId;
    }

    public Charge() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString(){
        return "Charge {" +
                "id = " + id +
                ", price = '" + price + '\'' +
                ", user_id ='" + userId + '\'' +
                ", room_id ='" + roomId + '\'' +
                '}';}
}
