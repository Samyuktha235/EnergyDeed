import java.sql.SQLException;
import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static DB_Connectivity obj= new DB_Connectivity();
    static String mail,password,vehicle_number,fuel_type;
    public static void main(String[] args) throws Exception
    {
        obj.getConnect();
        welcome();
        display();
    }
    public static void welcome() throws Exception
    {
        System.out.println("WELCOME TO ENERGY DEEDS DUMP");
        System.out.println("1.Login\n2.SignUp");
        if(sc.nextInt()==1)
        {
            sc.nextLine();
            login();
        }
        else
        {
            sc.nextLine();
            signup();
            vehicle();
            System.out.println("Login to proceed further:");
            login();
        }
    }

    public static void signup() throws SQLException
    {
        System.out.println("Enter the username:");
        System.out.println("(Note:Enter your mail id)");
        mail=sc.nextLine().toLowerCase();
        System.out.println("Set the password");
        System.out.println("(Note:Your password should contain only 8 characters)");
        password=sc.nextLine();
        obj.sign_up(mail,password);
    }
    public static void login() throws Exception
    {
        System.out.println("Enter the username:");
        String mail=sc.nextLine().toLowerCase();
        System.out.println("Enter the password:");
        String password=sc.nextLine();
        obj.log_in(mail,password);
    }
    public static void vehicle() throws Exception
    {
        System.out.println("Enter the vehicle details:");
        System.out.println("Enter the vehicle Number:");
        vehicle_number=sc.nextLine().toLowerCase();
        System.out.println("Enter the Fuel type:\n1.Petrol\n2.Diesel");
        int fuel=sc.nextInt();
        sc.nextLine();
        if(fuel==1)
            fuel_type="Petrol";
        else
            fuel_type="Diesel";
        obj.vehicle_detail(mail,vehicle_number,fuel_type);
    }
    public static void display() throws Exception {
        while(true)
        {
        System.out.println("Choose the option below to proceed further:");
        System.out.println("1.Enter the Details");
        System.out.println("2.Get the Details");
        System.out.println("3.Add new vehicles");
        System.out.println("4.Exit");

        int n = sc.nextInt();
        sc.nextLine();
        switch (n)
        {
            case 1: {
                enterDetails();
                break;
            }
            case 2: {
                //obj.get_details();
                break;
            }
            case 3: {
                vehicle();
                break;
            }
            default: {
                exit();
                break;
            }
        }
    }
    }

    public static void enterDetails() throws Exception {
        System.out.println("Choose the Vehicle Number to enter the details");
       //to liat the available vehicles
        String veh=obj.listTheVehicles();
        //System.out.println(veh);
        System.out.println("Enter the date:");
        System.out.println("Day: [01-31]");
        int day=sc.nextInt();
        System.out.println("Month: [01-12]");
        int month=sc.nextInt();
        System.out.println("Year: ");
        int year=sc.nextInt();
        String date=""+year+"-"+month+"-"+day;
        System.out.println("Enter the fuel quantity:");
        int quantity=sc.nextInt();
        System.out.println("Choose the bunk id:");
        int bunk_id=obj.bunkList();
        System.out.println("Enter the odometer reading: ");
        int odo_read=sc.nextInt();
        obj.transaction(veh,date,quantity,bunk_id,odo_read,0,0);
    }
    public static void exit()
    {
        System.out.println("Thank you.Visit again.\nExited successfully");
        System.exit(0);
    }
}