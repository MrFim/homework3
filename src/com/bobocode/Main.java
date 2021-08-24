package com.bobocode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,3,2,1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] sourceArray) {
        int sourceLength = sourceArray.length;
        if (sourceLength < 2) {
            return;
        }
        int middle = sourceLength / 2;
        int[] leftArray = new int[middle];
        System.arraycopy(sourceArray, 0, leftArray, 0, middle);
        int[] rightArray = new int[sourceLength - middle];
        System.arraycopy(sourceArray, middle, rightArray, 0, sourceLength - middle);
        mergeSort(leftArray);
        mergeSort(rightArray);

        mergeArrays(sourceArray, leftArray, rightArray);
    }

    private static void mergeArrays(int[] sourceArray, int[] leftArray, int[] rightArray) {
        int sourceIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftArray.length || rightIndex < rightArray.length) {
            if (leftIndex == leftArray.length) {
                sourceArray[sourceIndex++] = rightArray[rightIndex++];
            } else if (rightIndex == rightArray.length) {
                sourceArray[sourceIndex++] = leftArray[leftIndex++];
            } else if (leftArray[leftIndex] < rightArray[rightIndex]) {
                sourceArray[sourceIndex++] = leftArray[leftIndex++];
            } else {
                sourceArray[sourceIndex++] = rightArray[rightIndex++];
            }
        }
    }
}
