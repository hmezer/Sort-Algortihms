package SortAlgorithms;

import SortInterface.AbstractArraySort;

/*
 * Implementation of Counting-Sort algorithm
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  public CountingSort()
  {
    name = "Countingsort";
  }
  
  @Override
  public void sort(K[] inputArray) {
    
    if(inputArray == null)
    {
      System.out.println("Null array");
      return;
    }
    if(inputArray.length < 1)
    {
      System.out.println("Empty array");
      return;
    }   
    
    if(!(inputArray[0] instanceof Integer)) {
      System.out.println("Can only sort integers!");
      return;
    }

    Integer max = (Integer) findMax(inputArray);
    Integer min = (Integer) findMin(inputArray);

    if (min >= 0) {
      int range = max - min;

      int[] indexArray = new int[range + 1];

      for (int i = 0; i < inputArray.length; i++) {
        int index = (Integer) inputArray[i] - min;
        indexArray[index] += 1;
      }

      int sum = -1;
      for (int i = 0; i < indexArray.length; i++) {
        sum += indexArray[i];
        indexArray[i] = sum;
      }

      K[] inputArrayCopy = inputArray.clone();
      for (int i = 0; i < inputArrayCopy.length; i++) {
        inputArray[indexArray[(Integer) inputArrayCopy[i] - min]] = inputArrayCopy[i];
        indexArray[(Integer) inputArrayCopy[i] - min] -= 1;
      }
    }
  }

  private K findMax(K[] inputArray) {
    K max = inputArray[0];
    for (int i = 0; i < inputArray.length; i++) {
      if (compare(inputArray[i], max) > 0) {
        max = inputArray[i];
      }
    }
    return max;
  }

  private K findMin(K[] inputArray) {
    K min = inputArray[0];
    for (int i = 0; i < inputArray.length; i++) {
      if (compare(min, inputArray[i]) > 0) {
        min = inputArray[i];
      }
    }
    return min;
  }
}
