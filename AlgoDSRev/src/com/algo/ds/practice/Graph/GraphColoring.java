package com.algo.ds.practice.Graph;

import java.io.File;
import java.util.Scanner;

public class GraphColoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("color.txt"));
			int vertex = sc.nextInt();
			GraphColoring gl = new GraphColoring();
			GraphColorNodeList gln = new GraphColorNodeList(vertex,sc);
			GraphColorNode[] graph = gln.getGraphColorNode();
			GraphColorNode c = graph[0];
			while(c.getNext()!=null){
				System.out.print(c.getData()+",");
				c=c.getNext();
			}
			System.out.println();
			gl.graphColor(graph, vertex);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private void graphColor(GraphColorNode[] graph,int vertex){
		try{
			
			boolean[] isColor = new boolean[vertex];
			int[] result = new int[vertex];
			for(int i=0;i<vertex;i++){
				result[i] = -1;
				isColor[i] = false;
			}
			for(int i=0;i<vertex;i++){
				GraphColorNode gl = graph[i];
				while(gl!=null){
					if(result[gl.getData()]!=-1){
						isColor[result[gl.getData()]] = true;
					}
					gl =gl.getNext();
				}
				int cr=0;
				for(cr=0;cr<vertex;cr++){
					if(isColor[cr]==false){
						break;
					}
				}
				result[i]=cr;
				gl = graph[i];
				while(gl!=null){
					if(result[gl.getData()]!=-1){
						isColor[result[gl.getData()]]=false;
					}
					gl=gl.getNext();
				}
			}
			for(int i=0;i<vertex;i++){
				System.out.println(i+"-->"+result[i]);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}

class GraphColorNodeList
{
	private GraphColorNode[] graphList;
	public GraphColorNodeList(int vertex,Scanner sc){
		try{
			graphList = new GraphColorNode[vertex];
			for(int i=0;i<vertex;i++){
				graphList[i] = new GraphColorNode();
			}
			while(sc.hasNext()){
				String[] s = sc.next().split("--");
				int src = Integer.parseInt(s[0]);
				int dest = Integer.parseInt(s[1]);
				addEadge(src, dest);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public GraphColorNode[] getGraphColorNode(){
		return graphList;
	}
	public void addEadge(int src,int dest){
		try{
			graphList[src] = graphList[src].createNode(dest,graphList[src]);
			graphList[dest] = graphList[dest].createNode(src,graphList[dest]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


class GraphColorNode
{
	private int data;
	private GraphColorNode next;
	public GraphColorNode(){
		
	}
	public GraphColorNode(int data){
		this.data = data;
	}
	public void setData(int data){
		this.data=data;
	}
	public void setNext(GraphColorNode next){
		try{
			this.next = next;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public GraphColorNode getNext(){
		return next;
	}
	public int getData(){
		return data;
	}
	
	public GraphColorNode createNode(int data,GraphColorNode gl){
		try{
			
			if(!isVertex(gl, data)){
				GraphColorNode color = new GraphColorNode(data) ;
				color.setNext(gl);
				gl=color;
			}
			return gl;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean isVertex(GraphColorNode gl,int data){
		try{
			GraphColorNode g = gl;
			while(g!=null){
				if(data==g.getData()){
					return true;
				}
				g=g.getNext();
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
		
	}
}