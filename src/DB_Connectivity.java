import java.sql.*;
import java.util.*;
public class DB_Connectivity extends Main{
     static Connection con=null;
    public void getConnect() throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","rppt");
        System.out.println(con);
    }
    public void sign_up(String mail,String password) throws SQLException {
        Statement st=con.createStatement();
        //String query="Select user_id from user where user_id="+mail+";");
        String query="Insert into user (user_id,password) values ('"+mail+"=','"+password+"');";
        boolean res=st.execute(query);
        if(res)
        {
            System.out.println("Retry again");
        }
        else
        {
            System.out.println("signed up successfully");
        }
    }
    public void log_in(String mail,String password) throws Exception
    {
        Statement st=con.createStatement();
        String query="Select user_id from user where password='"+password+"' and user_id='"+mail+"';";
        ResultSet res=st.executeQuery(query);
        boolean b=res.next();
        if(b)
        {
            System.out.println("Logged in successfully");
            System.out.println("Username:"+mail);
        }
        else {
            System.out.println("Username and password are incorrect.\nRetry and login again.\nOR\nSign up.");
            Main.welcome();
        }
    }

    public void vehicle_detail(String mail, String vehicleNumber, String fuelType) throws Exception
    {
        Statement st= con.createStatement();
        String query="Insert into vehicle (user_id,vehicle_number,fuel_type) values ('"+mail+"','"+vehicleNumber+"','"+fuelType+"');";
        boolean res= st.execute(query);
        if(!res)
        {
            System.out.println("Vehicle details are entered successfully.");
        }
        else
        {
            System.out.println("Error occurred.Enter the details again");
            Main.vehicle();
        }
    }

    public static String listTheVehicles() throws Exception
    {
        Statement st= con.createStatement();
        String query="Select vehicle_number from vehicle where user_id='"+mail+"';";
        ResultSet res=st.executeQuery(query);
        int i=1;

        ArrayList<String> l = new ArrayList<String>();
        while(res.next())
        {
            System.out.println(i+"\t"+res.getString(1));
            l.add(res.getString(1));
            i++;
        }

        int choice = sc.nextInt();

        return l.get(choice-1);

    }

    public int bunkList() throws Exception
    {
        Statement st = con.createStatement();
        String query = "Select * from bunk;";
        ResultSet res=st.executeQuery(query);
        while(res.next())
        {
            System.out.println(res.getString(1)+" "+res.getString(2));
        }
        int bid=sc.nextInt();
        return bid;
    }

    public void transaction(String veh, String date, int quantity, int bunkId, int odoRead, int i, int i1) {
    }

   /* public void get_details() throws Exception
    {
        Statement st=con.createStatement();
        String query="Select * from ";
    }*/

   /* public static void main(String[] args) throws Exception {
        DB_Connectivity connect = new DB_Connectivity();
        connect.getConnect();
        connect.log_in("sam","sam");
    }*/
}
