
public class Word {
    private String mSubname ;
    private String mCodename;

    public Word (String tSubname , String tCodename ){
        mSubname = tSubname;
        mCodename =tCodename;

    }

    public String getTSubname(){
        return mSubname;

    }
    public String getTCodename(){
        return mCodename;
    }
}
