package weka.core;

import java.util.ArrayList;

import weka.core.neighboursearch.PerformanceStats;

public class ManhattanDistance_wedo_user_doc extends ManhattanDistance{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7823968256606195062L;

	/**
	   * Constructs an Euclidean Distance object, Instances must be still set.
	   */
	  public ManhattanDistance_wedo_user_doc() {
	    super();
	  }

	  /**
	   * Constructs an Euclidean Distance object and automatically initializes the
	   * ranges.
	   * 
	   * @param data 	the instances the distance function should work on
	   */
	  public ManhattanDistance_wedo_user_doc(Instances data) {
	    super(data);
	  }
	  
	  public double distance(Instance first, Instance second,double cutOffValue, PerformanceStats stats)
	  {
		  
		  /*
		   * index 0 : id
		   * index 1 : gender
		   * index 2 : locale
		   * index 3 : age_range
		   * index 4 : fan1
		   * index 5 : fan2
		   * index 6 : fan3
		   * index 7 : fan4
		   * index 8 : fan5
		   * index 9 : fan6
		   * index 10 : fan7
		   * index 11 : fan8
		   * index 12 : fan9
		   * index 13 : fan10
		   * index 14 : class
		   *
		   * After remove()
		   * 
		   * index 0 : gender
		   * index 1 : locale
		   * index 2 : age_range
		   * index 3 : fan1
		   * index 4 : fan2
		   * index 5 : fan3
		   * index 6 : fan4
		   * index 7 : fan5
		   * index 8 : fan6
		   * index 9 : fan7
		   * index 10 : fan8
		   * index 11 : fan9
		   * index 12 : fan10
		   * 
		   * 
		   */
		  
		  
		  double dist = 0;
		  		  
		  try{
		 		  
		  if(!(first.stringValue(0).equals(second.stringValue(0))))
		  {dist = dist + 25;}
		  
		  if(!(first.stringValue(1).equals(second.stringValue(1))))
		  {dist = dist + 50;}
		  
		  if(first.value(2) != second.value(2))
		  {dist = dist + ( Math.abs(first.value(2) - second.value(2)) * 25);}
		  
		  ArrayList<String> second_array = new ArrayList<String>();
		  
		  for(int i = 3 ; i<13 ; i++)
		  {second_array.add(second.stringValue(i));}
		  
		  for(int i = 3; i<13; i++)
			 {
				 int pos = second_array.indexOf(first.stringValue(i));
				 if(pos == -1) {dist = dist + 1500; continue;}
				 if( pos + 3 != i)
				 { dist = dist + (Math.abs(i - (pos+3)) * 100 );}
				 
			 }
			    	  		  
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  		  
		  return dist;
	  }
			   
}
