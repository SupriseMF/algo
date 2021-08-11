package pac1;

public class 奇数出现次数 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2};

        int n = arr[0];

            for (int i = 1; i < arr.length; i++) {
                n ^= arr[i];
            }



            System.out.print(n);


    }
}
