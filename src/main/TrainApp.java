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

    // ================= UC12 & UC15 =================

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) {
            this.type = type;
        }

        void assignCargo(String cargo) {
            try {
                if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe: Rectangular cannot carry Petroleum");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned: " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Assignment completed.\n");
            }
        }
    }

    // ================= UC14 =================

    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String msg) {
            super(msg);
        }
    }

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
    }

    // ================= UC15 =================

    static class CargoSafetyException extends RuntimeException {
        CargoSafetyException(String msg) {
            super(msg);
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
        System.out.println("\nPassenger Bogies: " + passengerBogies);

 UC3-UniqueBogieIDs
        // ================= UC3 =================
        Set<String> ids = new HashSet<>(Arrays.asList("BG101", "BG102", "BG101"));
        System.out.println("\nUnique IDs: " + ids);

 UC4-TrainConsistLinkedList
        // ================= UC4 =================
        LinkedList<String> order = new LinkedList<>(Arrays.asList("Engine", "Sleeper", "AC", "Cargo", "Guard"));
        order.add(2, "Pantry");
        order.removeFirst();
        order.removeLast();
        System.out.println("\nTrain Order: " + order);

        // ================= UC5 =================
        LinkedHashSet<String> formation = new LinkedHashSet<>(Arrays.asList("Engine", "Sleeper", "Cargo", "Guard", "Sleeper"));
        System.out.println("\nFormation: " + formation);

        // ================= UC6 =================
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);
        System.out.println("\nCapacities:");
        capacityMap.forEach((k, v) -> System.out.println(k + " → " + v));

        // ================= UC7 =================
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40)
        );
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nSorted Bogies:");
        bogies.forEach(System.out::println);

        // ================= UC8 =================
        System.out.println("\nFiltered (>60):");
        bogies.stream().filter(b -> b.capacity > 60).forEach(System.out::println);

        // ================= UC9 =================
        System.out.println("\nGrouped:");
        bogies.stream().collect(Collectors.groupingBy(b -> b.name))
                .forEach((k, v) -> System.out.println(k + " → " + v));

        // ================= UC10 =================
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        System.out.println("\nTotal Capacity: " + total);

        // ================= UC11 =================
        Pattern p1 = Pattern.compile("TRN-\\d{4}");
        Pattern p2 = Pattern.compile("PET-[A-Z]{2}");
        System.out.println("\nTrain Valid: " + p1.matcher("TRN-1234").matches());
        System.out.println("Cargo Valid: " + p2.matcher("PET-AB").matches());

        // ================= UC12 =================
        List<GoodsBogie> goods = Arrays.asList(new GoodsBogie("Cylindrical"), new GoodsBogie("Rectangular"));
        System.out.println("\nSafety Checked");

        // ================= UC13 =================
        List<Bogie> bigList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) bigList.add(new Bogie("Sleeper", 72));

        long t1 = System.nanoTime();
        bigList.stream().filter(b -> b.capacity > 60).toList();
        long t2 = System.nanoTime();
        System.out.println("\nUC13 Time: " + (t2 - t1));

        // ================= UC14 =================
        try {
            new PassengerBogie("AC", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("\nException: " + e.getMessage());
        }

        // ================= UC15 =================
        System.out.println("\nUC15:");
        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        g1.assignCargo("Petroleum");

        GoodsBogie g2 = new GoodsBogie("Rectangular");
        g2.assignCargo("Petroleum");

        // ================= UC16 =================
        System.out.println("\nUC16 Bubble Sort:");

        int[] arr = {72, 56, 24, 70, 60};
        System.out.println("Before: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("After:  " + Arrays.toString(arr));

        System.out.println("\nProgram Completed Successfully!");
    }
}