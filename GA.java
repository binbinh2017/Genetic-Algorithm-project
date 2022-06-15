import java.util.ArrayList;

public class GA {
	public static ArrayList<ArrayList<Integer>> getAllSubset(ArrayList<Integer> L) {
		  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	       if (L.size() > 0) {
	    	 for(int i = 0; i < Math.pow(2, L.size()); i++) { 
	             ArrayList<Integer> subSet = new ArrayList<>();
	              int index = i; 
	                for (int j = 0; j < L.size(); j++) {
	                if ((index & 1) == 1) { 
	                subSet.add(L.get(j));
	        }

	           index >>= 1; 
	        }

	         result.add(subSet);  
	       }

	       return result;
	       } else {
	       return null;
	       }
	      }
	    public static ArrayList<ArrayList<Integer>>  getRandomValue(ArrayList<ArrayList<Integer>> lists){
	    	ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	     
	    	
	    	for(int i=0;i<1000;i++) {
	    	int size=lists.size();
	    	int myRand=(int)(Math.random() * (size));
	    	result.add(lists.get(myRand));
	    	lists.remove(myRand);	 
	    	}
	    	 
	          return result;
	    }
	    public static ArrayList<ArrayList<Integer>> getSecondGenerationSets(ArrayList<ArrayList<Integer>> lists){
	    	ArrayList<ArrayList<Integer>> SecondGenerationSet=new ArrayList<>();
	    	for(int i=0;i<500;i++) {
	    		int size=lists.size();
	    		int mySecondRand=(int)(Math.random() * (size));
	    		SecondGenerationSet.add(lists.get(mySecondRand));
	    		lists.remove(mySecondRand);
	    	}
	    	return SecondGenerationSet;
	    }
	    
	    
	    
	    
	    
	    public static void getSubsetSumAndFitness(ArrayList<Integer> lists) {
	    	
	    	ArrayList<ArrayList<Integer>> S1=getRandomValue(getAllSubset(lists));
	    	
	    	int sum1=0;
	        for(int i=0;i<lists.size();i++) {
	        	sum1=sum1+lists.get(i);
	        }
	         
	        ArrayList<Integer> S2=new ArrayList<>();
	        for(int j=0;j<S1.size();j++) {
	        	int subsetSum=0;
	        	for(int k=0;k<S1.get(j).size();k++) {
	        		
	        		
	        		subsetSum= subsetSum+S1.get(j).get(k);
	        		
	        	}
	        	/*System.out.println();*/
	        	/*System.out.print("The 1000 random subsetSums for index "+j+" is "+subsetSum);*/
	        	S2.add(subsetSum);
	        	
	        	/*if(subsetSum==sum1/2) {
	        		System.out.println(", This is the target subsetsum, and the target subset is "+S1.get(j));
	        	}*/
	        	
	        	 
	        }
	      /*  System.out.println();*/
	        /*System.out.println("The every subsetSum for the arrayList is: "+S2);*/
	        int count=0;
	        int mostFastValue=S2.get(0);
	        int mostCloseValue=S2.get(0);
	        ArrayList<Integer> mostFastSubset = S1.get(0);
	        ArrayList<Integer> mostCloseSubset = S1.get(0);
	        int n=0;
	        int n1=0;
	        while(n<S2.size()) {
	        	
	         
	        	if((double)(S2.get(n))/(sum1/2)>=0.8) {
	        		count++;
	        		
	        	}
	        	if(Math.abs(S2.get(n)-sum1/2)>=Math.abs(mostFastValue-sum1/2)) {
	        		if(S1.get(n)==null) {
	       			    
	        		break;
	        		}else {
	        		mostFastValue=S2.get(n);
	        		mostFastSubset =S1.get(n);
	        		
	        		}
	        		
	        	}
	        	
	        	 n++;
	        
	        }
	        while(n1<S2.size()) {
	        	if(Math.abs(S2.get(n1)-sum1/2)<=Math.abs(mostCloseValue-sum1/2)) {
	        		if(S1.get(n1)==null) {
	        			 
	        			break;
	        		}else {
	        		mostCloseValue=S2.get(n1);
	        		mostCloseSubset=S1.get(n1);
	        		
	        	}
	        		 
	        	}
	        	n1++;
	        }
	        System.out.println("The sum of the most fast subset is: "+mostFastValue+", the gap is :"+Math.abs(mostFastValue-sum1/2));
	        System.out.println("The sum of the most close subset is: "+mostCloseValue+", the gap is :"+Math.abs(mostCloseValue-sum1/2));
	        System.out.println("The most fast subset is: "+mostFastSubset);
	        System.out.println("The most close subset is: "+mostCloseSubset);
	        System.out.println("The adapting value is: "+count);
	        System.out.println("The fitness value is: "+(double)count/S2.size());
	    }
	    
