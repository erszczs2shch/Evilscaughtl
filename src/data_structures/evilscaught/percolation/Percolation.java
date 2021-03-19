/* Author:              Scott McKay
 * Collaborators:       None
 * Date of Creation:    Friday, September 15th, 2017 @5:45 p.m. MST
 * Purpose of Class:    Demonstration of the Percolation Simulation
 * Notes:               Please note that 'evilscaught' in the package 'data_structures.evilscaught.percolation' is my GitHub user-name. 
 */
package data_structures.evilscaught.percolation;

public class Percolation 
{   
    //Creates an N-by-N grid, with all sites initially blocked.
    public Percolation(int N)
    {
        //Constructor must take time proportional to N-squared
        //All methods should take constant time, and a constant number of calls to the union-find methods
        //union(), find(), connected(), and count()
    } 
    
    //Sets the state of a site to open (from closed).
    public void open(int row, int col)
    {
        //TODO: Implement, the constructor should throw a java.lang.IllegalArgumentException if N <= 0.
    }
    
    //Returns the current state of a site (open / closed).
    public boolean isOpen(int row, int col)
    {
        
        //TODO: Implement, the constructor should throw a java.lang.IllegalArgumentException if N <= 0.
        return false;
    }
    
    //Returns whether or not the site is full (row, col).
    public boolean isFull(int row, int col)
    {   
        //TODO: Implement, the constructor should throw a java.lang.IllegalArgumentException if N <= 0.
        return false;
    }
    
    //Returns the number of open sites
    public int numberOfOpenSites()
    {
        //TODO: Implement
        return 0;
    }
    
    //Does the N-by-N grid percolate?
    public boolean percolates()
    {
        //TODO: Implement
        return false;
    }
    
    //Unit testing
    public static void main (String[] args)
    {
        //TODO: Implement
    }
}