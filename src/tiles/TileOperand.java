package tiles;

public class TileOperand
{

    public static TileOperand[] tilesOperand = new TileOperand[]
    {
        new TileOperand("\\times",2),
        new TileOperand("\\frac",2),
        new TileOperand("\\lim",2),
        new TileOperand("\\int",2),
        new TileOperand("\\bar",1),
        new TileOperand("\\abs",1),
        new TileOperand("\\sqrt",1),
        new TileOperand("\\sum",3),
        new TileOperand("\\prod", 3),
    };

    String tile;
    int bracketsNeeded;
    public TileOperand(String tile_, int brack)
    {
        this.tile = tile_;
        this.bracketsNeeded = brack;
    }


    public int getBracketsNeeded() {
        return bracketsNeeded;
    }

    public static int getBracketsNeeded(String tile)
    {

        for(TileOperand to : tilesOperand)
        {

            if(to.tile.equals(tile))
            {

                return to.getBracketsNeeded();
            }
        }
        return 0;
    }

}
