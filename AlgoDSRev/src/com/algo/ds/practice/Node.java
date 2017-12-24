package com.algo.ds.practice;

public class Node {

	private int data;
	private Node nextNode;
	private Node randomNode;
	private Node previous;
	private Node child;
	private Node random;

	public Node(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getRandomNode() {
		return randomNode;
	}

	public void setRandomNode(Node randomNode) {
		this.randomNode = randomNode;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

	public Node getRandom() {
		return random;
	}

	public void setRandom(Node random) {
		this.random = random;
	}

}
