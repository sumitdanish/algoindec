package com.algo.ds.practice.Queue;

import java.io.File;
import java.util.Scanner;

import com.algo.ds.practice.Node;

public class DoubleEndedQueue {

	/**
	 * @param args
	 */

	static MyQueue front;
	static MyQueue rear;
	static MyQueue myQueue;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			myQueue = new MyQueue();
			Scanner sc = new Scanner(new File("child1.txt"));
			String[] a = sc.next().split(",");
			Node list = null;
			DoubleEndedQueue cl = new DoubleEndedQueue();
			for (String s : a) {
				cl.insertNode(Integer.parseInt(s));
			}
			sc.close();
			myQueue.setFront(front);
			myQueue.setRear(rear);
			cl.display();
			System.out.println("\n______________\n");
			MyQueue m = cl.deQueueRear(myQueue);
			System.out.println(m.getData());
			MyQueue m1 = cl.deQueueFront(myQueue);
			System.out.println(">>" + m1.getData());
			System.out.println("\n______________\n");
			cl.display();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void insertNode(int data) {
		try {
			MyQueue m = new MyQueue(data);
			MyQueue temp = null;
			if (front == null && rear == null) {
				m.setPrevious(null);
				m.setNext(null);
				front = rear = m;
			} else {

				MyQueue mq = rear;
				while (mq.getNext() != null) {
					temp = mq;
					mq = mq.getNext();
				}
				mq.setNext(m);
				m.setPrevious(mq);
				m.setNext(null);
				mq = m;
				rear = mq;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void display() {
		try {
			MyQueue m = myQueue.getFront();
			while (m != null) {
				System.out.print(m.getData() + ",");
				m = m.getNext();
			}
			// System.out.println("\n______________\n");
			// MyQueue m1 = myQueue.getRear();
			// while(m1!=null)
			// {
			// System.out.print(m1.getData()+",");
			// m1=m1.getPrevious();
			// }

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private MyQueue deQueueRear(MyQueue myQueue) {
		try {
			if (myQueue.getFront() == myQueue.getRear()) {
				MyQueue m = myQueue.getFront();
				myQueue.setFront(null);
				myQueue.setRear(null);
				return m;
			}
			MyQueue m1 = myQueue.getRear();
			myQueue.setRear(m1.getPrevious());
			return m1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private MyQueue deQueueFront(MyQueue myQueue) {
		try {
			if (myQueue.getFront() == myQueue.getRear()) {
				MyQueue m = myQueue.getFront();
				myQueue.setFront(null);
				myQueue.setRear(null);
				return m;
			}
			MyQueue m1 = myQueue.getFront();
			myQueue.setFront(m1.getNext());
			return m1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
