package SortAlgorithms;

import SortInterface.AbstractArraySort;

import java.util.Arrays;

/*
 * Implementation of the Merge-Sort algorithm
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {


  public MergeSort() {
    name = "Mergesort";
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the merge-sort algorithm
    recursiveMerge(inputArray, 0, inputArray.length - 1);
  }

  public void merge(K[] inputArray, int lo, int mid, int hi) {
    K[] subArray = Arrays.copyOfRange(inputArray, lo, hi + 1);
    int traverse = lo;
    // change now lo, hi and mid for the subArray compliments
    mid = mid - lo;
    hi = hi - lo;
    lo = 0;
    int leftTrack = lo; // which is zero
    int rightTrack = mid + 1;

    while (leftTrack <= mid || rightTrack <= hi) {
      if (leftTrack > mid ) { // we are still in the loop since there are values in the right side
        inputArray[traverse] = subArray[rightTrack];
        rightTrack += 1;
        traverse += 1;
      } else if (rightTrack > hi) { // we are still in the loop since there are values in the left side
        inputArray[traverse] = subArray[leftTrack];
        leftTrack += 1;
        traverse += 1;
      } else {
        if (compare(subArray[leftTrack], subArray[rightTrack]) <= 0) {
          inputArray[traverse] = subArray[leftTrack];
          leftTrack += 1;
          traverse += 1;
        } else {
          inputArray[traverse] = subArray[rightTrack];
          rightTrack += 1;
          traverse += 1;

        }
      }
    }
  }

  private void recursiveMerge(K[] inputArray, int lo, int hi) {
    if ((hi - lo != 0) && ((hi - lo) != 1)) {
      recursiveMerge(inputArray, lo, (hi - lo) / 2 + lo);
      recursiveMerge(inputArray, ((hi - lo) / 2) + lo + 1, hi);
    }
    if (hi - lo != 0) {
      merge(inputArray, lo, (hi - lo) / 2 + lo, hi);
    }
  }
}
