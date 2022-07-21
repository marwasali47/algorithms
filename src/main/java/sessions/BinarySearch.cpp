		// [Binary Search]

		/*

			+ How do you find a page number in a book?

					1-5000, 3000

				- First part, last part, or the target



			+ We have a search space that can guide us if we will continue 
				in the right position or in the left position or we will not continue searching



			+ The classical exapmle of having a sorted array 
				and we search for a value in it we want to get the index of it

				L = 1 3 4 6 8 9 11     X = 11

				   Compare X to 6. It's smaller. Repeat with L = 1 3 4.
				   Compare X to 3. It's bigger. Repeat with L = 4.
				   Compare X to 4. It's equal. We're done, we found X.

				- The idea of binary search is that we choose the middle of the search space
					each time, as the middle is the optimum choise we can do each time, from here the word binary came.

				- Other examples are Number guessing game, and Word list.

		*/



		// [Recursive]
		// A straightforward implementation of binary search is recursive. 
		// The initial call uses the indices of the entire array to be searched. 
		// The procedure then calculates an index midway between the two indices, 
		// 	determines which of the two subarrays to search, and then does a recursive call to search that subarray. 
		// Each of the calls is tail recursive, so a compiler need not make a new stack frame for each call. 
		// The variables imin and imax are the lowest and highest inclusive indices that are searched.

		int binary_search(int A[], int key, int imin, int imax){

		  // test if array is empty
		  if (imax < imin)

		    // set is empty, so return value showing not found
		    return KEY_NOT_FOUND;

		  else{

		      // calculate midpoint to cut set in half
		      int imid = midpoint(imin, imax); //(imin + imax) / 2
		 
		      // three-way comparison

		      if (A[imid] > key)
		        // key is in lower subset
		        return binary_search(A, key, imin, imid-1);

		      else if (A[imid] < key)
		        // key is in upper subset
		        return binary_search(A, key, imid+1, imax);

		      else
		        // key has been found
		        return imid;
		    }
		}



		//  [Iterative]
		//	The binary search algorithm can also be expressed iteratively with two index limits that progressively narrow the search range

			int binary_search(int A[], int key, int imin, int imax){

			  // continue searching while [imin,imax] is not empty
			  while (imin < imax){

			      // calculate the midpoint for roughly equal partition
			      int imid = midpoint(imin, imax); //(imin + imax) / 2
			 
			      // determine which subarray to search
			      if (A[imid] < key)

			        // change min index to search upper subarray
			        imin = imid + 1;

			      else if (A[imid] > key)
			        // change max index to search lower subarray
			        imax = imid - 1;

			      else
			        // key found at index imid
			        return imid;
			    }

			  // key not found
			  return KEY_NOT_FOUND;
			}





		// The order of binary search is O(log N) - Because the search space is decreasing by a division factor







		// Java implements binary search by


		// + Using Arrays.binarySearch()
			
			int index = Arrays.binarySearch(sortedArray, value);

		// A sortedArray and an int value, which is to be searched in the array of integers, are passed as arguments to the binarySearch method of the Java Arrays class.


		// + Using Collections.binarySearch()

			int index = Collections.binarySearch(sortedList, value);

		// A sortedList & an Integer value, which is to be searched in the list of Integer objects, are passed as arguments to the binarySearch method of the Java Collections class.





		/*
		 * Binary Search works only if the search space can guide you. That is from any position you know to which direction to go?
		 * 	In more theorical words: binary search can be used if and only if for all x in S, p(x) implies p(y) for all y > x
		 *
		 * Typically works in increasing or decreasing sequence. Some times works in bitonic sequence (increase then decrease or reverse) (1 7 9 15 6 4 2)
		 */




		/*
		 * 	1- Instead of an index in array, we could have function F(int idx) that calculate some value.
		 *
		 * 		E.g. we have an increasing function F (e.g. Fibonacci 1 1 2 3 5 8 13 ...) what is index of 21?
		 *
		 *
		 * 	2- In many problems, function F is boolean function could(int val).
		 *
		 * 		E.g. If we are given # of sandwiches to eat during trip. Using them you could reach your destination or die from starving as food ended.
		 * 			What is MIN # of sandwiches to finish trip and still alive?
		 *
		 * 		in this case space is like  0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1
		 *
		 * 			That is e.g. given up to 6 sandwiches u die, but more than that you could pass.
		 *
		 * 		Sometimes space is reverse 1 1 1 1 1 0 0 0 0 0 0
		 *
		 * 		Sometimes you are asked for first 1 (or) zero and some times you are asked for the last.
		 *
		 * 		For more understanding for first and last: Imagine array: 1 3 4 5 9 9 9 12 15 ...
		 * 			Find 1st idx of 9? Find last idx of 9?
		 * 			So it is not just about finding, but which position? any? first? last?
		 *
		 * 		Final note: remember (e.g. in 0 0 0 0 0 0 1 1 1 1 1) the last zero followed by the first one. So you could be asked to last, and solve it usign first.
		 */




		// start + (end - start) / 2 = (start + end) / 2

		int BSfindFirst(int start, int end, int val) {

			while(start < end) {

				int mid = start + (end-start) / 2;

				if(f(mid) < val)		start= mid + 1;
				else if(f(mid) > val)	end  = mid - 1;
				else end  = mid;
			}

			return start;
		}

		int BSfindLast(int start, int end, int val) {

			while(start < end) {

				int mid = start + (end-start) / 2;

				if(f(mid) < val)		start= mid + 1;
				else if(f(mid) > val)	end  = mid - 1;
				else start = mid;
			}

			return start;
		}



		// A typical scenario is infinite loop when a start or end = mid. To fix that
		// check to use: mid = start + (end-start)/2;	OR		 mid = start + (end-start+1)/2;
		// check any 2 consecutive numbers: E.g. 1, 2


		// If you forgot this trick, use Halawany technique xD, just work till range be > small number (e.g. 5) and then move the remain steps sequentially.









		// [Binary Search in the double domain] //


		// One of great WAs sources is value of EPS. Make sure you achieve required precision

		double BS_double(double start, double end, double val) {

			while(fabs(end - start) > EPS) {	// iterate 200-600 iteration

				double mid = (start + end) / 2;

				if (F(mid) < val)	start = mid;
				else end  = mid;
			}

			return start;
		}


		// Halawany technique

		double binary_search_double(double start, double end, double target){

		    for (int i = 0 ; i < 600; i ++){ // iterate 200-600 iteration

		        double mid = (start + end) / 2;

		        if (F(mid) < target) start = mid;
		        else end = mid;
		    } 

		    return start;
		}


		// [Problems]

		// https://leetcode.com/problems/search-insert-position/
		// https://leetcode.com/problems/search-a-2d-matrix/
		// https://leetcode.com/problems/guess-number-higher-or-lower/
		// https://leetcode.com/problems/first-bad-version/
		// https://leetcode.com/problems/check-if-n-and-its-double-exist/
		// https://leetcode.com/problems/heaters/
		https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/