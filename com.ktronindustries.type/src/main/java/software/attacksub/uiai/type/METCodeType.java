package software.attacksub.uiai.type;

/**
 * Created by Rob on 2/25/2016.
 */
/**
 * METCode types represent the raw input sent from the UIAI.
 */
public enum METCodeType {
    A ( 0b10001 ) ,
    B ( 0b10010 ) ,
    C ( 0b10011 ) ,
    D ( 0b10100 ) ,
    E ( 0b10101 );

    private int m_x;

    private  METCodeType( int x){
        m_x = x;
    }
}