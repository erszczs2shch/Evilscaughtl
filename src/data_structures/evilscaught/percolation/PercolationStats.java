/* Author:              Scott McKay
 * Collaborators:       None
 * Date of Creation:    Saturday, September 17th, 2017 @8:35 p.m. MST
 * Purpose of Class:    Returns statistical analysis of Percolation class.
 * Notes:               Please note that 'evilscaught' in the package 'data_structures.evilscaught.percolation' is my GitHub user-name. 
 */

package data_structures.evilscaught.percolation;

public class PercolationStats 
{
    private int count;
    private int confidenceLow;
    private int confidenceHigh;
    private int times; //Times the experiment was ran.
    
    private Percolation perc;

    
    //Perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T)
    {
        if (N <= 0 || T <= 0) throw new java.lang.IllegalArgumentException();
        
        times = T;

        confidenceLow = N;
        confidenceHigh = 0;
        for (int iterator = 0; iterator < T; iterator++)
        {
             perc = new Percolation(N);
             count += perc.numberOfOpenSites();
             
             if (perc.numberOfOpenSites() < confidenceLow)
             {
                 confidenceLow = perc.numberOfOpenSites();
             }
             if (perc.numberOfOpenSites() >= confidenceLow)
             {
                 confidenceHigh = perc.numberOfOpenSites();
             }
             
        }
    }
    
    //Sample mean of percolation threshold
    public double mean()
    {
        
        return count / times;
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
        return confidenceLow;
    }
    
    //High end-point of 95% confidence interval
    public double confidenceHigh()
    {
        //TODO: Implement
        return confidenceHigh;
    }
}
