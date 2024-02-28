package repositories.interfaces;

import models.Room;

import java.util.List;

public interface RoomRepository {
    boolean createRoom(Room room);
    List<Room> getAllRooms();
    Room getRoom(int id);
}