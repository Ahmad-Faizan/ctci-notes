//Write a method to replace all the spaces in a string with "%20".
//You may assume that the string has sufficient space at the end to hold the additional characters,
//and that you are given the true length of the string.

//Hints:
//It is often easier to modify strings by going from end of the string to the beginning.
//You might find you need to count the number of spaces.

import java.util.Scanner;

class V1{
    public static void main(String[] args) {
        //This algorithm appends characters until a space occurs, thereby replacing it.
        //This algorithm works in O(N) time and O(N) space.

        Scanner sc = new Scanner(System.in);

        String inputString = sc.nextLine().trim();
        int length = sc.nextInt();

        String result = URLify(inputString, length);
        System.out.println(result);

        sc.close();
    }

    static String URLify(String s, int trueLength){
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' ')
                buffer.append("%20");
            else
                buffer.append(s.charAt(i));
        }
        
        return buffer.toString();
    }    
}

class V2{
    public static void main(String[] args) {
        //This algorithm counts the index of the last space and then  it.
        //This algorithm works in O(N) time and O(1) space.

        Scanner sc = new Scanner(System.in);

        String inputString = sc.nextLine();
        int length = sc.nextInt();

        String result = URLify(inputString.toCharArray(), length);
        System.out.println(result);

        sc.close();
    }

    static String URLify(char[] str, int trueLength) {
        int space = 0, index;
        
        //Count the number of spaces in the string
        for(int i=0; i<trueLength; i++){
            if(str[i] == ' ')
                space++;
        }

        //The last non space character in the string
        index = trueLength + space * 2;
        
        for(int i=trueLength-1; i>=0; i--){
            if(str[i] == ' '){
                str[index - 3] = '%';
                str[index - 2] = '2';
                str[index - 1] = '0';
                index -= 3;
            }
            else{
                str[index - 1] = str[i];
                index--;
            }
        }
        return String.valueOf(str);
    }    
}