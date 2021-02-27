package roadgraph;

import java.util.ArrayList;

import geography.GeographicPoint;

public class Node {
	private GeographicPoint location;
	private ArrayList<Edge> edges;

	public Node(GeographicPoint location) {
		super();
		this.location = location;
		edges = new ArrayList<>();
	}

	public GeographicPoint getLocation() {
		return location;
	}

	public void setLocation(GeographicPoint location) {
		this.location = location;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

}
