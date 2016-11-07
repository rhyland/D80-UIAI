package com.ktronindustries.utility;

import java.io.File;

/*
   *
    *************************************************************************************************************
    * Java string utilities                                                                                     *
    *************************************************************************************************************
   *
*/
public class StringUtility {

    /**
     * Detects the presence of nulls or whitespace in a string.
     * @param s string variable to check for nulls and whitespace.
     * @return true if string is null or whitespace; false otherwise.
     */
    public static boolean isNullOrWhitespace( String s ) {
        // String is null.
        if ( s == null ) {
            return true;
        }
        //  Check each character in string for whitespace.
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( ! Character.isWhitespace( s.charAt( i ) ) ) {
                return false;
            }
        }
        return true;
    }


}