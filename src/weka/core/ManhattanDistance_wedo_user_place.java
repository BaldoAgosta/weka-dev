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

import weka.core.TechnicalInformation.Field;
import weka.core.TechnicalInformation.Type;
import weka.core.neighboursearch.PerformanceStats;

/**
 <!-- globalinfo-start -->
 * Implements the Manhattan distance (or Taxicab geometry) for wedo user_place doc. The distance between two points is the sum of the (absolute) differences of their coordinates.<br/>
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
 * @author Baldassare Agosta (baldoagosta@gmail.com)
 * @version $Revision: 1.2 $
 */
public class ManhattanDistance_wedo_user_place
  extends ManhattanDistance {
  
  /** for serialization. */
  private static final long serialVersionUID = 6783782554224000243L;

  /**
   * Constructs an Manhattan Distance object, Instances must be still set.
   */
  public ManhattanDistance_wedo_user_place() {
    super();
  }

  /**
   * Constructs an Manhattan Distance object and automatically initializes the
   * ranges.
   * 
   * @param data 	the instances the distance function should work on
   */
  public ManhattanDistance_wedo_user_place(Instances data) {
    super(data);
  }

  
  
  public double distance(Instance first, Instance second,double cutOffValue, PerformanceStats stats)
  {
	  /*
	   * index 0 : id
	   * index 1 : first_latitude
	   * index 2 : first_longitude
	   * index 3 : second_latitude
	   * index 4 : second_longitude
	   * index 5 : class_label
	   * 
	   * 
	   * after Remove()
	   * 
	   * index 0 : first_latitude
	   * index 1 : first_longitude
	   * index 2 : second_latitude
	   * index 3 : second_longitude
	   */

	  double dist = 0;
	  try{
	  
	  /**
		 * This is the implementation Haversine Distance Algorithm between two places
		 * @author ananth
		 *  R = earth’s radius (mean radius = 6,371km)
		    Δlat = lat2− lat1
		    Δlong = long2− long1
		    a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
		    c = 2.atan2(√a, √(1−a))
		    d = R.c
		 *
		 */
		
		  final int R = 6371; // Radious of the earth
		  
		  Double lat11 = first.value(0);
	      
		  Double lon11 = first.value(1);
	      
		  Double lat21 = second.value(0);
	      
		  Double lon21 = second.value(1);
	      
		  Double latDistance = Math.toRadians(lat21-lat11);
	      Double lonDistance = Math.toRadians(lon21-lon11);
	      Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
	                 Math.cos(Math.toRadians(lat11)) * Math.cos(Math.toRadians(lat21)) * 
	                 Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	      Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	      Double distance1 = R * c;
	    
	      
	      Double lat12 = first.value(2);
	      
		  Double lon12 = first.value(3);
	      
		  Double lat22 = second.value(2);
	      
		  Double lon22 = second.value(3);
	      
		  Double latDistance2 = Math.toRadians(lat22-lat12);
	      Double lonDistance2 = Math.toRadians(lon22-lon12);
	      Double a2 = Math.sin(latDistance2 / 2) * Math.sin(latDistance2 / 2) + 
	                 Math.cos(Math.toRadians(lat12)) * Math.cos(Math.toRadians(lat22)) * 
	                 Math.sin(lonDistance2 / 2) * Math.sin(lonDistance2 / 2);
	      Double c2 = 2 * Math.atan2(Math.sqrt(a2), Math.sqrt(1-a2));
	      Double distance2 = R * c2;
	      
	      dist = distance1+distance2;
	  }
	  
	  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	  
	  return dist;
  }
  
  }
