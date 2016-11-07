package com.ktronindustries.data;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.UUID;

/*
   *
    *************************************************************************************************************
    *  A Nuid is like a guid... but shorter and not quite as unique.                                            *                                                   *
    *************************************************************************************************************
   *
*/
public class Nuid {

    // region -== fields ==-

    private String m_value;  // The value of the object in a get/set situation.

    // endregion // fields

    // region -== constructors ==-

    public Nuid( String value ){
        setValue( value );
    }

    // endregion // constructors

    // region -== *public properties* ==-

    /*
       *
        *************************************************************************************
        * Get the value of a Nuidy-object.                                                  *
        *************************************************************************************
       *
    */
    public String getValue(){
        return  m_value;
    }
    /*
       *
        *************************************************************************************
        * Set the value of a Nuidy-object.                                                  *
        *************************************************************************************
       *
    */
    public void setValue( String value ){
        m_value = value;
    }

    //endregion // *public properties*

    /*
       *
        *************************************************************************************
        * Generate a new Nuid.                                                              *
        *************************************************************************************
       *
    */
    public static Nuid newNuid() throws  Exception {
        UUID newId = UUID.randomUUID();
        Object val = newId.hashCode();
        return new Nuid( base64Encode( val.toString() ) );
    }

    // endregion // public methods

    // region -== private methods ==-

    public static String base64Encode( String data )  {
        byte[] encData_byte = new byte[data.length()];
        encData_byte =  data.getBytes( Charset.forName("UTF8") );
        return Base64.encodeToString( encData_byte, Base64.DEFAULT );
    }

    // endregion // private methods

    // region -== overrides ==-
    @Override
    public String toString(){
        return getValue();
    }

    // endregion // overrides

}