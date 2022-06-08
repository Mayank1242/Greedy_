package greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

class Job{
	int sno;
	int profit;
	int deadline;
	
	Job(int s,int p,int d){
		this.sno=s;
		this.profit=p;
		this.deadline=d;
	}
	
	
}
public class P03_Job_Sequencing {

public static ArrayList<Integer> jobscheduling(Job arr[],int n) {
	Arrays.sort(arr,(a,b)->(b.profit-a.profit));
	int max=0;
	for(int i=0;i<n;i++) {
		if(arr[i].deadline>max) {
			max=arr[i].deadline;
		}
	}
	int array[]=new int[max+1];
	for(int i=1;i<=max;i++) {
		array[i]=-1;
	}
	
	int countjobs=0;
	int totalprofit=0;
	for(int i=0;i<n;i++) {
		for(int j=arr[i].deadline;j>0;j--) {
			if(array[j]==-1) {
				array[j]=i;
				countjobs++;
				totalprofit+=arr[i].profit;
				break;
			}
		}
	}
	
	ArrayList<Integer> ans=new ArrayList<Integer>();
	
			ans.add(countjobs);
	ans.add(totalprofit);
	
	return ans;
}
	
public static void main(String args[]) {
	Job arr[]=new Job[5];
	arr[0]= new Job(1,20,2);
	arr[1]= new Job(2,40,1);
	arr[2]= new Job(3,10,6);
	arr[3]= new Job(4,50,3);
	arr[4]= new Job(5,60,1);
	
	ArrayList<Integer> result=jobscheduling(arr,5 );
	System.out.print("Total jobs are done is:" +result.get(0)+"\nTotal profit is:"+result.get(1));
}
}
