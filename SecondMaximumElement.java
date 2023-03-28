public class SecondMaximumElement {

    public int findSecondMax(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax){
                secondMax = firstMax;
            firstMax = arr[i];
        } else if (arr[i] > secondMax && arr[i] != firstMax) {
            secondMax = arr[i];
        }
    }
      return secondMax;

    }

    public static void main(String[] args) {
        int[] arr = {13,34,2,34,33,1};
        SecondMaximumElement sm = new SecondMaximumElement();
        System.out.println(sm.findSecondMax(arr));
    }
}
