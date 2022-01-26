import java.util.ArrayList;

/**
 * Projekt 1 - ruttsökning
 *
 * Datastrukturer och algoritmer 2021
 *
 * Programmeringsteam:
 *
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<Node> graph = GraphData.createGraph();

		GraphData.showNodesAndLinks(graph);
		ArrayList<Node> route = Astar.getRoute(graph.get(0), graph.get(4));
		Astar.printRoute(route);

		ArrayList<Node> route2 = Astar.getRoute(graph.get(1), graph.get(6));
		Astar.printRoute(route2);
		//*/
	}

}

