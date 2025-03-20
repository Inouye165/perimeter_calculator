public class App {
    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();

        System.out.println("\n==============================");
        System.out.println("🔹 Running testPerimeter() for ONE file...");
        pr.testPerimeter();  // ✅ This gives all stats for a single file

        System.out.println("\n==============================");
        System.out.println("🔹 Running testPerimeterMultipleFiles()...");
        pr.testPerimeterMultipleFiles();  // ✅ This finds the largest perimeter among multiple files

        System.out.println("\n==============================");
        System.out.println("🔹 Running testFileWithLargestPerimeter()...");
        pr.testFileWithLargestPerimeter();  // ✅ This finds and prints the file with the largest perimeter

        System.out.println("\n✅ All tests completed.");
    }
}
