import edu.duke.*;
import java.io.File;
import java.util.Iterator;

public class PerimeterAssignmentRunner {

    /**
     * Calculates the total perimeter of the given shape by summing up the distances 
     * between consecutive points.
     */
    public double getPerimeter(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();  // Start with the last point to close the loop

        for (Point currPt : s.getPoints()) {
            totalPerim += prevPt.distance(currPt);
            prevPt = currPt;
        }
        return totalPerim;
    }

    /**
     * Returns the number of points in the shape.
     */
    public int getNumPoints(Shape s) {
        int count = 0;
        Iterator<Point> it = s.getPoints().iterator();
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }

    /**
     * Computes the average side length of the shape.
     * Assumes the shape has at least one point (otherwise division by zero would occur).
     */
    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        int numPoints = getNumPoints(s);
        return (numPoints > 0) ? perimeter / numPoints : 0;  // Avoids division by zero
    }

    /**
     * Finds the longest side in the shape.
     */
    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            largestSide = Math.max(largestSide, currDist);
            prevPt = currPt;
        }
        return largestSide;
    }

    /**
     * Returns the highest X coordinate value found in the shape.
     * Assumes the shape has at least one point.
     */
    public double getLargestX(Shape s) {
        double largestX = Double.NEGATIVE_INFINITY;
        for (Point p : s.getPoints()) {
            largestX = Math.max(largestX, p.getX());
        }
        return largestX;
    }

    /**
     * Loops through multiple shape files and finds the largest perimeter.
     * Useful for comparing different shapes.
     */
    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            largestPerimeter = Math.max(largestPerimeter, getPerimeter(s));
        }
        return largestPerimeter;
    }

    /**
     * Finds and prints the largest perimeter among multiple shape files.
     */
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter among selected files = " + largestPerimeter);
    }

    /**
     * Returns the filename of the shape file with the largest perimeter.
     */
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        File largestFile = null;
        double largestPerimeter = 0.0;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);

            if (largestFile == null || perimeter > largestPerimeter) {
                largestFile = f;
                largestPerimeter = perimeter;
            }
        }
        return (largestFile != null) ? largestFile.getName() : "No file selected";
    }

    /**
     * Prints the filename of the shape with the largest perimeter.
     */
    public void testFileWithLargestPerimeter() {
        System.out.println("File with the largest perimeter = " + getFileWithLargestPerimeter());
    }

    /**
     * Runs all the shape-related calculations on a single shape file and prints results.
     */
    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        System.out.println("Perimeter = " + getPerimeter(s));
        System.out.println("Number of points = " + getNumPoints(s));
        System.out.println("Average side length = " + getAverageLength(s));
        System.out.println("Largest side length = " + getLargestSide(s));
        System.out.println("Largest X coordinate = " + getLargestX(s));
    }

    /**
     * Creates and tests a basic triangle shape.
     */
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));

        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }

        System.out.println("Perimeter = " + getPerimeter(triangle));
    }

    /**
     * Prints the names of files selected by the user.
     */
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f.getName());
        }
    }
}
