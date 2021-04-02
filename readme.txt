/******************************************************************************
 *  Name: Scott McKay
 *  NetID: 790-733-656
 *
 *  Hours to complete assignment (optional): 24 Hours (still buggy + incomplete)										 
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
	Converted two dimensional coordinates into a one dimensional array. 
	There are two arrays, percTree (which keeps track of all the unions) and
	blockState (which keeps track of sites, i.e. if they're open or closed).
	 
	In theory, if any site at the bottom row is open, and has a connection with
	any site at the top row (that is also set to open), then it should percolate.
	
	Each site is automatically connected with its neighbors (if they're within the
	bounds of the two dimensional array and have already been set to open)


/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to around
 *  60 seconds. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be a multiple of the preceding data point
 *****************************************************************************/

(keep T constant)

 n          time (seconds)
------------------------------
... N/A
... N/A
... N/A
... N/A
... N/A


(keep n constant)

 T          time (seconds)
------------------------------
... N/A
... N/A
... N/A
... N/A
... N/A


/******************************************************************************
 *  Using the empirical data from the above two tables, give a formula 
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 T^1.5
 *
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Round each coefficient to two significant digits.
 *
 *****************************************************************************/

running time (in seconds) as a function of n and T:  ~ 


/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant)

 n         time (seconds)
------------------------------
... N/A
... N/A
... N/A
... N/A
... N/A


(keep n constant)

 T          time (seconds)
------------------------------
... N/A
... N/A
... N/A
... N/A
... N/A


running time (in seconds) as a function of n and T:  ~ 


/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an n-by-n grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your
 *  answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/

 N/A






 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
	Sometimes sites at the top row will not return as full. (Blue)
	Sometimes sites will not establish a connection with their neighbors.
	(Example: There will be an open site, not connected, in an ocean of Blue)
    Count doesn't return correctly for some reason.
    percolates() does not always return correctly.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
	Only asked a few basic questions to James.  

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
	Sites on the first row and first column would ALWAYS generate as open. (fixed)



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
	Assignment was fun, I wish I hadn't prioritized lesser important homework's
	(for other classes) before this one. (spent all day Sat. trying to fix Bash,
	spent all day Sun. reading sec. 1.4 in Algorithms)

