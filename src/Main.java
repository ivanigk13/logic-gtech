import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //fibonacci: 0,1,1,2,3,5,8,13,21,34
        System.out.println(fibo(10));

        //prime: 2,3,5,7,11,13,17
        System.out.println(prime(8));

        //sort: 100, 53, 523, 98, 4, 7, 8, 20, 32, 90, 9872, 12
        int[] arr = {100, 53, 523, 98, 4, 7, 8, 20, 32, 90, 9872, 12};
        System.out.println(Arrays.stream(sort(arr)).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        //reverse string: Nama saya John Doe -> aman ayas nhoj eod
        System.out.println(reverseString("Nama saya John Doe"));
    }

    static int fibo(int n){
        if(n == 1) return 0;
        if(n == 2)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }

    static int prime(int n){
        int i = 1;
        int counter = 0;
        while(true){
            if(isPrime(i)) counter++;
            if(counter == n) return i;
            i++;
        }
    }

    private static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i = 2; i <= n/2; i++){
            if(n%i == 0) return false;
        }
        return true;
    }

    static int[] sort(int[] arr){
        int size = arr.length;
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(arr[i] > arr[j]){
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            }
        }
        return arr;
    }

    static String reverseString(String input){
        StringBuilder sb = new StringBuilder();
        String[] splitter = input.toLowerCase().split(" ");
        for(String split : splitter){
            String reverseWord = reverseWord(split.toCharArray());
            sb.append(reverseWord).append(" ");
        }
        return sb.toString().trim();
    }

    private static String reverseWord(char[] chars){
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length - 1; i >= 0; i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}