package models;
public class Room{
    private int RoomID;
    private String RoomType;
    private int MaxOccupancy;
    private int RoomRate;

    public Room(int RoomID, String RoomType, int MaxOccupancy, int RoomRate){
        setRoomID(RoomID);
        setRoomType(RoomType);
        setMaxOccupancy(MaxOccupancy);
        setRoomRate(RoomRate);
    }

    public int getRoomID(){
        return RoomID;
    }
    public void setRoomID(int RoomID){
        this.RoomID = RoomID;
    }

    public String getRoomType(){
        return RoomType;
    }
    public void setRoomType(String RoomType){
        this.RoomType = RoomType;
    }

    public int getMaxOccupancy(){
        return MaxOccupancy;
    }
    public void setMaxOccupancy(int MaxOccupancy){
        this.MaxOccupancy = MaxOccupancy;
    }

    public int getRoomRate(){
        return RoomRate;
    }
    public void setRoomRate(int RoomRate){
        this.RoomRate = RoomRate;
    }

    @Override
    public String toString(){
        return "Room{" +
                "id=" + RoomID +
                ", type=" + RoomType + '\'' +
                ", occupancy=" + MaxOccupancy + '\'' +
                ", roomRate=" + RoomRate +
                "}";
    }
}