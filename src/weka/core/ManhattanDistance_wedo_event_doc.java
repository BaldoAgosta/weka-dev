/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *    ManhattanDistance.java
 *    Copyright (C) 2007 University of Waikato, Hamilton, New Zealand
 *
 */

package weka.core;

import java.util.ArrayList;

import weka.core.TechnicalInformation.Field;
import weka.core.TechnicalInformation.Type;
import weka.core.neighboursearch.PerformanceStats;

/**
 <!-- globalinfo-start -->
 * Implements the Manhattan distance (or Taxicab geometry) for wedo event doc. The distance between two points is the sum of the (absolute) differences of their coordinates.<br/>
 * <br/>
 * For more information, see:<br/>
 * <br/>
 * Wikipedia. Taxicab geometry. URL http://en.wikipedia.org/wiki/Taxicab_geometry.
 * <p/>
 <!-- globalinfo-end -->
 *
 <!-- technical-bibtex-start -->
 * BibTeX:
 * <pre>
 * &#64;misc{missing_id,
 *    author = {Wikipedia},
 *    title = {Taxicab geometry},
 *    URL = {http://en.wikipedia.org/wiki/Taxicab_geometry}
 * }
 * </pre>
 * <p/>
 <!-- technical-bibtex-end -->
 *
 <!-- options-start -->
 * Valid options are: <p/>
 * 
 * <pre> -D
 *  Turns off the normalization of attribute 
 *  values in distance calculation.</pre>
 * 
 * <pre> -R &lt;col1,col2-col4,...&gt;
 *  Specifies list of columns to used in the calculation of the 
 *  distance. 'first' and 'last' are valid indices.
 *  (default: first-last)</pre>
 * 
 * <pre> -V
 *  Invert matching sense of column indices.</pre>
 * 
 <!-- options-end --> 
 *
 * @author Fracpete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 1.2 $
 */
public class ManhattanDistance_wedo_event_doc
  extends ManhattanDistance {
  
  /** for serialization. */
  private static final long serialVersionUID = 6783782554224000243L;

  /**
   * Constructs an Manhattan Distance object, Instances must be still set.
   */
  public ManhattanDistance_wedo_event_doc() {
    super();
  }

  /**
   * Constructs an Manhattan Distance object and automatically initializes the
   * ranges.
   * 
   * @param data 	the instances the distance function should work on
   */
  public ManhattanDistance_wedo_event_doc(Instances data) {
    super(data);
  }

 

  public double distance(Instance first, Instance second,double cutOffValue, PerformanceStats stats)
  {
	  /*
	   * index 0 : id
	   * index 1 : tag1
	   * index 2 : tag2
	   * index 3 : tag3
	   * index 4 : tag4
	   * index 5 : tag5
	   * index 6 : tag6
	   * index 7 : tag7
	   * index 8 : tag8
	   * index 9 : tag9
	   * index 10 : tag10
	   * index 11 : class_label
	   * 
	   * after Remove()
	   * 
	   * index 0 : tag1
	   * index 1 : tag2
	   * index 2 : tag3
	   * index 3 : tag4
	   * index 4 : tag5
	   * index 5 : tag6
	   * index 6 : tag7
	   * index 7 : tag8
	   * index 8 : tag9
	   * index 9 : tag10
	   * 
	   */
	  
	  double dist = 0;
	  try{
	  	
	  ArrayList<String> second_array = new ArrayList<String>();
	  
	  for(int i = 0 ; i<10 ; i++)
	  {second_array.add(second.stringValue(i));}
	
	 for(int i = 0; i<10; i++)
	 {
		 int pos = second_array.indexOf(first.stringValue(i));
		 if(pos == -1) {dist = dist + 1500; continue;}
		 if( pos != i)
		 { dist = dist + (Math.abs(i - pos) * 100 );}
		 
	 }
	}
	  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	  return dist;
	  
  }


}
