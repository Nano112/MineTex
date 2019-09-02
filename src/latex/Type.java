public class Type{

    int DefautlSizeClass;

    public static final Type CHIFFRE = new Type(1);
    public static final Type LETTRE_MIN = new Type(2);
    public static final Type LETTRE_MAJ = new Type(2);
    public static final Type LETTRE_GRECQUE_MIN = new Type(2);
    public static final Type LETTRE_GRECQUE_MAJ = new Type(2);
    public static final Type SYMBOL = new Type(3);
    public static final Type OPERAND = new Type(1);



    public Type(int default_size_class)
    {
        this.DefautlSizeClass = default_size_class;
    }
}