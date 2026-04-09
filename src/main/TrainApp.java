import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class TrainApp {

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

        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nIs Sleeper present? " + exists);

        System.out.println("\nFinal Bogie List:");
        System.out.println(passengerBogies);

        // ================= UC3 =================
        Set<String> bogieIDs = new HashSet<>();

        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIDs);

        System.out.println("\nProgram running...");
    }
}