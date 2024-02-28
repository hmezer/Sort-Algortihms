package SortAlgorithms;

import SortInterface.AbstractArraySort;

public class InsertionSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  /*
   * Implementation of the Insertion-Sort algorithm
   */

  public InsertionSort()
  {
    name = "Insertionsort";
  }
  
  @Override
  public void sort(K[] inputArray) {
    for (int j = 1; j < inputArray.length; j++) {
      // determine index i, where K[i] > K[j]
      // at that moment, shift each key between [i] and [j-1] to the right
      // placing K[j] into [i] and shifting each following until K[j-1] to one right
      // will create the new ordered subarray
      int i = j - 1;
      boolean everSwap = false;
      while ((i >= 0) && (compare(inputArray[j], inputArray[i]) < 0)) {
        i--;
        everSwap = true;
      }
      if (everSwap) {
        for (int index = j; index > i + 1; index--) {
          swap(inputArray, index, index - 1);
        }
      }
    }
  }
}
