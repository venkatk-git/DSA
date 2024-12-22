package cputils;

import java.io.*;
import java.util.*;

public class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        try {
            // Ensure input.txt exists or create it
            File inputFile = new File("input.txt");
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }
            // Ensure output.txt exists or create it
            File outputFile = new File("output.txt");
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            br = new BufferedReader(new FileReader(inputFile));
            PrintStream out = new PrintStream(new FileOutputStream(outputFile));
            System.setOut(out); // Redirect output to output.txt
        } catch (Exception e) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
