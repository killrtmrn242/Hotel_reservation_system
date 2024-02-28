package repositories;

import data.interfaces.IDB;
import models.Room;
import repositories.interfaces.RoomRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    private final IDB db;
    public RoomRepositoryImpl(IDB db){
        this.db = db;
    }

    @Override
    public boolean createRoom(Room room) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO Hotel_rooms(RoomType, MaxOccupancy, RoomRate) VALUES(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, room.getRoomType());
            st.setInt(2, room.getMaxOccupancy());
            st.setInt(3, room.getRoomRate());

            st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Room getRoom(int id){
        Connection con = null;

        try{
          con = db.getConnection();
          String sql = "SELECT roomid, roomtype, maxoccupancy, roomrate FROM hotel_rooms WHERE roomid=?";
          PreparedStatement st = con.prepareStatement(sql);

          st.setInt(1,id);

          ResultSet rs = st.executeQuery();
          if (rs.next()){
              return new Room(rs.getInt("roomid"),
                      rs.getString("roomtype"),
                      rs.getInt("maxoccupancy"),
                      rs.getInt("roomrate"));
          }
        }catch (SQLException e){
            System.out.println("sql error: " + e.getMessage());
        }finally {
            try{
                if (con != null)
                    con.close();
            }catch (SQLException e){
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Room> getAllRooms(){
        Connection con = null;

        try{
            con = db.getConnection();
            String sql = "SELECT roomid, roomtype, maxoccupancy, roomrate FROM hotel_rooms";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Room> rooms = new LinkedList<>();
            while (rs.next()){
                Room room = new Room(rs.getInt("roomid"),
                        rs.getString("roomtype"),
                        rs.getInt("maxoccupancy"),
                        rs.getInt("roomrate"));
                rooms.add(room);
            }

            return rooms;
        }catch (SQLException e){
            System.out.println("sql error: " + e.getMessage());
        }finally {
            try{
                if (con != null)
                    con.close();
            }catch (SQLException e){
                System.out.println("Sql error: " + e.getMessage());
            }
        }
        return null;
    }

}