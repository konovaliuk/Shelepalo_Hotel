package entities;

public class Room {
    private long id ;
    private String type;
    private String beds;
    private String status;

    public Room(long id, String type, String beds, String status) {
        this.id = id;
        this.type = type;
        this.beds = beds;
        this.status = status;
    }

    public Room(String type, String beds, String status) {
        this.type = type;
        this.beds = beds;
        this.status = status;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return "Room {" +
                "id = " + id +
                ", type = '" + type + '\'' +
                ", beds ='" + beds + '\'' +
                ", status ='" + status + '\'' +
                '}';}
}
