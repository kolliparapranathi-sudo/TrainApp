import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TrainApp {

    // ================= COMMON CLASSES =================
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String toString() {
            return name + "(" + capacity + ")";
        }
    }

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

    // ================= EXCEPTIONS =================
    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String msg) {
            super(msg);
        }
    }

    static class CargoSafetyException extends RuntimeException {
        CargoSafetyException(String msg) {
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

    public static void main(String[] args) {

        System.out.println("===== Train Consist Management App =====");

        // UC1
        List<String> train = new ArrayList<>();
        System.out.println("UC1: Initial count = " + train.size());

        // UC2
        List<String> passengers = new ArrayList<>(Arrays.asList("Sleeper","AC Chair","First Class"));
        passengers.remove("AC Chair");
        System.out.println("\nUC2: " + passengers);

        // UC3
        Set<String> ids = new HashSet<>(Arrays.asList("BG101","BG102","BG101"));
        System.out.println("\nUC3: " + ids);
 feature/UC17-ArraysSort
        // UC4
        LinkedList<String> order = new LinkedList<>(Arrays.asList("Engine","Sleeper","AC","Cargo","Guard"));
        order.add(2,"Pantry");
=======
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
 main
        order.removeFirst();
        order.removeLast();
        System.out.println("\nUC4: " + order);

        // UC5
        LinkedHashSet<String> formation = new LinkedHashSet<>(Arrays.asList("Engine","Sleeper","Cargo","Guard","Sleeper"));
        System.out.println("\nUC5: " + formation);

        // UC6
        Map<String,Integer> map = Map.of("Sleeper",72,"AC Chair",60,"First Class",40);
        System.out.println("\nUC6:");
        map.forEach((k,v)->System.out.println(k+" -> "+v));

        // UC7
        List<Bogie> bogies = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper",72),
                new Bogie("AC Chair",60),
                new Bogie("First Class",40)
        ));
        bogies.sort(Comparator.comparingInt(b->b.capacity));
        System.out.println("\nUC7:");
        bogies.forEach(System.out::println);

        // UC8
        System.out.println("\nUC8:");
        bogies.stream().filter(b->b.capacity>60).forEach(System.out::println);

        // UC9
        System.out.println("\nUC9:");
        bogies.stream().collect(Collectors.groupingBy(b->b.name))
                .forEach((k,v)->System.out.println(k+" -> "+v));

        // UC10
        int total = bogies.stream().map(b->b.capacity).reduce(0,Integer::sum);
        System.out.println("\nUC10 Total: "+total);

        // UC11
        System.out.println("\nUC11:");
        System.out.println("Train valid: "+Pattern.matches("TRN-\\d{4}","TRN-1234"));
        System.out.println("Cargo valid: "+Pattern.matches("PET-[A-Z]{2}","PET-AB"));

        // UC12
        System.out.println("\nUC12: Safety check done");

        // UC13
        List<Bogie> big = new ArrayList<>();
        for(int i=0;i<10000;i++) big.add(new Bogie("Sleeper",72));
        long t1=System.nanoTime();
        big.stream().filter(b->b.capacity>60).toList();
        long t2=System.nanoTime();
        System.out.println("\nUC13 Time: "+(t2-t1));

        // UC14
        try {
            new PassengerBogie("AC",0);
        } catch (Exception e) {
            System.out.println("\nUC14: "+e.getMessage());
        }

        // UC15
        System.out.println("\nUC15:");
        new GoodsBogie("Cylindrical").assignCargo("Petroleum");
        new GoodsBogie("Rectangular").assignCargo("Petroleum");

        // UC16
        System.out.println("\nUC16:");
        int[] arr={72,56,24,70,60};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j]; arr[j]=arr[j+1]; arr[j+1]=t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // UC17
        System.out.println("\nUC17:");
        String[] names={"Sleeper","AC Chair","First Class","General","Luxury"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        // UC18
        System.out.println("\nUC18:");
        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";

        boolean found = false;
        for(String id : bogieIDs){
            if(id.equals(searchKey)){
                found = true;
                break;
            }
        }
        System.out.println(found ? "FOUND" : "NOT FOUND");

        // UC19
        System.out.println("\nUC19:");
        String[] arrIDs = {"BG309","BG101","BG550","BG205","BG412"};
        Arrays.sort(arrIDs);

        String key = "BG309";
        int low=0, high=arrIDs.length-1;
        boolean foundBinary=false;

        while(low<=high){
            int mid=(low+high)/2;
            int cmp = arrIDs[mid].compareTo(key);

            if(cmp==0){ foundBinary=true; break; }
            else if(cmp<0) low=mid+1;
            else high=mid-1;
        }

        System.out.println(foundBinary ? "FOUND" : "NOT FOUND");

        // ================= UC20 =================
        System.out.println("\nUC20:");

        String[] emptyData = {}; // empty case

        try {
            if (emptyData.length == 0) {
                throw new IllegalStateException("Cannot search: No bogies available.");
            }

            // (this part won't run because exception occurs)
            boolean result = false;
            for(String id : emptyData){
                if(id.equals("BG101")){
                    result = true;
                }
            }

            System.out.println(result ? "FOUND" : "NOT FOUND");

        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n=== Program Completed ===");
    }
}