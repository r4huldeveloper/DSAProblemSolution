public class ResizeArray {


     public int[] resize(int[] arr, int capacity){
        int[] temp = new int[capacity];
        for (int i =0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        return temp;
     }

    public static void main(String[] args) {
        ResizeArray resizeArray = new ResizeArray();
        //resizeArray.printArray(new int[] {5,1,2,8,10});
        int[] original = new int[] {5,1,2,8,10};
        System.out.println("The size of original array - "+ original.length);
        original =resizeArray.resize(original,10);
        System.out.println("TThe size of original array after resize -"+ original.length);
    }
}
