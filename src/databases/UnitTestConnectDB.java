package databases;

import org.junit.Assert;

import java.util.List;

public class UnitTestConnectDB {

    public static void main(String[] args) throws Exception {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.createDatabase("Testing", new String[]{"data"}, new String[]{"VARCHAR(255)"});
        connectToSqlDB.insertDataFromArrayToSqlTable(new String[]{"test", "db"}, "Testing", "data");
        List<String> list = connectToSqlDB.readDataBase("Testing", "data");
        Assert.assertEquals(list.size(), 2);
        connectToSqlDB.insertDataFromArrayToSqlTable(new String[]{"again", "check"}, "Testing", "data");
        List<String> list2 = connectToSqlDB.readDataBase("Testing", "data");
        Assert.assertEquals(list2.size(), 4);
        System.out.println("MySQL Tests passed");
        //ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();
    }
}
