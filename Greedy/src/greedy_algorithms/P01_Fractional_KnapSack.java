package greedy_algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class item  {
	int weight;
	int value;
	
	item(int v,int w){
		weight=w;
		value=v;
		
	}
	
	
	
}
class itemcompatotor implements Comparator<item>{
	
	@Override
	public int compare(item o1, item o2) {
		double g1=(o1.value)/(o1.weight);
		double g2=(o2.value)/(o2.weight);
		
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
	double finalweight=0.0;
	
	for(int i=0;i<n;i++) {
		if(curentweight+arr[i].weight<=weight) {
			curentweight+=arr[i].weight;  
			finalweight += arr[i].value;
		}else {
			int remain=weight-curentweight;
			finalweight+=((double)arr[i].value / (double)arr[i].weight) * (double)remain;
			break;
		}
	}
	
	
	
	return finalweight;
}
	
public static void main(String args[]) {
	int arraysize=3;
    int weight=50;
	item arr[]= {new item(100,20) ,new item(60, 10), new item(120,30) };
	
	double result=frctionknapsnak(weight,arr,arraysize);
	System.out.println(result);
	
	
}
}
