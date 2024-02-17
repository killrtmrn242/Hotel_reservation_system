import data.PostgresDB;
import data.interfaces.IDB;

import java.sql.*;

public class Main{
    public static void main(String[] args){
        IDB db = new PostgresDB();
        db.getConnection();
    }
}