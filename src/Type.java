
public class Type{

    int DefautlSizeClass;
    //J'ai mis des valeurs à la con pour l'instant.
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


    public BoundingBox getBB(Type t)
    {
        //TODO: e tailles seront à changer, ici elles sont à titre d'exemple
        switch (t.DefautlSizeClass){

            case 2:
                return new BoundingBox(5, 7);

            case 3:
                return new BoundingBox(7, 10);

            default:
                return new BoundingBox(3, 5);
        }



    }
}