
public class Location
{
    public void equals(){}

    public int xCoord;

    public int yCoord;
    //создание нового объекта Location
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    //создание элемента Location с координатами 0,0
    public Location()
    {
        this(0, 0);
    }

    public boolean equals(Object obj)
    {
        if (obj == null) {

            return false;
        }
        if (obj instanceof Location)
        {

            Location other = (Location) obj;

            if (xCoord == other.xCoord && yCoord == other.yCoord)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int result = 19;

        result = 17 * result + (xCoord * 11);

        result = 23 * result + (yCoord * 13);

        return result;

    }
}