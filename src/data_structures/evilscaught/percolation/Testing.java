package data_structures.evilscaught.percolation;

public class Testing {

    static int dimension = 10;
    
    public static void main(String[] args) 
    {
        int x = 0;
        int y = 0;
        
        if (x >= dimension || y >= dimension)
        {
             throw new IllegalArgumentException();
        }
        
        int index = convert2Dto1D(x, y);
        
        System.out.println("x-value: " + x + " y-value: " + y);
        System.out.println("Index Location: " + index);
        System.out.println("Success!");
        System.out.println("Location to the Left is: " + (index - dimension));
        System.out.println("This can be proved by converting that index back to its native coordinates. The x-value is: " + getX(index - dimension) + ". And the y-value is: " + getY(index - dimension));
        System.out.println("Location to the Right is: " + (index + dimension));
        System.out.println("This can be proved by converting that index back to its native coordinates. The x-value is: " + getX(index + dimension) + ". And the y-value is: " + getY(index + dimension));
        System.out.println("Location above is: " + (index - 1));
        System.out.println("This can be proved by converting that index back to its native coordinates. The x-value is: " + getX(index) + ". And the y-value is: " + getY(index - 1));
        System.out.println("Location above is: " + (index + 1));
        System.out.println("This can be proved by converting that index back to its native coordinates. The x-value is: " + getX(index) + ". And the y-value is: " + getY(index + 1));
        
        
        
        //Notes:
        //if 
    }
    
    
    private static int convert2Dto1D(int x, int y)
    {
        return (x * dimension) + y;
    }
    
    private static int getX(int index)
    {
        return index / dimension;
    }
   
    private static int getY(int index)
    {
        return index % dimension;
    }
}
