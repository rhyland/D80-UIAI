package com.ktronindustries.data;

import java.io.Closeable;
import java.util.Iterator;


/**
 * Created by Rob on 2/19/2016.
 */
/*
   *
    *************************************************************************************************************
    * This is a "micro-NoSQL" framework based off of the original C# version of this framework on CodePlex.com  *
    * The proper pronunciation of this framework is "Jar-A."                                                    *
    *************************************************************************************************************
   *
*/
public interface IJarA<K> extends AutoCloseable {
    /**
     * Given an instance of some type, save it somewhere.
     * @param t1 - The object to save.
     * @param id - The ID of the object to save.
     */
    <T1> void Save( T1 t1 , K id ) throws Exception;

    /**
     * Given a type and a key value, return the requested item.
     * @param id - The ID of the object to load.
     * @return - Returns the object with specified ID.
     */
    <T1> T1 Load( K id ) throws Exception;

    /**
     * Given a type, return all known instances of it.  (Same as 'Select * from' some table baseed on type T1).
     * @return - All objects of a given type.
     */
    <T1> Iterable<T1> loadAll() throws Exception;

    /**
     * Given a type and a key, delete it.  (Delete from some table where key = id).
     * @param id
     */
    void Delete( K id ) throws Exception;

    /**
     * Given a type T1, return a new key.
     *
     * For example, if you're using sequential keys, you would have to return the next number in the series. If you're using GUIDs return a new GUID.
     * @return
     */
    K getNewId() throws Exception;

}