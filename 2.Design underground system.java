import java.util.HashMap;

class UndergroundSystem {

    // Stores passenger check-in information
    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores total travel time and number of trips
    class TravelData {
        int totalTime;
        int tripCount;

        TravelData(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    private HashMap<Integer, CheckInData> checkIns;
    private HashMap<String, TravelData> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckInData data = checkIns.get(id);

        String route = data.station + "->" + stationName;
        int travelTime = t - data.time;

        if (!routes.containsKey(route)) {
            routes.put(route, new TravelData(0, 0));
        }

        TravelData stats = routes.get(route);
        stats.totalTime += travelTime;
        stats.tripCount++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        TravelData stats = routes.get(route);

        return (double) stats.totalTime / stats.tripCount;
    }
}
