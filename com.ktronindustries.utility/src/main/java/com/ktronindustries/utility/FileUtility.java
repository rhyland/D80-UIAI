package com.ktronindustries.utility;

import android.support.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility for managing the methods and operations of the Java File object.
 */
public class FileUtility {

    /**
     *
     * @param path - the path of the child for the parent to retrieve.
     * @return - the path of the parent for the child.
     */
    public static File getParent ( String path ) {
        return new File( path ).getParentFile();
    }

    /**
     * Checks for the existence of a file from a complete path.
     * @param filePath - The path for which the files supposedly exists.
     * @return - true if file exists; false otherwise.
     */
    @NonNull
    public static Boolean fileExists (String filePath ) {
        File f = new File( filePath );
        return f.exists() && !f.isDirectory();
    }

    /**
     * @param dirPath - a string representing a path to enumerate within.
     * @return - a list of files in a give path in which to enumerate.
     */
    public static ArrayList<String> enumerateFiles( String dirPath) {
        File dir = new File( dirPath );
        ArrayList<String> childFiles = new ArrayList<>();
        for ( File child : dir.listFiles() ) {
            childFiles.add( child.getName() );
        }
        return childFiles;
    }

    /**
     * Combines two paths into one.
     * @param path1 - First path to combine.
     * @param path2 - 2nd path to combine to first one.
     * @return - combined paths of #1 & #2.
     * http://stackoverflow.com/questions/412380/combine-paths-in-java
     */
    public static String Combine ( String path1, String path2 ) {
        File file1 = new File( path1 );
        File file2 = new File( file1, path2 );
        return file2.getPath();
    }

    /**
     * Gets the directory in which a file is found.
     * @param fileName - the
     * @return - The directory in which a given file is found.
     */
    public static String getDirectoryName ( String fileName ) {
        return new File( fileName).getParentFile().getPath();
    }


    /**
     * Checks for the existence of a directory from a given path.
     * @param dirPath - the path for which the directory supposedly exists.
     * @return  - true if the directory exists for the path; false otherwise.
     */
    public static Boolean directoryExists ( String dirPath ) {
        if ( new File( dirPath ).exists()  && new File( dirPath ).isDirectory() ) {
            return true;
        }
        return false;
    }

    /**
     * @param dir - the directory in which the new file will be created.  In the case of Android files, typically the
     *              Context object will be used to determine this parameter.
     * @param fileName - the name of the file to create.
     * @return - true if the file was created successfuly; false otherwise.
     */
    public static Boolean createFile ( File dir , String fileName ) {
        if ( dir.exists() ) {
            File file =  new File( dir , fileName );
        }
        if ( dir.getAbsoluteFile().exists()  ){
            return true;
        }
        return false;
    }

}
