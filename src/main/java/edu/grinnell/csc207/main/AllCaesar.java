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

public class AllCaesar {
  /**
   * Respective to letter z after formatting or the upper bound of the alphabet.
   */
  private static final int ALPHABET_LENGTH = 26;

  /**
   * Respective to letter a or the lower bound of the alphabet.
   */
  private static final int ASCII_A = 97;

  /**
   * Prints all possible encryptions or decryptions of caeser cipher.
   * @param args
   * List of arguments to the main function: action, word and key.
   */
  public static void main(final String[] args) {
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters");
    } else {
      if ("encode".equals(args[0])) {
        for (int index = 0; index < ALPHABET_LENGTH; index++) {
          System.out.println("n = " + (char) (index + ASCII_A) + ": "
              + CipherUtils.caesarEncrypt(args[1], (char) (index + ASCII_A)));
        } // for
      } else {
        if ("decode".equals(args[0])) {
          for (int index = 0; index < ALPHABET_LENGTH; index++) {
            System.out.println("n = " + (char) (index + ASCII_A) + ": "
                + CipherUtils.caesarDecrypt(args[1], (char) (index + ASCII_A)));
          } // for
        } else {
          System.err.println("Error: Invalid option:" + args[0] + ". Choose either 'encode' or 'decode'.");
        } // if
      } // if
    } // if
  } // main
} // AllCaesar
