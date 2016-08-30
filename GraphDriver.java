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

public int size(){
return graph.length;
}
public void addEdge(int source, int destination, int edgeweight){
	//System.out.println(graph[source]);
	Edge e=new Edge();
	e.destination=destination;
	e.weight=edgeweight;
	//System.out.println(graph);
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
public List<Edge> getNeighbours(int ip){
	return(graph[ip].neighbours);
	}
}



class GraphAlgorithms{
public static void dfs(int source, Graph input, boolean visited[]){
visited[source]=true;
System.out.println(source);
List<Edge> neighbours=input.getNeighbours(source);

Iterator itr=neighbours.iterator();


			while(itr.hasNext()){
				Edge e=(Edge)itr.next();
				if(!visited[e.destination])
				dfs(e.destination, input, visited);
				//System.out.print(e.destination+"("+e.weight+")"+",");
			}	
	}
}


class GraphDriver{
public static void main(String args[]){

	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	Graph g=new Graph(5);
	g.addEdge(3,1, 10);
	g.addEdge(0,3, 30);
	g.addEdge(0,2, 25);
	g.addEdge(3,4, 35);
	g.addEdge(2,4, 45);
	
	//System.out.println(g.getWeight(0,1));
	boolean visited[]=new boolean[g.size()];
	for(int i=0;i<visited.length;i++){
		visited[i]=false;	
	}
	GraphAlgorithms.dfs(0, g, visited);
	//g.display();
		
		
	}
}
