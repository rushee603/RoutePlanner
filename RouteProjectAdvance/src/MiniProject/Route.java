package MiniProject;

public class Route {

    String source;
    String destination;
    int distance;
    String time;
    String cost;

    public Route() {

    }

    //public Route(String destination, String cost, int distance, String source, String time)

    public Route(String source, String destination, int distance, String time, String cost) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
        this.cost = cost;


    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }



    @Override
    public String toString() {
        return (String.format("%16s %18s  %25s  %20s %20s", source, destination, distance, time, cost));
    }
}
