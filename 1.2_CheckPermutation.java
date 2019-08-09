//Given two strings, write a method to decide whether one is a permutation of the other.

//Hints:
//Describe what it means for for two strings to be permutations of each other.
//There is one solution that is O(N log N) time. Another uses some space but it is O(N) time.
//Could a hash table be useful?
//Two strings that are permutations should have the same characters, but in different orders.

import java.util.Arrays;
import java.util.Scanner;

class V1{
    public static void main(String[] args) {
        //This algorithm uses an array to store the frequency of each element and then compares.
        //This algorithm works in O(N) time and O(c) space.

        Scanner sc = new Scanner(System.in);

        String inputString1 = sc.nextLine();
        String inputString2 = sc.nextLine();

        boolean result = IsPermutation(inputString1, inputString2);
        System.out.println(result);

        sc.close();
    }

    static boolean IsPermutation(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        
        int[] frequency = new int[128];

        for(int i=0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            ++frequency[ch];
        }

        for(int i=0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            if( --frequency[ch] < 0)
                return false;
        }
        return true;
    }
}

class V2{
    public static void main(String[] args) {
        //This algorithm uses QuickSort to sort the elements and then compares the strings.
        //This algorithm works in O(N log N) time and O(1) space.

        Scanner sc = new Scanner(System.in);

        String inputString1 = sc.nextLine();
        String inputString2 = sc.nextLine();

        boolean result = IsPermutation(inputString1, inputString2);
        System.out.println(result);

        sc.close();
    }

    static boolean IsPermutation(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return (String.valueOf(charArray1).equals(String.valueOf(charArray2)));
    }
}