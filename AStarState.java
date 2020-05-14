import java.util.HashMap;
public class AStarState
{
   //ссылка на карту
    private Map2D map;

    //коллекция открытых вершин
    private HashMap<Location, Waypoint> openWaypoints;

    //коллекция закрытых вершин
    private HashMap<Location, Waypoint> closedWaypoints;

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;

        openWaypoints = new HashMap<Location, Waypoint>();
        closedWaypoints = new HashMap<Location, Waypoint>();
    }


    public Map2D getMap()
    {
        return map;
    }


    public Waypoint getMinOpenWaypoint()
    {
        Waypoint sol = null;

        float min = Float.POSITIVE_INFINITY;

        float totalCost = 0;

        for(Waypoint p : openWaypoints.values())
        {
            totalCost = p.getTotalCost();

            if(min > totalCost)

            {
                min = totalCost;
                sol = p;
            }

        }

        return sol;
    }


    public boolean addOpenWaypoint(Waypoint newWP)
    {

        Waypoint other = openWaypoints.get(newWP.getLocation());

        if(other == null || newWP.getPreviousCost() < other.getPreviousCost())

        {
            openWaypoints.put(newWP.getLocation(), newWP);

            return true;
        }

        return false;
    }

    public int numOpenWaypoints()
    {
        return openWaypoints.size();
    }



    public void closeWaypoint(Location loc)
    {
        Waypoint point = openWaypoints.remove(loc);

        if(point != null)
        {
            closedWaypoints.put(loc, point);
        }
    }


    public boolean isLocationClosed(Location loc)
    {
        return closedWaypoints.containsKey(loc);
    }
}
