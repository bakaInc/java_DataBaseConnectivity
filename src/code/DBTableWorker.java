package code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTableWorker {
    DBConnection dbConnection = new DBConnection();
    Statement statement;
    ResultSet resultSet;
    private String tableName = null;

    public DBTableWorker(String tableName) {
        this.tableName = tableName;
    }

    public void DBTW_init(String user, String password) throws SQLException, ClassNotFoundException {
        dbConnection.setConnection(user, password);
        statement = dbConnection.getConnection().createStatement();
    }

    public void tableCreate() {

    }

    public void tableDrop() throws SQLException {
        resultSet = statement.executeQuery("DROP TABLE " + tableName);
        System.out.println("TABLE " + tableName + " HAS BEEN DROPPED");
    }

    public void tableUpdate() {

    }

    public void tableInsert() {

    }

    public void showAll() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        System.out.println("BRANCH_ID || ADDRESS || CITY || NAME || STATE || ZIP_CODE");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || " + resultSet.getString(3) + " || " +
                    resultSet.getString(4) + " || " + resultSet.getString(5) + " || ");
        }
        resultSet.close();
        statement.close();
    }
}