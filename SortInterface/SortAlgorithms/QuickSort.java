package SortAlgorithms;

import SortInterface.AbstractArraySort;

/*
 * Implementation of Quick-Sort algorithm
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {
  
  public QuickSort()
  {
    name = "Quicksort";
  }
  
  //useful if we want to return a pair of indices from the partition function.
  public class indexPair {
    public int p1, p2;
    
    indexPair(int pos1, int pos2)
    {
      p1 = pos1;
      p2 = pos2;
    }
    
    public String toString()
    {
      return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
    }
  }
  
  
  @Override
  public void sort(K[] inputArray)
  {
    // when we do partition, it will return the correct position of pivot
    // with regard to the lo and hi, we will run the algorithm
    // for the subarray of indices (lo : p-1) and (p+1 : hi)
    // for any of the two subarrays, if the values are equal
    // we no longer continue
    int lo = 0;
    int hi = inputArray.length - 1;
    int p = pickPivot(inputArray, lo, hi);

    partitionRecursively(inputArray, lo, hi, p);
  }

  /*
  public indexPair partition(K[] inputArray, int lo, int hi, int p)
  {
    return null;
  }
   */
  
  // Alternative, if you are just returning an integer
  public int partition(K[] inputArray, int lo, int hi, int p)
  {
    // hi and p are the same, regarding my implementation
    swap(inputArray, hi, p);
    p = hi;

    int i = lo - 1;
    for (int j = lo; j < p; j++) {
      if (compare(inputArray[j], inputArray[p]) <= 0) {
        i += 1;
        swap(inputArray, i, j);
      }
    }
    // this value is the correct position for the pivot
    swap(inputArray, p, i + 1);
    return i + 1;
  }

  protected int pickPivot(K[] inputArray, int lo, int hi)
  {
    return hi;
  }

  private void partitionRecursively(K[] inputArray, int lo, int hi, int p) {
    int div = partition(inputArray, lo, hi, p);
    if (lo <= div - 1) {
      partitionRecursively(inputArray, lo, div - 1, div - 1);
    }
    if (div + 1 <= hi) {
      partitionRecursively(inputArray, div + 1, hi, hi);
    }
  }
}
