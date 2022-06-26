package greedy_algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class item  {
	int weight;
	int cost;
	
	item(int w,int v){
		weight=w;
		cost=v;
		
	}
	
	
	
}
class itemcompatotor implements Comparator<item>{
	
	@Override
	public int compare(item o1, item o2) {
		double g1=(o1.cost)/(o1.weight);
		double g2=(o2.cost)/(o2.weight);
		
		if(g1<g2) {
			return 1;
		}
		else if(g1>g2) {
			return -1;
		}
		else
		 return 0;
	}
	
	
	
}
public class P01_Fractional_KnapSack {

static double frctionknapsnak(int weight,item arr[],int n) {
	Arrays.sort(arr,new itemcompatotor());
	
	int curentweight=0;
	double finalcost=0.0;
	
	for(int i=0;i<n;i++) {
		if(curentweight+arr[i].weight<=weight) {
			curentweight+=arr[i].weight;  
			finalcost += arr[i].cost;
		}else {
			int remain=weight-curentweight;
			finalcost+=((double)arr[i].cost / (double)arr[i].weight) * (double)remain;
			break;
		}
	}
	
	
	
	return finalcost;
}
	
public static void main(String args[]) {
	int arraysize=6;
    int weight=16;
//    6 10 3 5 1 3 item-weight
//    6 2 1 8 3 5 
	item arr[]= {new item(6,6) ,new item( 10,2), new item(3,1), new item(5,8), new item(1,3) , new item(3,5)};
	
	double result=frctionknapsnak(weight,arr,arraysize);
	System.out.println(result);
	
	
}
}
