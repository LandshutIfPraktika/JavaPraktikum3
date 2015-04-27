package com.sgheldd.javapraktikum;

public class Main {

    /**
     * A recursive function to determine if word is a palindrome.
     *
     * @param word String that might be a palindrome
     * @return true if word is palindrome, false otherwise
     */
    public static boolean isPalindrome(String word){
        if (word.length()==1||word.length()==0){
            return true;
        } else if(word.charAt(0)==word.charAt(word.length()-1)){
            return isPalindrome(word.substring(1, word.length() - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String input = args[0];
        input = input.toLowerCase();

        if (isPalindrome(input)){
            System.out.println(args[0]+" is a palindrome");
        } else {
            System.out.println(args[0]+" is not a palindrome");
        }
    }
}
