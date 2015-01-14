import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by jutinko on 08/01/15.
 */
public class AlienInvasion {
    private static Map<String, City> cityMap = new HashMap<String, City>();
    private static Set<Alien> aliensTable = new HashSet<Alien>();
    public static int MAX_ITERATION = 100;

    static class Alien {
        City city;
        Integer name;

        public Alien(City city, Integer name) {
            this.city = city;
            this.name = name;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public Integer getName() {
            return name;
        }
    }

    static class City {
        private String name;
        private Set<Alien> aliens = new HashSet<Alien>();

        // The pair's key is the city name, and value the direction
        private Map<String, String> neighbours = new HashMap<String, String>();

        public City(String line) {
            String[] elements = line.split(" ");
            name = elements[0];
            for (int i = 1; i < elements.length; ++i) {
                addToNeighbour(elements[i]);
            }
            cityMap.put(name, this);
        }

        private void addToNeighbour(String n) {
            String[] neighbourInfoPair = n.split("=");
            neighbours.put(neighbourInfoPair[1], neighbourInfoPair[0]);
        }

        // This method returns a random neighbour of this city, if no neighbours
        // present, it will return itself
        public String getRandomNeighbour() {
            while (!neighbours.isEmpty()) {
                Set<String> keySet = neighbours.keySet();
                List<String> shuffledNeighbours = shuffleCollection(keySet);
                Iterator<String> it = shuffledNeighbours.iterator();
                String n = it.next();
                if (!cityMap.containsKey(n)) {
                    neighbours.remove(n);
                } else {
                    return n;
                }
            }
            return this.name;
        }

        private void getDestroyed() {
            for (Alien a : aliens) {
                aliensTable.remove(a);
            }
        }

        // This method should be called at the end of each iteration of
        // alien movement
        public boolean checkIfShouldDestroy() {
            if (aliens.size() > 1) {
                String toPrint = this.name + " has been destroyed by: ";
                for(Alien a : aliens) {
                    toPrint += "alien " + a.getName() + ", ";
                }
                System.out.println(toPrint);
                getDestroyed();
                return true;
            } else {
                return false;
            }
        }

        public void addAlien(Alien alien) {
            aliens.add(alien);
        }

        public void removeAlien(Alien alien) {
            aliens.remove(alien);
        }

        public String getName() {
            return name;
        }

        public String print() {
            String result = "";
            result += this.name;
            for (Map.Entry<String, String> e : neighbours.entrySet()) {
                // Add the neighbours that are not destroyed to the output
                // Since the city might still have a removed city in its neighbours,
                // we just need to check if we can still find the neighbour in cityMap
                if (cityMap.containsKey(e.getKey())) {
                    result += " " + e.getValue() + "=" + e.getKey();
                }
            }
            return result;
        }
    }

    public static <T> List<T> shuffleCollection(Collection<T> c) {
        List<T> toShuffle = new LinkedList<T>();
        for (T t : c) {
            toShuffle.add(t);
        }
        Collections.shuffle(toShuffle);
        return toShuffle;
    }

    public static void printCities() {
        String line;
        for (City c : cityMap.values()) {
            System.out.println(c.print());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("world_map_small.txt"));
        try {
            String line = br.readLine();
            while (line != null) {
                // This method will also add itself to the cityMap
                new City(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }

        Collection<City> cities = cityMap.values();
        List<City> shuffled = shuffleCollection(cities);

        // Here I assume that the number aliens will never be more than the number of cities
        int N = Integer.valueOf(args[0]);
        Iterator<City> it = shuffled.iterator();
        for (int i = 0; i < N; ++i) {
            City city = it.next();
            aliensTable.add(new Alien(city, i));
        }

        int iterations = 0;
        while (!aliensTable.isEmpty() && iterations < MAX_ITERATION) {
            for (Alien a : aliensTable) {
                City initCity = a.getCity();
                initCity.removeAlien(a);
                City nextCity = cityMap.get(initCity.getRandomNeighbour());
                nextCity.addAlien(a);
                a.setCity(nextCity);
            }
            List<String> toRemove = new LinkedList<String>();
            for (City city : cityMap.values()) {
                if (city.checkIfShouldDestroy()) {
                    toRemove.add(city.getName());
                }
            }

            for (String city : toRemove) {
                cityMap.remove(city);
            }
            ++iterations;
        }
        printCities();
    }
}
