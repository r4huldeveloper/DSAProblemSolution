public class MoveZeroEnd {

    public void moveZeros(int[] arr , int n) {
    int j = 0; //  j will focus on 0th element
        for (int i = 0; i<n; i++) {  // i will focus on non-zero element
           if (arr[i] !=0 && arr[j] == 0 ){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
           if (arr[j] != 0){
               j++;
           }
        }
    }

    public void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void array() {
    int[] arr = {8,1,0,2,1,0,3};
    printArray(arr);
    moveZeros(arr,arr.length);
    printArray(arr);
    }

    public static void main(String[] args) {
    MoveZeroEnd moveZeroEnd = new MoveZeroEnd();
    moveZeroEnd.array();
    }
}
