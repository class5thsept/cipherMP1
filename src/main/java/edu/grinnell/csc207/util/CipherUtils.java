/*
 * HEADER:
 * Author: Leonardo Alves Nunes
 * Course: CSC207-01 Fall 2024
 * Acknowledgements: 
 * - https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/mps/mp01.html
 * - https://google.github.io/styleguide/javaguide.html
 */

package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(final char letter) {
    int base = (int) 'a';
    return (int) (letter) - base;
  } // letter2int

  private static char int2letter(final int i) {
    int base = (int) 'a';
    return (char) (i + base);
  } // int2letter

  /**
   * Encrypts a string through caesar cipher given a character as key.
   * @param str
   * Word to be encrypted.
   * @param letter
   * Key used to sum over the word.
   * @return either an error or the encrypted message.
   */
  public static String caesarEncrypt(final String str, final char letter) {
    char[] strArray = str.toCharArray();
    int wrap = letter2int('z') + 1;

    for (int i = 0; i < str.length(); i++) {
      int intLetter = letter2int(strArray[i]);
      if (letter2int(strArray[i]) < 0 || (letter2int(strArray[i]) > wrap)) {
        if (letter2int(letter) < 0 || letter2int(letter) > wrap) {
          return "ERROR";
        } // if
      } // if
      strArray[i] = int2letter((intLetter + letter2int(letter)) % wrap);
    } // for
    return new String(strArray);
  } // caesarEncrypt
  /**
   * Decrypts a string through caesar cipher given a character as key.
   * @param str
   * Word to be decrypted.
   * @param letter
   * Key used to sum over the word.
   * @return either an error or the decrypted message.
   */
  public static String caesarDecrypt(final String str, final char letter) {
    char[] strArray = str.toCharArray();
    int wrap = letter2int('z') + 1;

    for (int i = 0; i < str.length(); i++) {
      int intLetter = letter2int(strArray[i]);
      if (intLetter < 0 || (intLetter > wrap || letter2int(letter) < 0 || letter2int(letter) > wrap)) {
        return "ERROR";
      } // if
      int difference = intLetter - letter2int(letter);
      if (difference < 0) {
        strArray[i] = int2letter(wrap + difference);
      } else {
        strArray[i] = int2letter((intLetter - letter2int(letter)));
      } // if
    } // for
    return new String(strArray);
  } // caesarDecrypt

  /**
   * Decrypts a string through vigenere cipher given a word as key.
   * @param str
   * Word to be encrypted.
   * @param key
   * Key used to sum over the word.
   * @return either an error or the encrypted message.
   */
  public static String vigenereEncrypt(final String str, final String key) {
    char[] keyArray = key.toCharArray();
    char[] strArray = str.toCharArray();
    char[] fittedKeyArray = new char[strArray.length];
    int wrap = letter2int('z') + 1;

    int keyCounter = 0;
    for (int i = 0; i < strArray.length; i++) {
      if (letter2int(strArray[i]) < 0 || (letter2int(strArray[i]) > wrap || letter2int(keyArray[keyCounter]) < 0 || letter2int(keyArray[keyCounter]) > wrap)) {
        return "ERROR";
      } // if
      fittedKeyArray[i] = keyArray[keyCounter];
      keyCounter++;
      if (keyCounter == keyArray.length) {
        keyCounter = 0;
      } // if
    } // for

    for (int j = 0; j < strArray.length; j++) {
      int intLetter = letter2int(strArray[j]);
      int intLetterFitted = letter2int(fittedKeyArray[j]);

      strArray[j] = int2letter((intLetter + intLetterFitted) % wrap);
    } // for
    return new String(strArray);
  } // vigenereEncrypt

  /**
   * Decrypts a string through vigenere cipher given a word as key.
   * @param str
   * Word to be encrypted.
   * @param key
   * Key used to sum over the word.
   * @return either an error or the decrypted message.
   */
  public static String vigenereDecrypt(final String str, final String key) {
    char[] keyArray = key.toCharArray();
    char[] strArray = str.toCharArray();
    char[] fittedKeyArray = new char[strArray.length];
    int wrap = letter2int('z') + 1;

    int keyCounter = 0;
    for (int i = 0; i < strArray.length; i++) {
      char currentKey = keyArray[keyCounter];
      if (letter2int(strArray[i]) < 0 || letter2int(strArray[i]) > wrap) {
        if (letter2int(currentKey) < 0 || letter2int(currentKey) > wrap) {
          return "ERROR";
        } // if
      } // if
      fittedKeyArray[i] = keyArray[keyCounter];
      keyCounter++;
      if (keyCounter == keyArray.length) {
        keyCounter = 0;
      } // if
    } // for

    for (int j = 0; j < strArray.length; j++) {
      int intLetter = letter2int(strArray[j]);
      int intLetterFitted = letter2int(fittedKeyArray[j]);
      int difference = intLetter - intLetterFitted;

      if (difference < 0) {
        strArray[j] = int2letter(wrap + difference);
      } else {
        strArray[j] = int2letter(intLetter - intLetterFitted);
      } // if
    } // for
    return new String(strArray);
  } // vigenereDecrypt
} // CipherUtils


