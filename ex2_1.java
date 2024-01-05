import java.util.ArrayList;

public class Ex2_1 {
    public static ArrayList<Point> maxima(Point[] points) {
        ArrayList<Point> maximaPoints = new ArrayList<>();

        // Manually sort the points by their x-coordinates using Merge Sort.
        mergeSort(points, 0, points.length - 1);

        double maxY = 0; // Initialize the maximum y-coordinate.

        // Iterate through the points in decreasing order by x-coordinate.
        for (int i = points.length - 1; i >= 0; i--) {
            Point currentPoint = points[i];

            // Check if the y-coordinate of the current point is greater than the maximum y-coordinate seen so far.
            if (currentPoint.y() > maxY) {
                maximaPoints.add(currentPoint); // Add the current point to the maxima points.
                maxY = currentPoint.y(); // Update the maximum y-coordinate.
            }
        }
        return maximaPoints;
    }

    // Merge Sort implementation for sorting points by x-coordinate.
    private static void mergeSort(Point[] points, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the left and right halves recursively.
            mergeSort(points, left, mid);
            mergeSort(points, mid + 1, right);

            // Merge the sorted halves.
            merge(points, left, mid, right);
        }
    }

    private static void merge(Point[] points, int left, int mid, int right) {
        int a1 = mid - left + 1;
        int a2 = right - mid;

        // Create temporary arrays to hold the left and right halves.
        Point[] l = new Point[a1];
        Point[] r= new Point[a2];

        // Copy data to temporary arrays.
        for (int i = 0; i < a1; i++) {
            l[i] = points[left + i];
        }
        for (int j = 0; j < a2; j++) {
            r[j] = points[mid + 1 + j];
        }

        // Merge the two halves back into the original array.
        int i = 0, j = 0, k = left;
        while (i < a1 && j < a2) {
            if (l[i].x() <= r[j].x()) {
                points[k] = l[i];
                i++;
            } else {
                points[k] = r[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray and rightArray.
        while (i < a1) {
            points[k] = l[i];
            i++;
            k++;
        }
        while (j < a2) {
            points[k] = r[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(4, 5), new Point(6, 9), new Point(9, 3),
                new Point(8, 6), new Point(5, 7), new Point(3, 1),
                new Point(2, 6), new Point(1, 4), new Point(7, 2)
        };

        ArrayList<Point> maxima = maxima(points);

        // Print the maxima points.
        for (Point p : maxima) {
            System.out.println("(" + p.x() + ", " + p.y() + ")");
        }
    }
}

