import edu.duke.*;
import java.io.File;
import java.util.Iterator;

public class PerimeterAssignmentRunner {
    public double getPerimeter(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            totalPerim += prevPt.distance(currPt);
            prevPt = currPt;
        }
        return totalPerim;
    }

    // Updated getNumPoints() using an explicit iterator to avoid an unused loop variable.
    public int getNumPoints(Shape s) {
        int count = 0;
        Iterator<Point> it = s.getPoints().iterator();
        while(it.hasNext()){
            it.next();  // Retrieve the point (we don't need to store it)
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        int numPoints = getNumPoints(s);
        return (numPoints == 0) ? 0 : perimeter / numPoints;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide) {
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = Double.NEGATIVE_INFINITY;
        for (Point p : s.getPoints()) {
            if (p.getX() > largestX) {
                largestX = p.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        File temp = null;
        double largestPerimeter = 0.0;

        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);

            if (temp == null || perimeter > largestPerimeter) {
                temp = f;
                largestPerimeter = perimeter;
            }
        }
        return (temp != null) ? temp.getName() : "No file selected";
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("Perimeter = " + length);

        int numPoints = getNumPoints(s);
        System.out.println("Number of points = " + numPoints);

        double avgLength = getAverageLength(s);
        System.out.println("Average side length = " + avgLength);

        double largestSide = getLargestSide(s);
        System.out.println("Largest side length = " + largestSide);

        double largestX = getLargestX(s);
        System.out.println("Largest X coordinate = " + largestX);
    }

    public void testPerimeterMultipleFiles() {
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter in multiple files = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        String largestFile = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + largestFile);
    }

    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("Perimeter = " + peri);
    }

    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f.getName());
        }
    }
}
