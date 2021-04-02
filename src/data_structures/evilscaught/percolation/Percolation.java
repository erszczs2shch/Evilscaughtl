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
        

        int failsafe = 0; //For Testing Purposes
        while (percolates() == false && failsafe < ARRAY_SIZE)
        {
            int x = StdRandom.uniform(dimension);
            int y = StdRandom.uniform(dimension);
            
            open(x, y);

            failsafe++; //For Testing Purposes
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
        for (int row1 = 0; row1 < dimension; row1++)
        {
            int row1Index = convert2Dto1D(row1, 0);
            if ((percTree.connected(index, row1Index) == true) && (blockState[row1Index] != false) && (blockState[index] != false))
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
    public boolean percolates() 
    {
        //For each site on the top row, iterate and check to see if there is a connection a site on the bottom row. 
        
        for (int topRow = 0; topRow < dimension; topRow++)
        {
            int indexRowOne = convert2Dto1D(topRow, 0);
            
            for (int bottomRow = 0; bottomRow < dimension; bottomRow++)
            {
                int indexBottomRow = convert2Dto1D(bottomRow, dimension - 1);
                
                if ((percTree.connected(indexRowOne, indexBottomRow)) == true && (blockState[indexRowOne] != false) && (blockState[indexBottomRow] != false))
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
    
    //Call Percolation Stats, specify the size and the amount of times to run Percolation
    public static void main (String[] args)
    { 
      /*
      //Percolation perc = new Percolation(10);

      
      int N = 20;

      WeightedQuickUnionUF percTree = new WeightedQuickUnionUF(N * N);
      percTree.union(0, 1); 
      percTree.union(1, 4);
      percTree.union(15, 4);
      
      percTree.union(200, 201);
      percTree.union(201, 202);
      percTree.union(202, 203);
      percTree.union(204, 203);
      percTree.union(203, 0);
      System.out.println(percTree.connected(0, 1));
      for (int index = 0; index < N*N; index++)
      {
          System.out.println(percTree.find(index));
      }
      System.out.println("-----------------------");
      //System.out.println(percTree.count());
      //System.out.println(percTree.find(15));
      System.out.println(percTree.connected(202, 203));
      System.out.println(percTree.connected(202, 202));

      System.out.println("EXIT SUCCESS");
        
      //System.out.println(StdRandom.uniform(10));
       
      */
    }
}

