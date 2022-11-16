
import MiniProject.Opration;
import MiniProject.Route;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException {

        File Fobjj = new File("src/MiniProject/File.csv");
        System.out.println(String.format("%16s %18s %25s %20s %20s", "From", "To", "Distance km", "Travel time", "Flight Type ID"));
        Opration Opn = new Opration();
        ArrayList<Route>list =Opn.reader(Fobjj);


        list.forEach(x-> System.out.println(x));
        System.out.println();

        //-----------------------------------------------------  Task2  ---------------------------------------------


        System.out.println("---------------------  Direct Flights   ----------------------------");
        System.out.println();
        Scanner cc = new Scanner(System.in);
        System.out.println(" Enter the Source City :-  ");
        String source = cc.nextLine();
        System.out.println();
        System.out.println(String.format("%16s  %18s  %25s %20s %20s ", "Form", "To", "Distance KM", "Travel Time", "Flight Type Id"));
        ArrayList<Route> availableFlight= Opn.displayFlightDetails(list,source);


        //------------------------------------------  Task 3 ---------------------------------------------------------



        System.out.println("::::::::::Enter Your Source City :");
        source = cc.nextLine();
        System.out.println("::::::::::Enter Your Destination City :");
        String destination= cc.nextLine();
        System.out.println("-------------------  Sorted Availeble  Flights   -------------------------------");
        System.out.println();
        System.out.println(String.format("%16s %18s %25s %20s %20s", "From", "To", "Distance in Km", "Travel Time", "Typical Airfare"));
        System.out.println();
        ArrayList<Route>SortedFlight= Opn.sortedFlights(  availableFlight);
        SortedFlight.forEach(k-> System.out.println(k));
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        ArrayList<Route>SotedAvailebleDirect= Opn.SortedAvailebleDirect(list,source,destination);
        SotedAvailebleDirect.forEach(l-> System.out.println(l));
        System.out.println("----------------------------------------------------------------------------------------------------");
        //-----------------------------------  task 4  connecting flight ---------------------------------------------------------

        System.out.println();
       System.out.println(String.format("%16s %18s %25s %20s %20s", "From", "To", "Distance in Km", "Travel Time", "Typical Airfare"));
        ArrayList<Route>showAllConnections= Opn.showAllConnections(list,source, destination);
        System.out.println("-----------------------------------------------------------------------------------------------");

    }

}
