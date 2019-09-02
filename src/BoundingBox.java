
public class BoundingBox{

    int sizeX;
    int sizeY;
    int sizeClass;


    public BoundingBox(int size_x, int size_y)
    {
        this.sizeX = size_x;
        this.sizeY = size_y;
    }

    public int getSizeClass()
    {
        return this.sizeClass;
    }
}