package Sorting;

import java.util.Arrays;

/*IN Insertion sort we always starts with second item in the list
* Then we compare it with item before it , if it is less than the item before
* Then we will drop it to the correct spot*/
public class InsertionSort {
    public static void insertionSort(int [] array){
        for(int i = 1 ; i < array.length ; i++){
            int temp = array[i];//second item
            int j = i-1; //first item
            //comparing it with before and putting it on correct spot
            while(j>-1 && temp < array[j]){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {4,2,6,5,1,3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
