import controllers.RoomController;
import models.Room;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final RoomController controller;
    private final Scanner scanner;

    public MyApplication(RoomController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }


    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1){
                    getAllRoomsMenu();
                }
                else if (option == 2){
                    getUserByIdMenu();
                }
                else if (option == 3) {
                    createUserMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer: " + e);
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");
        }
    }

    public void getAllRoomsMenu(){
        String response = controller.getAllRooms();
        System.out.println(response);
    }

    public void getUserByIdMenu(){
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getRoom(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter RoomType");
        String name = scanner.next();
        System.out.println("Please enter MaxOccupancy");
        Integer surname = scanner.nextInt();
        System.out.println("Please enter gender RoomRate");
        Integer gender = scanner.nextInt();
        Room room = new Room(1, name, surname, gender);

        String response = controller.createRoom(room.getRoomID(),room.getRoomType(), room.getMaxOccupancy(), room.getRoomRate());
        System.out.println(response);
    }
}