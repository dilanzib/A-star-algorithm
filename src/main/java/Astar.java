import java.util.ArrayList;

public class Astar {
    public static ArrayList<Node> getRoute(Node source, Node target) {
        int l = 0;
        ArrayList<Node> candidates = new ArrayList<Node>();
        ArrayList<Node> visited = new ArrayList<Node>();
        Node current = source;
        Boolean done = false;
        while (!done) {
            if(++l > 20) System.exit(0);
            double minF = 0;
            Node next = null;
            ArrayList<Node> currentNeighbors = current.getNeighbors();
            for (int i = 0; i < currentNeighbors.size(); i++) {
                if (!candidates.contains(currentNeighbors.get(i)) && !visited.contains(currentNeighbors.get(i))) {
                    candidates.add(currentNeighbors.get(i));
                }
                if(!visited.contains(currentNeighbors.get(i))){
                    //if currents neighbor isn't visited, set it's previous as the current
                    currentNeighbors.get(i).setPrevious(current);
                }



            }
            for (int i = 0; i < candidates.size(); i++) {
                if (current == target) {
                    done = true;
                    break;
                } else {
                    double f = Node.calculateF(source, candidates.get(i), target);
                    if (minF == 0 || f < minF) {
                            minF = f;

                        next = candidates.get(i);
                    }
                }
            }
            if (!done) {
                visited.add(current); //add the current node to the visited
                // Jonnys pseudocode first assigned current to next and added THAT node to visited, which I do not understand
                current = next;
                candidates.remove(current);
            }
        }
        ArrayList<Node> route = new ArrayList<Node>();
        current = target;
        while(current != source){
            route.add(current);
            current = current.getPrevious();
        }
        route.add(current);
        return route;
    }

    public static void printRoute(ArrayList<Node> route){
        System.out.println("\nShortest Route: ");
        for(int i = route.size(); i > 0; i--){
            System.out.println("   "+(route.size()-i+1)+". "+route.get(i-1).getName());
        }
    }
    public static void showContents(ArrayList<Node> list, String id){
        System.out.println(id+" : ");
        for(int i = 0; i < list.size(); i++){
            System.out.println("   "+list.get(i).getName());
        }
    }
}
