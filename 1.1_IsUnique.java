
// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional Data Structures?

// Hints:
// Try a hash table.
// Could a bit vector be useful?
// Can you solve it in O(N log N) time? What might a solution like that look like?

import java.util.Arrays;
import java.util.Scanner;

class V1{
    public static void main(String[] args) {
        //It works by comparing each character to every other character in the string.
        //This algorithm works in O(N²) time and O(1) space.
        
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        
        boolean result = isUnique(inputString);
        System.out.println(result);
        
        sc.close();
    }

    static boolean isUnique(String s){
        char[] stringArray = s.toCharArray();
        for(int i=0; i<stringArray.length; i++){
            for(int j=i+1; j<stringArray.length; j++){
                if(stringArray[i] == stringArray[j])
                    return false;
            }
        }
        return true;
    }
}

class V2{
    public static void main(String[] args) {
        //This algorithm uses a boolean array to check whether a character has been encountered before.
        //This algorithm works in O(N) time and O(c) space.

        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        
        boolean result = isUnique(inputString);
        System.out.println(result);
        
        sc.close();
    
    }

    static boolean isUnique(String s){
        if(s.length() > 128)
            return false;

        boolean[] flag = new boolean[128];

        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            if(flag[x]){
                return false;
            }
            flag[x] = true;
        }
        return true;
    }
}

class V3{
    public static void main(String[] args) {
        //This algorithm uses an integer as a bit vector to set the kth bit on finding a character.
        //This algorithm works in O(N) time and O(c) space.

        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        
        boolean result = isUnique(inputString);
        System.out.println(result);
        
        sc.close();
    }

    static boolean isUnique(String s){
        if(s.length() > 26)
            return true;
        
        int flag = 0;
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i) - 'a';
            if((flag & (1 << ch)) > 0)
                return false;
            flag = flag | (1 << ch);
        }
        return true;
    }
}

class V4{
    public static void main(String[] args) {
        //This algorithm sorts the string using QuickSort internally and then checking neighbouring elements.
        //This algorithm works in O(N log N) time and O(1) space.

        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        
        boolean result = isUnique(inputString);
        System.out.println(result);
        
        sc.close();
    }

    static boolean isUnique(String s){
        if(s.length() > 128)
            return false;
        
        char[] stringArray = s.toCharArray();
        Arrays.sort(stringArray);

        for (int i=1; i<stringArray.length; i++) {
            if(stringArray[i-1] == stringArray[i])
                return false;
        }
        return true;
    }
}