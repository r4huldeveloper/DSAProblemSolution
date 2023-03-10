/* Given an array of integers, return an array
with even integers removed

Input: arr={3,2,4,7,10,6,5}
Output: arr={3,7,5}
*/


import java.lang.reflect.Array;

public class removeEvenInteger{

    public static void printArray(int[] arr){
        int n = arr.length;
        for (int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int[] removeEven(int[] arr)
    {
        int oddCount=0;
        for (int i=0; i< arr.length; i++)
        {
            if(arr[i] %2 !=0)
            {
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int idx=0;
        for (int i=0; i< arr.length; i++){
            if(arr[i] %2 !=0){
                result[idx] = arr[i];
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={3,2,4,7,10,6,5};
        printArray(arr);
        int[] result = removeEven(arr);
        printArray(result);
    }
}