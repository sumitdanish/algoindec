package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class EulerianPathCycle {

	/**
	 * @param args
	 * //  If count is more than 2, then graph is not Eulerian
		    if (odd > 2)
		        return 0;
		 
		    // If odd count is 2, then semi-eulerian.
		    // If odd count is 0, then eulerian
		    // Note that odd count can never be 1 for undirected graph
	 */
	public static void main(String[] args) {
		try{
			EulerianPathCycle ec = new EulerianPathCycle();
			Scanner sc = new Scanner(new File("euler.txt"));
			int vertex = sc.nextInt();
			EulerianGraphList eu = new EulerianGraphList(vertex,sc);
			EulerianGraph[] egl = eu.getEulerianGraph();
			int e = ec.isEulerian(egl, vertex);
			if(e==0){
				System.out.println("Eulerian circuit");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean DFS(EulerianGraph[] egl,boolean[] visited,int s){
		try{
			visited[s]=true;
			EulerianGraph eg = egl[s];
			while(eg!=null){
				if(!visited[eg.getData()]){
					DFS(egl,visited,eg.getData());
				}
				eg = eg.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean isEulerianCircuit(EulerianGraph[] egl,int vertex){
		try{
			boolean[] visited = new boolean[vertex];
			int i=0;
			for(int i1=0;i1<vertex;i1++){
				visited[i1]=false;
			}
			for(i=0;i<vertex;i++){
				if(size(egl[i])>0){
					break;
				}
			}
			if(i==vertex){
				return false;
			}
			DFS(egl, visited,i);
			for(int j=0;j<vertex;j++){
				if(!visited[j]&&size(egl[j])>0){
					return false;
				}
			}
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	private int isEulerian(EulerianGraph[] egl,int vertex){
		try{
			boolean b = isEulerianCircuit(egl, vertex);
			if(!b){
				return 0;
			}
			int degree=0;
			for(int i=0;i<vertex;i++){
				int s = size(egl[i]);
				if((s)%2!=0){
					degree++;
				}
			}
			if(degree>2){
				return degree;
			}
			return degree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	public int size(EulerianGraph list){
		try{
			EulerianGraph el = list;
			int i=0;
			while(el!=null){
				i++;
				el=el.getNext();
			}
			return i;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}


class EulerianGraphList
{
	private EulerianGraph[] eulerianGraph;
	public EulerianGraphList(int vertex,Scanner sc){
		eulerianGraph = new EulerianGraph[vertex];
		for(int i=0;i<vertex;i++){
			eulerianGraph[i] = new EulerianGraph();
		}
		while(sc.hasNext()){
			String[] st = sc.next().split("--");
			int src = Integer.parseInt(st[0]);
			int dest = Integer.parseInt(st[1]);
			addEadge(src, dest);
		}
	}
	
	public EulerianGraph[] getEulerianGraph(){
		return eulerianGraph;
	}
	
	public void addEadge(int src,int dest){
		try{
			eulerianGraph[src] = eulerianGraph[src].createList(eulerianGraph[src], dest);
			eulerianGraph[dest] = eulerianGraph[dest].createList(eulerianGraph[dest], src);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class EulerianGraph
{
	private int data;
	private EulerianGraph  next;
	public EulerianGraph(){
		
	}
	public EulerianGraph(int data){
		this.data = data;
	}
	
	public void setNext(EulerianGraph next){
		this.next = next;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public EulerianGraph getNext(){
		return next;
	}
	
	public int getData(){
		return data;
	}
	
	
	
	public EulerianGraph createList(EulerianGraph list,int data){
		try{
			if(!isVertexPresent(data, list)){
				EulerianGraph g = new EulerianGraph(data);
				g.setNext(list);
				list = g;
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public boolean isVertexPresent(int data,EulerianGraph list){
		try{
			EulerianGraph l = list;
			while(l!=null){
				if(l.getData()==data){
					return true;
				}
				l=l.getNext();
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
}