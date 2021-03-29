/* Author:              Scott McKay
 * Collaborators:       None
 * Date of Creation:    Friday, September 15th, 2017 @5:45 p.m. MST
 * Purpose of Class:    Demonstration of the Percolation Simulation
 * Notes:               Please note that 'evilscaught' in the package 'data_structures.evilscaught.percolation' is my GitHub user-name. 
 */

package data_structures.evilscaught.percolation;

import java.lang.IllegalArgumentException;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;

public class Percolation 
{   
    private final int ARRAY_SIZE;
    private int       dimension;
    private int       count;

    private boolean[] blockState;
    
    private WeightedQuickUnionUF percTree;
    
    //Creates an N-by-N grid, with all sites initially blocked.
    public Percolation(int dimension)
    { 
        this.dimension = dimension;
        ARRAY_SIZE = dimension * dimension;
        count = 0;
        
        percTree = new WeightedQuickUnionUF(ARRAY_SIZE);
        blockState = new boolean[ARRAY_SIZE];
        

        while (percolates() == false)
        {
            int x = StdRandom.uniform(dimension);
            int y = StdRandom.uniform(dimension);
            
            open(x, y);
        }
    } 
    
    //Sets the state of a site to open (from closed).
    public void open(int row, int col)
    {
        //Ensure that row. and col. are within bounds of the array. 
        if ((row < 0) || (col < 0) || (row >= dimension) || (col >= dimension)) throw new IllegalArgumentException();
        
        int index = convert2Dto1D(row, col);
        blockState[index] = true;
        count++;
        
        //Check if site to the right (on x-axis) is open, if so, union. 
        if (row > 0)
        {
            int rowL = convert2Dto1D(row - 1, col);  //1D
            
            if (isOpen(row - 1, col) == true)
            {
                percTree.union(rowL, index);
            }
        }
        
        //Check if site to the left (on x-axis) is open, if so, union. 
        if (row < dimension - 1)
        {
            int rowR = convert2Dto1D(row + 1, col);  //1D
            
            if (isOpen(row + 1, col) == true)
            {
                percTree.union(rowR, index);
            }
        }
        
        //Check if site on row below is open (on y-axis), if so, union.
        if (col < dimension - 1)
        {
            int colDwn = convert2Dto1D(row, col + 1);
            
            if (isOpen(row, col + 1) == true)
            {
                percTree.union(index, colDwn);
            }
        }
        
        //Check if site on row above is open (on y-axis), if so, union.
        if (col > 0)
        {
            int colUp = convert2Dto1D(row, col - 1);
            
            if (isOpen(row, col - 1) == true)
            {
                percTree.union(index, colUp);
            }
        }
        
        
    }
    
    //Returns the current state of a site (open / closed).
    public boolean isOpen(int row, int col)
    {   
        //Ensure that row. and col. are within bounds of the array. 
        if ((row < 0) || (col < 0) || (row >= dimension) || (col >= dimension)) throw new IllegalArgumentException();
        
        int index = convert2Dto1D(row, col);
        return blockState[index];
    }
    
    //Returns whether or not the site is full (row, col).
    public boolean isFull(int row, int col)
    {   
        //Ensure that row. and col. are within bounds of the array.
        if ((row < 0) || (col < 0) || (row >= dimension) || (col >= dimension)) throw new IllegalArgumentException();
        
        
        int index = convert2Dto1D(row, col);
        for (int row1Index = 0; row1Index < dimension; row1Index++)
        {
            if (percTree.find(index) == percTree.find(row1Index))
            {
                return true;
            }
        }
        
        
        
        return false;
    }
    
    //Returns the number of open sites
    public int numberOfOpenSites()
    {
        return count;
    }
    
    //Does the N-by-N grid percolate?
    public boolean percolates()  //FIXME
    {
        //For each site on the top row, iterate and check the unions of every site on the bottom row. 
        for (int topRow = 0; topRow < dimension; topRow++)
        {
            int indexRowOne = convert2Dto1D(topRow, 0);
            
            for (int bottomRow = 0; bottomRow < dimension; bottomRow++)
            {
                int indexBottomRow = convert2Dto1D(bottomRow, dimension - 1);
                
                if (percTree.connected(indexRowOne, indexBottomRow) == true)
                {
                    return true;
                }
            }
        }      
        return false;
    }
    
    //Converts the coordinates of a two-dimensional array into a one-dimensional array.
    private int convert2Dto1D(int x, int y)
    {
        return (x * dimension) + y;
    }
    
    private int getX(int index)
    {
        return index / dimension;
    }
    
    private int getY(int index)
    {
        return index % dimension;
    }
    
    //Call Percolation Stats, specify the size and the amount of times to run Percolation
    public static void main (String[] args)
    {       
      int N = 20;

      WeightedQuickUnionUF percTree = new WeightedQuickUnionUF(N * N);
      percTree.union(0, 1); 
      percTree.union(1, 4);
      percTree.union(15, 4);


      //Create an array of ints (that will have values, 0, 1, 2, same size as 'overall' that gives information on each site
      //Overall will be used to indicate if it's in union.

      System.out.println(percTree.connected(0, 1));
      for (int index = 0; index < N*N; index++)
      {
          System.out.println(percTree.find(index));
      }
      System.out.println("-----------------------");
      System.out.println(percTree.count());
      System.out.println(percTree.find(15));
      //If 11 then it shares its corners with 1 [above], 21 [below], 10 [Left], and 12 [Right]
      //A two dimensional array of N = 10 would be transformed into a one dimensional array of 100. 
      //If max == 100, then any position above 90 would not have anything below it. 
      //
        
        
      System.out.println("EXIT SUCCESS");
        
      //System.out.println(StdRandom.uniform(10));
    }
}








