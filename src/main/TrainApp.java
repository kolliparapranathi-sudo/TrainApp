import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Train Consist Management App");
        System.out.println("======================================");

 UC3-UniqueBogieIDs
        // ================= UC1 =================

        // UC1: Initialize train consist
 main
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

 UC3-UniqueBogieIDs
        // ================= UC2 =================

        // UC2: Passenger bogies
 main
        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nIs Sleeper present? " + exists);

        System.out.println("\nFinal Bogie List:");
        System.out.println(passengerBogies);

 UC3-UniqueBogieIDs
        // ================= UC3 =================
        Set<String> bogieIDs = new HashSet<>();

        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIDs);

 UC4-TrainConsistLinkedList
        // ================= UC4 =================
        LinkedList<String> trainOrder = new LinkedList<>();

        trainOrder.add("Engine");
        trainOrder.add("Sleeper");
        trainOrder.add("AC");
        trainOrder.add("Cargo");
        trainOrder.add("Guard");

        // Insert at position
        trainOrder.add(2, "Pantry Car");

        System.out.println("\nTrain Consist after insertion:");
        System.out.println(trainOrder);

        // Remove first and last
        trainOrder.removeFirst();
        trainOrder.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(trainOrder);



 main
 main
        System.out.println("\nProgram running...");
    }
}