public class App {
    /**
     * The main entry point of the application.
     * It instantiates the PerimeterAssignmentRunner and executes its test methods.
     * @param args Command line arguments (not used).
     */
    public static void main(String[]args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();

        System.out.println("\n==============================");
        System.out.println("🔹 Running testPerimeter() for ONE file...");
        pr.testPerimeter();

        System.out.println("\n==============================");
        System.out.println("🔹 Running testPerimeterMultipleFiles()...");
        pr.testPerimeterMultipleFiles();

        System.out.println("\n==============================");
        System.out.println("🔹 Running testFileWithLargestPerimeter()...");
        pr.testFileWithLargestPerimeter();

        System.out.println("\n All tests completed.");
    }
}