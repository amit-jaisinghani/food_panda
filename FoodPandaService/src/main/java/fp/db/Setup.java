package fp.db;

import java.sql.*;

public class Setup {

    public static void main(String[] args) {
        initiate();
    }

    private static void initiate(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=admin");
            Statement statement = connection.createStatement();
            int dbCreated = statement.executeUpdate("CREATE DATABASE foodpanda");
//            int dbCreated = 1;
            connection.close();
            if( dbCreated != 1){
                System.out.println("Error while creating database foodpanda");
            } else {
                Connection foodpandaDbConnection = DriverManager.getConnection("jdbc:mysql://localhost/foodpanda?user=root&password=admin");
                createTables(foodpandaDbConnection);
                createDumpyRows(foodpandaDbConnection);
                foodpandaDbConnection.close();
            }

        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007) {
                // Database already exists error
                System.out.println(sqlException.getMessage());
            } else {
                // Some other problems, e.g. Server down, no permission, etc
                sqlException.printStackTrace();
            }
        }
    }

    private static void createDumpyRows(Connection connection) throws SQLException {
        Statement st = connection.createStatement();

        //Hotel created - Sukh Sagar
        st.executeUpdate("INSERT INTO hotels (hotel_name) VALUES ('Sukh Sagar')");

        //Menu sections
        st.executeUpdate("INSERT INTO menus (menu_name, hotel_id_fk) VALUES ('Breakfast', 1)");
        st.executeUpdate("INSERT INTO menus (menu_name, hotel_id_fk) VALUES ('Main Course', 1)");
        st.executeUpdate("INSERT INTO menus (menu_name, hotel_id_fk) VALUES ('Dessert', 1)");

        //Food items
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (1, 'Pan cakes', 30, 'All purpose flour, salt, eggs, sugar')");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (1, 'Idli', 10, 'Idli Rice, Urad dal, methi seeds')");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (1, 'Dosa', 15, NULL )");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (2, 'Panner Chilli', 25, NULL )");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (2, 'Veggie Chilli', 18, NULL )");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (2, 'Stuffed Bell Pepper', 35, NULL )");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (3, 'Chocolate Volcano', 45, NULL )");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (3, 'Banana Caramel', 40, NULL )");
        st.executeUpdate("INSERT INTO menu_items (menu_id_fk, item_name, item_price, ingredients) VALUES (3, 'Gulab Jamun', 35, NULL )");
    }

    private static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createHotelTableQuery = "CREATE TABLE hotels (" +
                "        id INT(64) NOT NULL AUTO_INCREMENT," +
                "        hotel_name VARCHAR(250) NOT NULL," +
                "        date_created timestamp default now()," +
                "        PRIMARY KEY (`id`));";

        statement.executeUpdate(createHotelTableQuery);

        String createMenuTableQuery = "CREATE TABLE menus (" +
                "        id INT(64) NOT NULL AUTO_INCREMENT," +
                "        hotel_id_fk INT(64) NOT NULL REFERENCES hotels (id)," +
                "        menu_name VARCHAR(250)," +
                "        PRIMARY KEY (`id`));";

        statement.executeUpdate(createMenuTableQuery);

        String createMenuItemsTableQuery = "CREATE TABLE menu_items (" +
                "        id INT(64) NOT NULL AUTO_INCREMENT," +
                "        menu_id_fk INT(64) NOT NULL REFERENCES menus (id)," +
                "        item_name VARCHAR(250) NOT NULL," +
                "        item_price INT(64) NOT NULL," +
                "        ingredients VARCHAR(250)," +
                "        PRIMARY KEY (`id`));";

        statement.executeUpdate(createMenuItemsTableQuery);

    }

}
