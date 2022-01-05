package waitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	private List<Integer> list = new ArrayList<Integer>();
	public static final int MAX = 10;

	// push - add element to stack
	public synchronized void push(Integer val) {
		while (list.size() == MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(val); // add an element to the end of the list
		notify();
	}

	// pop - take an element out of stack
	public synchronized Integer pop() {
		while (list.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int val = list.remove(list.size() - 1);
		notify();
		return val;

	}

}