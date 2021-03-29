/* Author:              Scott McKay
 * Collaborators:       None
 * Date of Creation:    Saturday, September 17th, 2017 @8:35 p.m. MST
 * Purpose of Class:    
 * Notes:               Please note that 'evilscaught' in the package 'data_structures.evilscaught.percolation' is my GitHub user-name. 
 */

package data_structures.evilscaught.percolation;

public class PercolationStats 
{
    //Perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T)
    {
        if (N <= 0 || T <= 0) throw new java.lang.IllegalArgumentException();
        
        //TODO: Constructor must throw a java.lang.IllegalArgumentException if either N <= 0 or T <= 0
    }
    
    //Sample mean of percolation threshold
    public double mean()
    {
        //TODO: Implement
        return 0.0;
    }
    
    public double stddev()
    {
        //TODO: Implement
        return 0.0;
    }
    
    //Low end-point of 95% confidence interval
    public double confidenceLow()
    {
        //TODO: Implement
        return 0.0;
    }
    
    //High end-point of 95% confidence interval
    public double confidenceHigh()
    {
        //TODO: Implement
        return 0.0;
    }
}
