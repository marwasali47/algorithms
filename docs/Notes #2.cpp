~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



// Factorial(n) = n * Factorial(n-1).		Factorial(0) = Factorial(1) = 1
int Fact(int n){

	if(n <= 1)
		return 1;

	return n * Fact(n-1);
}



/*

Fact(4)
	4* Fact(3)
		3* Fact(2)
			2* Fact(1)
			2* 1 <-- 2
		3* 2 <-- 6
	4* 6 <-- 24
*/


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


void Triangle(int x) {

   if (x <= 0) return;

   Triangle(x - 1);

   for (int i = 1; i <= x; i++)
        cout << "*";
   cout << endl;
}


/*
Call Triangle(7)
Triangle(7)
  Triangle(6)
    Triangle(5)
      Triangle(4)
        Triangle(3)
          Triangle(2)
            Triangle(1)
              Triangle(0) <-- base case
            Triangle(1) <-- prints 1 star & new line
          Triangle(2) <-- prints 2 stars & new line
        Triangle(3) <-- prints 3 stars & new line
      Triangle(4) <-- prints 4 stars & new line
    Triangle(5) <-- prints 5 stars & new line
  Triangle(6) <-- prints 6 stars & new line
Triangle(7) <-- prints 7 stars & new line

The output will be:

*
**
***
****
*****
******
*******
*/


void TriangleRev(int x) {

   if (x <= 0) return;

   for (int i = 1; i <= x; i++)
        cout << "*";

	cout << endl;

	TriangleRev(x - 1);

	return;
}

/*


Call TriangleRev(7)
TriangleRev(7) <-- prints 7 stars & new line
  TriangleRev(6) <-- prints 6 stars & new line
    TriangleRev(5) <-- prints 5 stars & new line
      TriangleRev(4) <-- prints 4 stars & new line
        TriangleRev(3) <-- prints 3 stars & new line
          TriangleRev(2) <-- prints 2 stars & new line
            TriangleRev(1) <-- prints 1 star & new line
              TriangleRev(0) <-- base case
            TriangleRev(1)
          TriangleRev(2)
        TriangleRev(3)
      TriangleRev(4)
    TriangleRev(5)
  TriangleRev(6)
TriangleRev(7)

The output will be:
*******
******
*****
****
***
**
*


*/


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




// Given grid of positive numbers, Start from 0, 0 and end at n, n. Move only to right and down - find path with sum of numbers is maximum.
/*
15
24

5121
6942
1891
0199
*/

int grid[MAX][MAX];

// Think in function F(i, j) that find solution from (i, j) to (n, n)

int maxPathSum(int r, int c){

	if( !valid(r, c))
		return 0;

	if (r == n-1 && c == n-1)
		return grid[r][c];	// base

	int path1 = maxPathSum(r, c+1);	// right
	int path2 = maxPathSum(r+1, c);	// down

	return grid[r][c] + max(path1, path2);
}



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



/*

.SX..
..X.E
....X
X.XX.

 */

char maze[MAX][MAX];	// filled with S (for start), E (for end), . (could pass) and X (block can't path)
bool findEnd(int r, int c)		// Recursion State: r, c
{
    if( !valid(r, c) || maze[r][c] == 'X')
		return false;		// invalid position or block position


    if( maze[r][c] =='E')
		return true;	// we found End

	// Try the 4 neighbor cells

		if(findEnd(r, c-1)) return true;  	// search up
    if(findEnd(r, c+1)) return true; 	// search down
    if(findEnd(r-1, c)) return true;  	// search left
    if(findEnd(r+1, c)) return true;  	// search right

	// Can't find a way for it!
    return false;
}




// We need to avoid cycles. Mark visited cells

bool vis[MAX][MAX];
bool findEnd2(int r, int c){	// Recursion State: r, c	and FULL visted array

    if( !valid(r, c) || maze[r][c] == 'X' || vis[r][c] == 1)
		return false;		// invalid position or block position


	vis[r][c] = 1;	// we just visited it, don't allow any one bacl to it

    if( maze[r][c] =='E')
		return true;	// we found End

	// Try the 4 neighbor cells

		if(findEnd2(r, c-1)) return true;  	// search up
    if(findEnd2(r, c+1)) return true; 	// search down
    if(findEnd2(r-1, c)) return true;  	// search left
    if(findEnd2(r+1, c)) return true;  	// search right

	// Can't find a way for it!
    return false;
}


