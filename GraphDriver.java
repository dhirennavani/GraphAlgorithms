import java.util.*;
import java.io.*;


class Edge{
public int destination;
public int weight;
}

class Node{
public List<Edge> neighbours;
Node(){
	neighbours=new ArrayList<Edge>();
	}
}

class Graph{

Node graph[];
Graph(int size){
	graph=new Node[size];
	for(int i=0;i<size;i++){
		graph[i]=new Node();
		}
	}
public void addEdge(int source, int destination, int edgeweight){
	System.out.println(graph[source]);
	Edge e=new Edge();
	e.destination=destination;
	e.weight=edgeweight;
	System.out.println(graph);
	graph[source].neighbours.add(e);
	
	}


public int getWeight(int source, int destination){
	Iterator itr=graph[source].neighbours.iterator();
	while(itr.hasNext()){
		Edge e=(Edge)itr.next();
		if(e.destination==destination){
			return e.weight;
			}
		}
	return (-100);
	}

public boolean edgeExists(int source, int destination){
	Iterator itr=graph[source].neighbours.iterator();
	while(itr.hasNext()){
		Edge e=(Edge)itr.next();
		if(e.destination==destination){
			return true;
			}
		}
	return false;
	}
public void display(){
		for(int i=0;i<graph.length;i++){
			System.out.print("\n Source "+i+"	");
			Iterator itr=graph[i].neighbours.iterator();
			while(itr.hasNext()){
				Edge e=(Edge)itr.next();
				System.out.print(e.destination+"("+e.weight+")"+",");
			}
		}
	}
}

class GraphDriver{
public static void main(String args[]){

	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	Graph g=new Graph(4);
	g.addEdge(0,1, 10);
	g.addEdge(2,3, 30);
	g.addEdge(2,1, 25);
	System.out.println(g.getWeight(0,1));
	g.display();
		
		
	}
}
