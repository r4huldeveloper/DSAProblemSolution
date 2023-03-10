public class MissingElementArray {

    public static int findMissingNumber(int[] arr){
        int n = arr.length+1;
        int sum = n * (n+1) / 2;
        for (int i : arr ){
            sum -= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr={1,3,6,8,2,4,7};
        System.out.println(findMissingNumber(arr));
    }
}