~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// exponential: c^n (e.g. 2^n)

// generate all sequences of given length, of zeros and ones
// E.g. for len = 3:	000, 001, 010, 011, 100, 101, 110, 111
//
//								""												Count=1
//					0								1							Count=2
//			00 				01				10				11					Count=4
//		000		001		010		011		100		101		110		11				Count=8
//
//	SUM 2^i	= 2^n
void generateBinary(int len, string cur = ""){	// O(2^n)	... O(Branching Factor ^ Depth)

	if(len == 0){

		cout<<cur<<"\n";
		return;
	}

	// At each level, we branch twice...draw this tree
	generateBinary(len-1, cur + "0");

	generateBinary(len-1, cur + "1");
}



// generate all sequences of given length, of zeros, ones and two2
// E.g. for len = 2:	00, 01, 02, 10, 11, 12, 20, 21, 22
void generateTernary(int len, string cur = ""){	// O(3^n)	... O(Branching Factor ^ Depth)

	if(len == 0){

		cout<<cur<<"\n";
		return;
	}

	// At each level, we branch three times...draw this tree
	generateTernary(len-1, cur + "0");

	generateTernary(len-1, cur + "1");

	generateTernary(len-1, cur + "2");
}

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// Let n = high - low + 1, the number of elements to sort
// T(n) = T(n/2) + T(n/2) + n = 2 T(n/2) + n

// Say we need to sort array of 8 elements: 5 1 4 6 7 2 1 8

//									1 2 4 5 6 2 7 8												// Split to 2 * 4 items, do 8 merge steps
//			1 4 5 6												1 2 7 8							// Split to 4 * 2 items, do 8 merge steps
//		1 5						4 6						2 7					1 8					// Split to 8 * 1 items, do 8 merge steps
//	5				1	4					6	7					2 				1	8		// Base Case
//
//																								8/2/2/2 = 1. Height 8/2^k = 1. k = log8
//																								Then we do logn levels, and n operations per level
//																								n log n


void mergesort(int low, int high){

    if(low < high){

        int mid =(low+high)/2;

        mergesort(low, mid);
        
        mergesort(mid+1, high);
        
        // linearly, merge to sorted blocks			O(n)
    }
}


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// Search space analysis

// int f(int a)
//		1 <= a <= n									Search space size : n

// int f(int a, int b)
//		1 <= a, b <= n								Search space size : n^2

// int f(string cur)
//		cur string of chars A, B, C, D
//		curLen <= n									Search space size : 4^n



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




// Fibonacci Series: Fib(n) = fib(n-1) + fib(n-2).	Fib(0) = fib(1) = 1

int fib(int n){

	if(n <= 1)
		return 1;

	return fib(n-2) + fib(n-1);
}

// what is search space? n
// what is number of recursive calls? We are branching every time to 2 levels that differs in 1
//										fib(5)
//							fib(4)											fib(3)
//				fib(3)					fib(2)						fib(2)			fib(1)
//		fib(2)			fib(1)	fib(1)			fib(0)		fib(1)			fib(0)
//	fib(1)	fib(1)
//
// We almost have 2^N calls

// Wait, a space of N, is called 2^N times!
// A fib of 50 do around ~1125899906842624 call!!!!!!
//
// Then, we must call a state more than once? and it too call other states, that already called!
//
// Check tree above, fib(3) called twice. Fib(2) called three times!
//
// Let's SAVE the answer, and let space of N is called 2N times!


int savedAnswers[MAX];		/// Initialized to -1, means no answer
int fibSave(int n){

	if(n <= 1)
		return 1;

	if(savedAnswers[n] != -1)
		return savedAnswers[n];

	return savedAnswers[n] = fib(n-2) + fib(n-1);
}

//													fib(5)=8
//									fib(4)=5							fib(3)=3
//						fib(3)=3					fib(2)=2
//			fib(2)=2				fib(1)=1
//	fib(1)=1		fib(1)=1



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

