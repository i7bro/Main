import javax.xml.stream.events.StartDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];

        for (int i=1; i <= matrix.length; i++) {
            for (int j=1; j<= matrix[0].length; j++) {
                System.out.print(j * i + "\t");
            }
            System.out.println();
        }
    }
}
