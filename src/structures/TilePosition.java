package structures;

public class TilePosition {
    public String table;
    public int collumn;
    public int row;
    public int width;
    public int height;
    //A echanger par une description des lookups individuelement et tout mettre dans un JSON ou XML

    public TilePosition(int collumn, int row, int width, int height)
    {
        this.collumn = collumn;
        this.row = row;
        this.width = width;
        this.height = height;

    }
}
