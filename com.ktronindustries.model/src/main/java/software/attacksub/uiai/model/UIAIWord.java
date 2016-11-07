package software.attacksub.uiai.model;

import com.ktronindustries.data.*;

public class UIAIWord {
    //region -== fields ==-

    private String m_Word;
    private Nuid m_Id;

    //endregion // fields

    //region -== constructor ==-

    public UIAIWord ( String word ) {
        m_Word = word;
    }

    //endregion // constructor

    //region -== properties ==-

    public String getWord () {
        return m_Word;
    }

    public String setWord ( String word ) {
        m_Word = word;
        return m_Word;
    }

    public Nuid getId () {
        return m_Id;
    }

    public Nuid setId ( Nuid id ) {
        m_Id = id;
        return m_Id;
    }

//endregion // properties
}