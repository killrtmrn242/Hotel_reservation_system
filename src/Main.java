import controllers.RoomController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.RoomRepositoryImpl;
import repositories.interfaces.RoomRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        RoomRepository repo = new RoomRepositoryImpl(db);
        RoomController controller = new RoomController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}