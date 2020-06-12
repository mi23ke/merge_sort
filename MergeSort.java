/*Merge sort application
 *Author: Mike Urbano
*/
import java.io.*;
import java.util.Arrays;
public class MergeSort{
  public static void main(String[] args){
    int[] input = new int[]{97, 53, 4, 1, 23, 42, 66, 58, 87, -2, 100, 98};
    System.out.println("Data before merge sort: "+Arrays.toString(input)+"\n");
    merge_sort(input, 0, input.length - 1);
    System.out.println("Data after merge sort: "+Arrays.toString(input)+"\n");
  }
  //Merge Sort algorithm
  public static void merge_sort(int[] input, int start, int end){
    //get value of middle index
    int middle = (end+start)/2;
    //cut problem in half and call merge sort on each half
    if(start < end){
      merge_sort(input, start, middle);
      merge_sort(input, middle + 1, end);
    }
    //This chunk does the actual sorting of each piece of the problem and
    //then sorts the pieces as they are put back together
    int i = 0, first = start, last = middle + 1;
    //temp array to hold values as they are sorted
    int[] temp = new int[end - start + 1];
    //These lines do the sorting when the problem has at least 2 elements
    //to be sorted
    while(first <= middle && last <= end){
      temp[i++] = input[first] < input[last] ? input[first++] : input[last++];
    }
    //This line adds the first element of the problem chunk to the temp
    //array; this happens when the first element is the largest value
    while(first <= middle)temp[i++] = input[first++];
    //This line adds the last element of the problem chunk to the temp
    //array; this happens when the last element is the largest value
    while(last <= end)temp[i++] = input[last++];
    //These last two lines copy the temp array to the input array because
    //the temp array holds the sorted values
    i = 0;
    while(start <= end)input[start++] = temp[i++];

  }
}
