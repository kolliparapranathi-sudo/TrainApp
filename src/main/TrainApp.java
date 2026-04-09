import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("======================================");
        System.out.println("  Train Consist Management App");
        System.out.println("======================================");

        // Initialize empty train consist
        List<String> trainConsist = new ArrayList<>();

        // Display initial bogie count
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        System.out.println("\nProgram running...");
    }
}