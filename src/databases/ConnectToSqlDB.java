package databases;

import design.Employee;
import design.EmployeeInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectToSqlDB {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        if (connect == null || connect.isClosed()) {
            Properties prop = loadProperties();
            String driverClass = prop.getProperty("MYSQLJDBC.driver");
            String url = prop.getProperty("MYSQLJDBC.url");
            String userName = prop.getProperty("MYSQLJDBC.userName");
            String password = prop.getProperty("MYSQLJDBC.password");
            Class.forName(driverClass);
            connect = DriverManager.getConnection(url, userName, password);
            System.out.println("Database is connected");
        }
        return connect;
    }

    public void createDatabase(String tableName, String cols[], String rows[]) throws Exception {
        connectToSqlDatabase();
        statement = connect.createStatement();
        String sql = "CREATE TABLE " + tableName + " (";
        for (int i = 0; i < cols.length; i++) {
            sql += cols[i] + " " + rows[i];
            if (i != cols.length - 1) {
                sql += ",";
            }
        }
        sql += ");";
        statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
        statement.executeUpdate(sql);
    }

    public List<String> readDataBase(String tableName, String columnName) throws Exception {
        List<String> data = new ArrayList<String>();
        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    public void insertDataFromArrayToSqlTable(int[] ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            //statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
            //ps = connect.prepareStatement("CREATE TABLE '" + tableName + "' ('ID' int(11) NOT NULL AUTO_INCREMENT,'SortingNumbers' bigint(20) DEFAULT NULL,  PRIMARY KEY ('ID') );");
            //ps.executeUpdate();
            for (int n = 0; n < ArrayData.length; n++) {
                statement.executeUpdate(String.format("INSERT INTO %s (%s) VALUES (%d)", tableName, columnName, ArrayData[n]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromArrayToSqlTable(String[] ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            for (int n = 0; n < ArrayData.length; n++) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setString(1, ArrayData[n]);
                ps.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setString(1, ArrayData);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromMapToSqlTable(String key, String value, String tableName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " VALUES(?, ?)");
            ps.setString(1, key);
            ps.setString(2, value);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromUserToSqlTable(User user, String tableName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " VALUES(?, ?, ?)");
            ps.setString(1, user.stName);
            ps.setString(2, user.stID);
            ps.setString(3, user.stDOB);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromEmployeeToSqlTable(Employee emp, String tableName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " VALUES(?, ?, ?)");
            ps.setString(1, "" + emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> directDatabaseQueryExecute(String passQuery, String dataColumn) throws Exception {
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            ps.setString(1, "Ankita Sing");
            ps.setInt(2, 3590);
            ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUserProfileFromSqlTable() throws IOException, SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<User>();
        User user = null;
        try {
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM Students";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String name = rs.getString("stName");
                String id = rs.getString("stID");
                String dob = rs.getString("stDOB");
                //System.out.format("%s, %s\n", name, id);
                user = new User(name, id, dob);
                list.add(user);

            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }

    public List<Employee> readEmployeeProfileFromSqlTable() throws IOException, SQLException, ClassNotFoundException {
        List<Employee> list = new ArrayList<Employee>();
        Employee emp = null;
        try {
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM Employees";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String name = rs.getString("Name");
                String id = rs.getString("Id");
                String department = rs.getString("Department");
                //System.out.format("%s, %s\n", name, id);
                emp = new EmployeeInfo(Integer.parseInt(id), name, department);
                list.add(emp);

            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        //read students and insert to database
        ConnectToSqlDB db = new ConnectToSqlDB();
        db.createDatabase("students", new String[]{"stName", "stID", "stDOB"},
                new String[]{"VARCHAR(255)", "VARCHAR(255)", "VARCHAR(255)"});
        String textFile = System.getProperty("user.dir") + "/src/data/students.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(textFile)));
        String line;
        while ((line = br.readLine()) != null) {
            String toks[] = line.split(",");
            User user = new User(toks[0].trim(), toks[1].trim(), toks[2].trim());
            db.insertDataFromUserToSqlTable(user, "students");
        }

        //insert to database
        System.out.println("Retrieve students from database:");
        List<User> students = db.readUserProfileFromSqlTable();
        for (User user : students) {
            System.out.println("Name: " + user.getStName() + ", ID: " + user.getStID() + ", DOB: " + user.getStDOB());
        }

        System.out.println("\nRetrieve student names from database:");
        List<String> studentNames = db.readDataBase("students", "stName");
        for (String student : studentNames) {
            System.out.println(student);
        }

    }
}