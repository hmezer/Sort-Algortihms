package SortAlgorithms;

import SortInterface.AbstractArraySort;

/*
 * Implementation the Heap-Sort algorithm
 * 
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  public HeapSort() {
    name = "Heapsort";
  }

  @Override
  public void sort(K[] inputArray) {
    heapify(inputArray);
    // now we have a heap
    int arraySize = inputArray.length;
    for (int i = 0; i < inputArray.length; i++) {
      swap(inputArray, 0, arraySize - 1);
      arraySize -= 1;
      downheap(inputArray, 0, arraySize);
    }
  }

  public void heapify(K[] inputArray) {
    // downheap
    // starting from i = n / 2 down to 0
    // do max-heapify
    for (int i = inputArray.length / 2; i >= 0; i--) {
      downheap(inputArray, i, inputArray.length);
    }

  }

  protected void downheap(K[] inputArray, int i, int arraySize) {
    // for all cases it will be the root node that could violate the heap property
    // compare with its children
    // and push down through the tree
    // until a position where it does not violate the property
    K concern = inputArray[i];

    String nextNode;
    while (true) {
      nextNode = maxHeapify(inputArray, i, arraySize);
      if (nextNode.equals("left")) {
        i = 2*i + 1;
        if (i >= arraySize) {
          break;
        }
      } else if (nextNode.equals("right")) {
        i = 2*i + 2;
        if (i >= arraySize) {
          break;
        }
      } else {
        break;
      }
    }
  }

  private String maxHeapify(K[] inputArray, int i, int arraySize) {
    int left = 2*i + 1;
    int right = 2*i + 2;
    int largest = i;
    String move = "";
    if ((left < arraySize) && (compare(inputArray[left], inputArray[i]) > 0)) {
      largest = left;
      move = "left";
    }
    if ((right < arraySize) && (compare(inputArray[right], inputArray[largest]) > 0)) {
      largest = right;
      move = "right";
    }
    swap(inputArray, i, largest);
    return move;
  }
}
