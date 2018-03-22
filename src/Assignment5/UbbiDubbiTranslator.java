/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.util.Scanner;

/**
 *
 * @author chur7632
 */
public class UbbiDubbiTranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // use a Scanner to read info
        Scanner input = new Scanner (System.in);
        
        // translator code
        while (true) {
            
        // tell user to enter word
        System.out.println("Please enter your word:");
        
        // store word
        String origWord = input.nextLine();
        
        // sanitize the input
            origWord = origWord.toLowerCase();
            
            // walk down the word looking for the vowel
          int length = origWord.length();
          
          // make translated word equal to the original word
          String transWord = " " + origWord;
          
          // use a for loop to go through the characters
          for(int position = 0; position < transWord.length(); position ++) {
          
          // look at the character at position i , is a vowel?
          if (transWord.charAt(position) == 'a' ||
                  transWord.charAt(position) == 'e' ||
                  transWord.charAt(position) == 'i' ||
                  transWord.charAt(position) == 'o' ||
                  transWord.charAt(position) == 'u'){
          
          // look at the character at position i , is a vowel?
          if (!(transWord.charAt(position - 1) == 'a' ||
                  transWord.charAt(position - 1) == 'e' ||
                  transWord.charAt(position - 1) == 'i' ||
                  transWord.charAt(position - 1) == 'o' ||
                  transWord.charAt(position - 1) == 'u')){
          
          // break the word apart at the vowel
          String start = transWord.substring(0, position);
          String end = transWord.substring(position);
          
          // compute translated word
          transWord = start + "ub" + end;
          
          position = position + 2;
          
          }
          
    }
}
          System.out.println(origWord + " in Ubbi Dubbi is " + transWord);
}
}
}