	    public static void getSecondGenerationFitness(ArrayList<Integer>L) {
	    	int SetSum=0;
	    	for(int m=0;m<L.size();m++) {
	    		SetSum=SetSum+L.get(m);
	    	}
	    	ArrayList<ArrayList<Integer>>lists=getSecondGenerationSets(getRandomValue(getAllSubset(L)));
	    	int n=lists.size();
	    	
	    	ArrayList<Integer> secondGenerationaSubsetSum=new ArrayList<>();
	    	
	    	for(int i=0;i<n;i++) {
	    		int sum=0;
	    		for(int j=0;j<lists.get(i).size();j++) {
	    			sum=sum+lists.get(i).get(j);
	    		}
	    		secondGenerationaSubsetSum.add(sum);
	    	}
	    	int count=0;
	    	 for(int k=0;k<secondGenerationaSubsetSum.size();k++) {
	    		 
	    		 if((double)Math.abs(secondGenerationaSubsetSum.get(k)-SetSum/2)/(SetSum/2)>=0.8) {
	    			 count++;
	    		 }
	    	 }
	    	 System.out.println("The adapting value for the second generation is: "+count);
	    	 System.out.println("The fitness value for the second generation is: "+(double)count/lists.size());
	    	
	    }
	    
	 
	   public static void main(String[] args) {
		   System.out.println("---------------------small set test---------------------");
	       ArrayList<Integer> L = new ArrayList<>();
	        L.add(1);
	        L.add(2);
	        L.add(3);
	        L.add(4);
	        L.add(5);
	        L.add(6);
	        L.add(7);
	        L.add(8);
	        L.add(9);
	        L.add(10);
	        L.add(11);
	         
	        System.out.println("The size of small set is "+L.size());
	        /*System.out.println("All subsets of small set in an arraylist is: ");*/
	        /*System.out.println(getAllSubset(L)); */
	        System.out.println("The size of all subsets of small set in an arraylist is "+getAllSubset(L).size());
	         
	        /*System.out.println("The 1000 random subset of the small set in an arraylist is : " );*/
	        getSubsetSumAndFitness(L);
	        System.out.println("The second generation:");
	        getSecondGenerationFitness(L);
	        
	       System.out.println("---------------------medium set test---------------------");
	        ArrayList<Integer> L1 = new ArrayList<>();
	        L1.add(12);
	        L1.add(24);
	        L1.add(3);
	        L1.add(45);
	        L1.add(57);
	        L1.add(67);
	        L1.add(78);
	        L1.add(82);
	        L1.add(91);
	        L1.add(103);
	        L1.add(112);
	        L1.add(121);
	        L1.add(131);
	        L1.add(141);
	        L1.add(151);
	        L1.add(161);
	        
	        System.out.println("The size of small set is "+L1.size());
	       /* System.out.println("All subsets of small set in an arraylist is: ");
	        System.out.println(getAllSubset(L1));*/
	        System.out.println("The size of all subsets of small set in an arraylist is "+getAllSubset(L1).size());
	         
	      /* System.out.println("The 1000 random subset of the small set in an arraylist is : " );*/
	       
	        getSubsetSumAndFitness(L1);
	        System.out.println("The second generation:");
	        getSecondGenerationFitness(L1);
	        System.out.println("---------------------large set test---------------------");   
	        ArrayList<Integer> L2 = new ArrayList<>();
	        L2.add(131);
	        L2.add(201);
	        L2.add(344);
	        L2.add(412);
	        L2.add(556);
	        L2.add(655);
	        L2.add(700);
	        L2.add(812);
	        L2.add(945);
	        L2.add(1011);
	        L2.add(1111);
	        L2.add(1234);
	        L2.add(1334);
	        L2.add(1443);
	        L2.add(153);
	        L2.add(162);
	        L2.add(1776);
	        L2.add(1898);
	        L2.add(1909);
	        L2.add(2008);
	        L2.add(2122);
	        L2.add(2223);
	        L2.add(2334);
	        L2.add(2446);
	        System.out.println("The size of small set is "+L2.size());
	        /*System.out.println("All subsets of small set in an arraylist is: ");*/
	        /*System.out.println(getAllSubset(L2));*/
	        System.out.println("The size of all subsets of small set in an arraylist is "+getAllSubset(L2).size());
	         
	       /* System.out.println("The 1000 random subset of the small set in an arraylist is : " );*/
	        getSubsetSumAndFitness(L2);
	        System.out.println("The second generation:");
	        getSecondGenerationFitness(L2);
	       
	   }

}
