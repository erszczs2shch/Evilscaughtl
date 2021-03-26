/* Author:              Scott McKay
 * Collaborators:       None
 * Date of Creation:    Friday, September 15th, 2017 @5:45 p.m. MST
 * Purpose of Class:    Demonstration of the Percolation Simulation
 * Notes:               Please note that 'evilscaught' in the package 'data_structures.evilscaught.percolation' is my GitHub user-name. 
 */
package data_structures.evilscaught.percolation;
import java.lang.IllegalArgumentException;

public class Percolation 
{   
    private int[][] sites;
    
    //Creates an N-by-N grid, with all sites initially blocked.
    public Percolation(int N)
    {
        sites = new int[N][N];
        
        for (int row = 0; row < N; row++)
        {
            for (int col = 0; col < N; col++)
            {
                sites[row][col] = 1;
            }
        }
        
        //Constructor must take time proportional to N-squared
        //All methods should take constant time, and a constant number of calls to the union-find methods
        //union(), find(), connected(), and count()
    } 
    
    //Sets the state of a site to open (from closed).
    public void open(int row, int col)
    {
        //Ensure that row. and col. are within bounds of the array. 
        if ((row < 0) || (col < 0) || (row >= sites.length) || (col >= sites.length)) throw new IllegalArgumentException();
        
        
    }
    
    //Returns the current state of a site (open / closed).
    public boolean isOpen(int row, int col)
    {   
        //Ensure that row. and col. are within bounds of the array. 
        if ((row < 0) || (col < 0) || (row >= sites.length) || (col >= sites.length)) throw new IllegalArgumentException();

        //If site is set to 0 (closed), return false. 
        if (sites[row][col] == 0) return false;

        //Else, return true
        return true;
    }
    
    //Returns whether or not the site is full (row, col).
    public boolean isFull(int row, int col)
    {   
        //Ensure that row. and col. are within bounds of the array.
        if ((row < 0) || (col < 0) || (row >= sites.length) || (col >= sites.length)) throw new IllegalArgumentException();
        
        //If the site is percolating, return true.
        if (sites[row][col] == 2) return true;

        //Else, return false.
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
    
    //TODO: Unit Testing
    //Call Percolation Stats, specify the size and the amount of times to run Percolation
    public static void main (String[] args)
    {
        Percolation perc = new Percolation(3);
        System.out.println(perc.isOpen(0, 2));
    }
}