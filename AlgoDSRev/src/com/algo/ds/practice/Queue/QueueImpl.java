package com.algo.ds.practice.Queue;

import java.io.File;
import java.util.Scanner;

import com.algo.ds.practice.CreateLinkList;
import com.algo.ds.practice.Node;

public class QueueImpl {

	/**
	 * @param args
	 * 
	 *            Queue using singly link list
	 */

	static MyQueue front;
	static MyQueue rear;

	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(new File("queue.txt"));
			String[] a = sc.next().split(",");
			Node list = null;
			QueueImpl cl = new QueueImpl();
			for (String s : a) {
				cl.insert(Integer.parseInt(s));
			}
			sc.close();
			sc = new Scanner(new File("front.txt"));
			String[] a1 = sc.next().split(",");
			for (String s : a1) {
				cl.insertIntoFront(Integer.parseInt(s));
			}
			sc.close();
			cl.display();
			System.out.println("\n________________________________\n");
			int d = cl.getRearData();
			System.out.print(d + ",");

			int d1 = cl.getRearData();
			System.out.print(d1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void insert(int data) {
		try {
			MyQueue mq = new MyQueue(data);
			if (rear == null) {
				front = rear = mq;
			} else {
				MyQueue m = rear;
				while (m.getNext() != null) {
					m = m.getNext();
				}
				m.setNext(mq);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void insertIntoFront(int data) {
		try {
			MyQueue mq = new MyQueue(data);
			mq.setNext(front);
			front = mq;
			// rear=front;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int getRearData() {
		try {
			int d = rear.getData();
			rear = rear.getNext();
			return d;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void display() {
		try {
			MyQueue m = front;
			while (m != null) {
				System.out.print(m.getData() + ",");
				m = m.getNext();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
