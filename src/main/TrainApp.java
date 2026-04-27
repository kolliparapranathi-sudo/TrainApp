import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrainApp {

    // ================= COMMON CLASSES =================

    // Bogie (UC7–UC10, UC13)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + "(" + capacity + ")";
        }
    }

    // Goods Bogie (UC12)
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // ================= UC14 =================

    // Custom Exception
    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie with validation
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (" + capacity + ")";
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Train Consist Management App");
        System.out.println("======================================");

 UC3-UniqueBogieIDs
        // ================= UC1 =================

        // UC1: Initialize train consist
 main
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

 UC3-UniqueBogieIDs
        // ================= UC2 =================

        // UC2: Passenger bogies
 main
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        passengerBogies.remove("AC Chair");

        System.out.println("\nPassenger Bogies:");
        System.out.println(passengerBogies);

 UC3-UniqueBogieIDs
        // ================= UC3 =================
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101");

        System.out.println("\nUnique IDs:");
        System.out.println(bogieIDs);

 UC4-TrainConsistLinkedList
        // ================= UC4 =================
        LinkedList<String> trainOrder = new LinkedList<>();
        trainOrder.add("Engine");
        trainOrder.add("Sleeper");
        trainOrder.add("AC");
        trainOrder.add("Cargo");
        trainOrder.add("Guard");

        trainOrder.add(2, "Pantry");
        trainOrder.removeFirst();
        trainOrder.removeLast();

        System.out.println("\nTrain Order:");
        System.out.println(trainOrder);

        // ================= UC5 =================
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("\nFormation:");
        System.out.println(formation);

        // ================= UC6 =================
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);

        System.out.println("\nCapacities:");
        capacityMap.forEach((k, v) -> System.out.println(k + " → " + v));

        // ================= UC7 =================
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 40));

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nSorted Bogies:");
        bogieList.forEach(System.out::println);

        // ================= UC8 =================
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered (>60):");
        filtered.forEach(System.out::println);

        // ================= UC9 =================
        Map<String, List<Bogie>> grouped = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogies:");
        grouped.forEach((k, v) -> System.out.println(k + " → " + v));

        // ================= UC10 =================
        int totalCapacity = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity:");
        System.out.println(totalCapacity);

        // ================= UC11 =================
        String trainID = "TRN-1234";
        String cargoCode = "PET-AB";

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        System.out.println("\nTrain ID Valid: " + trainPattern.matcher(trainID).matches());
        System.out.println("Cargo Code Valid: " + cargoPattern.matcher(cargoCode).matches());

        // ================= UC12 =================
        List<GoodsBogie> goodsList = new ArrayList<>();

        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Rectangular", "Coal"));
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafe = goodsList.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum")
                );

        System.out.println("\nTrain Safety Compliance: " + (isSafe ? "SAFE" : "UNSAFE"));

        // ================= UC13 =================
        List<Bogie> testBogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            testBogies.add(new Bogie("Sleeper", 72));
            testBogies.add(new Bogie("AC Chair", 60));
            testBogies.add(new Bogie("First Class", 40));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }
        long loopTime = System.nanoTime() - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamResult = testBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startStream;

        System.out.println("\nUC13 Performance:");
        System.out.println("Loop Time: " + loopTime);
        System.out.println("Stream Time: " + streamTime);

        // ================= UC14 =================
        try {
            PassengerBogie p1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie p2 = new PassengerBogie("AC Chair", 0); // invalid

            System.out.println("\nPassenger Bogies:");
            System.out.println(p1);
            System.out.println(p2);

        } catch (InvalidCapacityException e) {
            System.out.println("\nException: " + e.getMessage());
        }

        System.out.println("\nProgram running...");
    }
}