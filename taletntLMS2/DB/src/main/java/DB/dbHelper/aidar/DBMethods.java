package DB.dbHelper.aidar;

import DB.dbHelper.aidar.DBConnection;

public class DBMethods {
    public void createDB(String db) {
        try {
            DBConnection.query("Create Database" + db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
