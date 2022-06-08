package greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class store{
	int activity;
	int start;
	int finish;
	
	store(int a,int s,int f){
		activity=a;
		start=s;
		finish=f;
	}
	
	store(){
		
	}
}

class compataorfun implements Comparator<store>{

	@Override
	public int compare(store o1, store o2) {
		if(o1.finish<o2.finish) {
			return -1;
		}else if(o1.finish>o2.finish) {
			return 1;
		}else if(o1.activity<o2.activity) {
			return -1;
		}
		
		
		return 1;
	}
	
}


public class P02_Activity_Selection {
public static void activity_selection(int start[],int end[],int n) {
	ArrayList<store> meet=new ArrayList<>();	
	
	for(int i=0;i<start.length;i++) {
		meet.add(new store(i+1,start[i],end[i]));
	}
	
	Collections.sort(meet,new compataorfun());
	ArrayList<Integer> answer=new ArrayList<>();
	
	answer.add(meet.get(0).activity);
	int limit=meet.get(0).finish;
	
	
	for(int i=0;i<start.length;i++) {
		if(meet.get(i).activity>limit) {
			limit=meet.get(i).finish;
			answer.add(meet.get(i).activity);
		}
	}
	
	for(int i=0;i<answer.size();i++) {
		System.out.print(answer.get(i) +" ");
	}
}
	public static void main(String args[]) {
//		ArrayList<store> arr=new ArrayList<store>();
//		
//		arr.add(new store(1,12,25)); 
//		arr.add(new store(2,10,20));
//		arr.add(new store(1,20,30));
		int n=6;
		int start[]= {1,3,0,5,8,5};
		int end[]= {2,4,5,7,9,9};
		
		activity_selection(start, end, n);
	}
}
