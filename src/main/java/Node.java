import java.util.ArrayList;

public class Node {
    private String name;
    private double lon;
    private double lat;
    private ArrayList<Node> neighbors= new ArrayList<Node>();
    private Node previous;

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void addNeighbor(Node n){
        this.neighbors.add(n);
    }
    public ArrayList<Node> getNeighbors() {
        return this.neighbors;
    }

    public Node(String name, double lon, double lat){
        this.name = name;
        this.lon = lon;
        this.lat = lat;
    }
    public static double calculateH(Node x, Node y){
        double lon1 = x.getLon()*(Math.PI/180.0);
        double lat1 = x.getLat()*(Math.PI/180.0);
        double lon2 = y.getLon()*(Math.PI/180.0);
        double lat2 = y.getLat()*(Math.PI/180.0);


        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(lat1)
                * Math.cos(lat2) * Math.pow(Math.sin(dlon/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double km = 6367 * c;

        return km;
    }
    public double calculateG(Node source){
        //System.out.println("    Calculating G");
        double g = 0;
        Node current = this;

        while(current != source){
            //System.out.println("   Now at " + current.getName()+ " with G = "+g);
            g += calculateH(current, current.previous);
            //System.out.println("new G = "+g);
            current = current.previous;
        }
        return g;
    }
    public static double calculateF(Node source, Node current, Node target){
        double g = current.calculateG(source);
        //System.out.println("      G: "+g);
        double h = calculateH(current, target);
        //System.out.println("      H: "+h);
        return g + h;
    }
}
