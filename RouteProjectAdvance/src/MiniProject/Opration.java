package MiniProject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Opration {
    public ArrayList<Route> reader(File Fobj) throws IOException {

        ArrayList<Route> routelist = new ArrayList<>();
        try (BufferedReader bb = new BufferedReader(new FileReader(Fobj))) {

            int i = 0;
            String temp;

            while ((temp = bb.readLine()) != null) {
                String[] tempArray = temp.split(",");
                int distance = Integer.parseInt(tempArray[2].trim());
                routelist.add(new Route(tempArray[0].trim(),tempArray[1].trim(),distance,tempArray[3].trim(),tempArray[4].trim()));
                i++;

            }

        } catch (Exception a) {
            System.out.println("This Is Empty..!!");
        }
             return routelist;
    }

    //---------------------------------------------Task2 (Direct Flight)-----------------------------------------------
    public  ArrayList<Route> displayFlightDetails(ArrayList<Route> routelist, String source) {
        ArrayList<Route> dflightDetails;
        dflightDetails= (ArrayList<Route>) routelist.stream().filter(x -> x.getSource().equalsIgnoreCase(source)).collect(Collectors.toList());
        dflightDetails.forEach(x ->System.out.println(x));

        if (dflightDetails.isEmpty())
        {
            System.out.println("  We Are sorry!!  At this time We do not have any information for this flight from " + source);
            System.exit( 0);
        }
             return dflightDetails;

    }
    //-------------------------------------------------Task3 (SortedFlights)-------------------------------------------
    public ArrayList<Route> sortedFlights(ArrayList<Route> dflightDetails )
    {
        Collections.sort(dflightDetails,(a, b)-> a.getDestination().compareToIgnoreCase(b.getDestination()));


        return dflightDetails;
    }
    public ArrayList<Route> SortedAvailebleDirect(ArrayList<Route> dflightDetails, String source, String destination)
    {
        ArrayList<Route>availebleDirect1= (ArrayList<Route> ) dflightDetails.stream().filter(a->(a.getSource().equalsIgnoreCase(source
        ))&&(a.getDestination().equalsIgnoreCase(destination))).collect(Collectors.toList());

        return availebleDirect1;



    }

    //----------------------------------------task 4 (connecting files)--------------------------------------------------

    public  ArrayList<Route>showAllConnections(ArrayList<Route> list,String source,String destination) {
        AtomicInteger count = new AtomicInteger();
        int count1 = 0;
        list.stream().filter(x -> x.getSource().trim().equals(source.trim())).filter(j -> j.destination.trim().equals(destination.trim())).forEach(i -> System.out.println(i + "\n"));
        list.stream().filter(x -> x.getSource().trim().equals(source.trim())).filter(j -> j.destination.trim().equals(destination.trim())).forEach(x -> count.set(count.get() + 1));
        if (count.get() == 0) {
            System.out.println("--->>>  sorry. At this point of time, we do not have any information on flights between " + source + " and " + destination);
        }


        for (Route x : list) {
            String intermediate = x.destination.trim();
            if (x.source.trim().equals(source) && x.destination.trim().equals(intermediate.trim())) {

                for (Route y : list) {
                    if (intermediate.trim().equals(y.source.trim()) && y.destination.trim().equals(destination.trim())) {

                        if (y.source.trim().equals(intermediate.trim())) {

                            count1++;
                            System.out.println("----------------------------Connecting Flights----------------------------------------");
                            System.out.println(x);
                            System.out.println(y + "\n");
                        }
                    }
                }
            }

        }
        return list;
    }
}
















