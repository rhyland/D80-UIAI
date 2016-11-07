package com.ktronindustries.data;

import com.ktronindustries.utility.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by Rob on 2/19/2016.
 */
public class NuidyFileJarA implements IJarA<Nuid> {

    //region -== fields ==-

    private static String m_objectPath;

    //endregion // fields

    //region -== constructor ==-

    // This constructor has the calling assembly passed into it so that the locations of the files can be ascertained.
    public NuidyFileJarA ( String objectPath ) {
        m_objectPath = objectPath;
    }

    //endregion

    //region -== IJarA overrides ==-

    /**
     * Given an instance of some type, save it somewhere.
     *
     * @param t1 - The object to save.
     * @param id - The ID of the object to save.
     */
    @Override
    public <T1> void Save ( T1 t1, Nuid id ) throws Exception {
        String xmlFilename = FileUtility.Combine( getObjectPath(), id.toString() );
        ensurePathExists( FileUtility.getDirectoryName( xmlFilename ) );
        Serializer xsZer = new Persister();
        try( FileWriter w = new FileWriter( xmlFilename ) ) {
            xsZer.write( t1  , w );
        }
    }

    /**
     * Given a type and a key value, return the requested item.
     *
     * @param id - The ID of the object to load.
     * @return - Returns the object with specified ID.
     */
    @Override
    public <T1> T1 Load (  Nuid id ) throws Exception {
        String xmlFilename = FileUtility.Combine( getObjectPath(), id.toString() );
        ensurePathExists( FileUtility.getDirectoryName( xmlFilename ) );
        Class<T1> cls = null;
        return Load( xmlFilename , cls  );
    }

    /**
     * Given a type, return all known instances of it.  (Same as 'Select * from' some table baseed on type T1).
     *
     * @return - All objects of a given type.
     */
    @Override
    public <T1> Iterable<T1> loadAll() throws Exception{
        String xmlFilepath = getObjectPath();
        ensurePathExists( FileUtility.getDirectoryName( xmlFilepath ) );
        ArrayList<T1> all = new ArrayList<T1>();
        for ( String xmlFilename : FileUtility.enumerateFiles( xmlFilepath ) ) {
            Class<? extends T1> type = null;
            all.add( Load( xmlFilename, type ) );
        }


        return null;
    }

    /**
     * Given a type and a key, delete it.  (Delete from some table where key = id).
     *
     * @param id
     */
    @Override
    public void Delete( Nuid id ) throws Exception {
        String xmlFilename = FileUtility.Combine( getObjectPath(), id.toString() );
        ensurePathExists( FileUtility.getDirectoryName( xmlFilename ) );
        new File( xmlFilename ).delete();
    }

    /**
     * Given a type T1, return a new key.
     * <p/>
     * For example, if you're using sequential keys, you would have to return the next number in the series. If you're using GUIDs return a new GUID.
     *
     * @return
     */
    @Override
    public Nuid getNewId () throws Exception {
        return Nuid.newNuid();
    }

    //endregion // IJarA overrides

    //region -== AutoCloseable override ==-

    /**
     * Closes the object and release any system resources it holds.
     */
    @Override
    public void close () throws Exception {

    }

    //endregion // AutoCloseable override

    //region -== static methods ==-

    /**
     *
     * @param xmlFilename
     * @param type
     * @param <T1>
     * @return
     * @throws Exception
     * http://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createObjects
     */
    public static <T1> T1 Load (  String xmlFilename , Class<? extends T1> type ) throws Exception{
        if ( ! FileUtility.fileExists( xmlFilename ) ) {
            throw new FileNotFoundException( "File canot be loaded for serialization" );
        }
        Serializer xsZer = new Persister( );
        File source = new File(xmlFilename);
        return ( T1 ) xsZer.read( type , source );
    }

    //endregion // static methods

    //region -== private methods ==-

    private static String getObjectPath () {
        return m_objectPath;
    }

    private static void ensurePathExists( String path ) throws Exception{
        if ( StringUtility.isNullOrWhitespace( path ) ) {
            throw new Exception( "Specified path was empty" );
        }
        // If the directory doesn't exist then create on
        if ( ! FileUtility.directoryExists( path ) )  {
            ensurePathExists( FileUtility.getParent( path ).getName() );
        }
    }

    //endregion // private methods
}
