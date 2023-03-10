

class reverseArrayElement {

    public static void printArray(int[] arr){
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void reverseArray(int[] arr,int start, int end){
        while (start<end){
            int temp=arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
       int[] numbers = {2,11,5,10,7,8};
       printArray(numbers);
       reverseArray(numbers,0,numbers.length-1);
       printArray(numbers);
    }
}