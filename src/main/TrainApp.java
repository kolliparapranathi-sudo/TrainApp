import java.util.*;
import java.util.stream.Collectors;

public class TrainApp {

    // ================= UC7 & UC8: Bogie Class =================
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " → Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Train Consist Management App");
        System.out.println("======================================");

        // ================= UC1 =================
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ================= UC2 =================
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nPassenger Bogies:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("Is Sleeper present? " + exists);

        // ================= UC3 =================
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101");

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIDs);

        // ================= UC4 =================
        LinkedList<String> trainOrder = new LinkedList<>();
        trainOrder.add("Engine");
        trainOrder.add("Sleeper");
        trainOrder.add("AC");
        trainOrder.add("Cargo");
        trainOrder.add("Guard");

        trainOrder.add(2, "Pantry Car");

        trainOrder.removeFirst();
        trainOrder.removeLast();

        System.out.println("\nTrain Order:");
        System.out.println(trainOrder);

        // ================= UC5 =================
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("\nTrain Formation:");
        System.out.println(trainFormation);

        // ================= UC6 =================
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 40);

        System.out.println("\nBogie Capacity:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // ================= UC7 =================
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 40));

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nSorted Bogies:");
        bogieList.forEach(System.out::println);

        // ================= UC8 =================
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nProgram running...");
    }
}