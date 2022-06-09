package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_largest {
public static void main(String args[]) {
	int arr[]= {3,2,1,5,6,4};
	int size=arr.length;
	int k=2;
	
	PriorityQueue<Integer> heap=new PriorityQueue<>();       //min heap
//	  PriorityQueue<Integer> heap= new PriorityQueue<Integer>( Collections.reverseOrder());   //max heap
	for(int i=0;i<size;i++) {
		heap.add(arr[i]);
		if(heap.size()>k) {
			heap.poll();
		}
	}
	
	System.out.println(heap.peek());
}
}
