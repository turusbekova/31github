package DB.dbHelper.aidar;


import DB.dataProviders.ConfigReader;
import com.mysql.cj.jdbc.MysqlDataSource;

import org.apache.commons.dbutils.QueryRunner;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnection {
    private static Connection connection;
    private static Statement statement;
    private static QueryRunner queryRunner;

    private static String[] properties;

    private DBConnection() {
    }

    public static void open(String db) throws SQLException {
        if (connection == null) {
            queryRunner = new QueryRunner(getBaseDataSource(db));
            connection = getBaseDataSource(db).getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
    }

    public static ResultSet query(String query, Object... params) throws SQLException {
        if (params.length == 0)
            return statement.executeQuery(query);
        else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            return preparedStatement.executeQuery();
        }
    }

    public static <T> boolean insertBean(String query, T bean, String[] properties) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        queryRunner.fillStatementWithBean(preparedStatement, bean, properties);
        return preparedStatement.execute();
    }


    public static List<Map<String, Object>> queryToList(String query) throws SQLException {
        try (ResultSet rs = query(query)) {
            List<Map<String, Object>> result = new ArrayList<>();
            List<String> columns = getColumns(rs.getMetaData());
            while (rs.next()) {
                result.add(rowToMap(rs, columns));
            }
            return result;
        }
    }

    public static void close() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connection != null) {
                connection.close();
                connection = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static MysqlDataSource getBaseDataSource(String database) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(ConfigReader.getProperty("server"));
        dataSource.setPortNumber(Integer.parseInt(ConfigReader.getProperty("port")));
        dataSource.setUser(ConfigReader.getProperty("user"));
        dataSource.setPassword(ConfigReader.getProperty("password"));
        dataSource.setDatabaseName(database);
        return dataSource;
    }

    private static Map<String, Object> rowToMap(ResultSet rs, List<String> columns) throws SQLException {
        Map<String, Object> row = new HashMap<>();

        for (String column : columns) {
            row.put(column, rs.getObject(column));
        }
        return row;
    }

    private static List<String> getColumns(ResultSetMetaData metaData) throws SQLException {

        int num_of_columns = metaData.getColumnCount();
        List<String> headers = new ArrayList<>();

        for (int i = 1; i <= num_of_columns; i++) {
            headers.add(metaData.getColumnName(i));
        }
        return headers;
    }
}