import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    // Method to calculate the perimeter of a shape
    public double getPerimeter(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim += currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    // Method to count the number of points (sides) in the shape
    public int getNumPoints(Shape s) {
        int count = 0;
        for (Point p : s.getPoints()) {
            count++;  // Increment count for each point
        }
        return count;
    }

    // Method to calculate the average side length of the shape
    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        int numPoints = getNumPoints(s);
        if (numPoints == 0) return 0;  // Avoid division by zero
        return perimeter / numPoints;
    }

    // Placeholder method for the largest side (to be implemented later)
    public double getLargestSide(Shape s) {
        return 0.0;
    }

    // Placeholder method for the largest X coordinate (to be implemented later)
    public double getLargestX(Shape s) {
        return 0.0;
    }

    // Placeholder method for finding the largest perimeter across multiple files
    public double getLargestPerimeterMultipleFiles() {
        return 0.0;
    }

    // Placeholder method for finding the file with the largest perimeter
    public String getFileWithLargestPerimeter() {
        File temp = null;  // Replace with actual implementation later
        return temp.getName();
    }

    // Test method for calculating perimeter, number of points, and average length
    public void testPerimeter() {
        FileResource fr = new FileResource();  // Opens file selection dialog
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("Perimeter = " + length);

        int numPoints = getNumPoints(s);
        System.out.println("Number of points = " + numPoints);

        double avgLength = getAverageLength(s);
        System.out.println("Average side length = " + avgLength);
    }
    
    // Placeholder for testing multiple files (to be implemented later)
    public void testPerimeterMultipleFiles() {
        // To be implemented
    }

    // Placeholder for testing the file with the largest perimeter (to be implemented later)
    public void testFileWithLargestPerimeter() {
        // To be implemented
    }

    // This method creates a triangle for testing purposes
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("Perimeter = " + peri);
    }

    // This method prints the names of all files in a chosen folder
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
