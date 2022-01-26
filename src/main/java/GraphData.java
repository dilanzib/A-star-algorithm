import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class GraphData {

    public static ArrayList<Node> createGraph() {

        ArrayList<Node> graph = new ArrayList<Node>();
        graph.add(new Node("Böle", 60.20110783454492, 24.936013486760753));
        graph.add(new Node("Vallgård", 60.192146399719675, 24.96214941891928));
        graph.add(new Node("Berghäll", 60.183771016183734, 24.953673483607357));
        graph.add(new Node("Tölö", 60.18347257488833, 24.917520185456596));
        graph.add(new Node("Oodi", 60.173973617003725, 24.938147255798278));
        graph.add(new Node("Richardsgatan", 60.16633879263839, 24.946329687305546));
        graph.add(new Node("Busholmen", 60.15999665882044, 24.920892270113654));

        //Böle
        graph.get(0).addNeighbor(graph.get(3)); // Add Tölö
        graph.get(0).addNeighbor(graph.get(2)); // Add Berghäll
        //Vallgård
        graph.get(1).addNeighbor(graph.get(2)); // Add Berghäll§
        //Berghäll
        graph.get(2).addNeighbor(graph.get(0)); // Add Böle
        graph.get(2).addNeighbor(graph.get(1)); // Add Vallgård
        graph.get(2).addNeighbor(graph.get(3)); // Add Tölö
        graph.get(2).addNeighbor(graph.get(4)); // Add Oodi
        //Tölö
        graph.get(3).addNeighbor(graph.get(0)); // Add Böle
        graph.get(3).addNeighbor(graph.get(2)); // Add Berghäll
        graph.get(3).addNeighbor(graph.get(4)); // Add Oodi
        graph.get(3).addNeighbor(graph.get(6)); // Add Busholmen
        //Oodi
        graph.get(4).addNeighbor(graph.get(3)); // Add Tölö
        graph.get(4).addNeighbor(graph.get(2)); // Add Berghäll
        graph.get(4).addNeighbor(graph.get(5)); // Add Richardsgatan
        //Richardsgatan
        graph.get(5).addNeighbor(graph.get(4)); // Add Oodi
        graph.get(5).addNeighbor(graph.get(6)); // Add Busholmen
        //Busholmen
        graph.get(6).addNeighbor(graph.get(3)); // Add Tölö
        graph.get(6).addNeighbor(graph.get(5)); // Add Richardsgatan

        return graph;
    }
    public static void showNodesAndLinks(ArrayList<Node> graph){
        for(int i = 0; i < graph.size(); i++){
            System.out.println(graph.get(i).getName());
            ArrayList<Node> nbors = graph.get(i).getNeighbors();
            for(int j = 0; j < nbors.size(); j++){
                System.out.println("  "+nbors.get(j).getName());
            }
        }
    }

}
