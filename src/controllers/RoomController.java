package controllers;

import models.Room;
import repositories.interfaces.RoomRepository;

import java.util.List;

public class RoomController{
    private final RoomRepository repo;

    public RoomController(RoomRepository repo) {
        this.repo = repo;
    }
    // Add Service layer
    public String createRoom(int RoomID, String RoomType, int MaxOccupancy, int RoomRate) {

        Room room = new Room(RoomID, RoomType, MaxOccupancy, RoomRate);

        boolean created = repo.createRoom(room);

        return (created ? "Room was created!" : "Room creation was failed!");
    }



    public String getAllRooms(){
        List<Room> rooms = repo.getAllRooms();

        StringBuilder response = new StringBuilder();
        for (Room room : rooms){
            response.append(room.toString()).append("\n");
        }
        return response.toString();
    }

    public String getRoom(int id){
        Room room = repo.getRoom(id);

        return (room == null ? "User was not found! " : room.toString());
    }
}