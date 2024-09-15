/*
 * HEADER:
 * Author: Leonardo Alves Nunes
 * Course: CSC207-01 Fall 2024
 * Acknowledgements: 
 * - https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/mps/mp01.html
 * - https://google.github.io/styleguide/javaguide.html
 */

package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  /**
   * Respective to number of parameters.
   */
  private static final int NUMBER_OF_PARAMETERS = 4;

  /**
   * Prints encryptions or decryptions of caeser cipher or vigenere cipher.
   * @param args
   * List of arguments to the main function: action, cipher type, word and key.
   */
  public static void main(final String[] args) {
    String option = new String("");
    String cipherType = new String("");
    String word = new String("");
    String key = new String("");

    if (args.length != NUMBER_OF_PARAMETERS) {
      System.err.println("Error: Incorrect number of parameters");
    } else {
      for (String arg : args) {
        if ("-encode".equals(arg)) {
          option = new String("-encode");
        } // if
        if ("-decode".equals(arg)) {
          option = new String("-decode");
        } // if
      } // for

      if ("".equals(option)) {
        System.err.println("Error: Choose either '-encode' or '-decode'.");
      } else {
        for (String arg : args) {
          if ("-caesar".equals(arg)) {
            cipherType = new String("-caesar");
          } // if
          if ("-vigenere".equals(arg)) {
            cipherType = new String("-vigenere");
          } // if
        } // for

        if ("".equals(cipherType)) {
          System.err.println("Error: Choose either '-caesar' or '-vigenere'.");
        } else {
          for (String arg : args) {
            if (!option.equals(arg) && !cipherType.equals(arg)) {
              word = new String(arg);
              break;
            } // if
          } // for
          boolean sawWord = false;
          for (String arg : args) {

            if (!cipherType.equals(arg) && !option.equals(arg) && sawWord) {
              key = new String(arg);
              break;
            }
            if (word.equals(arg)) {
              sawWord = true;
            } // if
          } // for
        } // if
      } // if

      if ("-encode".equals(option) && "-caesar".equals(cipherType)) {
        if (key.length() != 1) {
          System.err.println("Error: key must be a single character");
        } else {
          if ("ERROR".equals(CipherUtils.caesarEncrypt(word, key.charAt(0)))) {
            System.err.println("Error: strings must be lowercase letters");
          } else {
            System.out.println(CipherUtils.caesarEncrypt(word, key.charAt(0)));
          } // if
        } // if

      } else {
        if ("-encode".equals(option) && "-vigenere".equals(cipherType)) {
          if (key.length() == 0) {
            System.err.println("Error: Empty keys are not permitted");
          } else {
            if ("ERROR".equals(CipherUtils.vigenereEncrypt(word, key))) {
              System.err.println("Error: strings must be lowercase letters");
            } else {
              System.out.println(CipherUtils.vigenereEncrypt(word, key));
            } // if
          } // if
        } else {
          if ("-decode".equals(option) && "-caesar".equals(cipherType)) {
            if (key.length() != 1) {
              System.err.println("Error: key must be a single character");
            } else {
              if ("ERROR".equals(
                CipherUtils.caesarDecrypt(word, key.charAt(0)))) {
                System.err.println("Error: strings must be lowercase letters");
              } else {
                System.out.println(
                  CipherUtils.caesarDecrypt(word, key.charAt(0)));
              } // if
            } // if

          } else {
            if ("-decode".equals(option) && "-vigenere".equals(cipherType)) {
              if (key.length() == 0) {
                System.err.println("Error: Empty keys are not permitted");
              } else {
                if ("ERROR".equals(CipherUtils.vigenereDecrypt(word, key))) {
                  System.err.println(
                    "Error: strings must be lowercase letters");
                } else {
                  System.out.println(CipherUtils.vigenereDecrypt(word, key));
                } // if
              } // if
            } // if
          } // if
        } // if
      } // if
    } // if
  } // main
} // Cipher
