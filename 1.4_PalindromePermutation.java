//Given a string, write a function to check if it is a permutation of a palindrome.

//Hints:
//Do not generate all the permutations. It would be inefficient.
//What characteristics would a permutation of a palindromic string have?
//HashTable would reduce this to O(N) time.
//Can a bit vector help?

import java.util.Scanner;

class V1{
    public static void main(String[] args) {
        //This algorithm counts the even number of characters in the string to check for palindromic form.
        //This algorithm works in O(N) time and O(c) space.

        Scanner sc = new Scanner(System.in);

        String inputString = sc.nextLine();
        boolean result = IsPermutation(inputString);
        System.out.println(result);

        sc.close();
    }

    static boolean IsPermutation(String str){
        int evenChars = 0, oddChars = 0;
        int[] letters = new int[128];

        for(int i=0; i<str.length(); i++){
            int ch = str.charAt(i);
            letters[ch]++;
        }

        for(int i=0; i<letters.length; i++){
            if(letters[i] % 2 == 0 && letters[i] != 0)
                evenChars++;
        }
        oddChars = str.length() - evenChars * 2;

        if(evenChars > 0 && oddChars <=1)
            return true;
        return false;
    }
}

class V2{
    public static void main(String[] args) {
        //This algorithm creates a bit vector and toggles the bit on encountering a character.
        //This algorithm works in O(N) time and O(c) space.

        Scanner sc = new Scanner(System.in);

        String inputString = sc.nextLine();
        boolean result = IsPermutation(inputString);
        System.out.println(result);

        sc.close();
    }

    static boolean IsPermutation(String str){
        //create a bit vector
        //iterate through the string
        //and set the kth bit in the bit vector
        //check if the bit has only one set bit
        //return false if it doesn't

        int vector = 0;

        for(char ch:str.toCharArray()){
            vector = setBit(ch, vector);
        }

        return totalSetBits(vector);
    }

    static int setBit(char ch, int bitVector){
        if(Character.getNumericValue(ch) == -1)
          return bitVector;
        int bitMask = 1 << (Character.getNumericValue(ch) - Character.getNumericValue('a'));
        if((bitVector & bitMask) == 0){
          bitVector |= bitMask;
        }
        else{
          bitVector &= ~bitMask;
        }

        return bitVector;
    }

    static boolean totalSetBits(int bitVector){
        return ((bitVector & (bitVector - 1)) == 0);
    }
}
