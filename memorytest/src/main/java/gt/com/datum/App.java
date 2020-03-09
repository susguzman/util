package gt.com.datum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(final String args[]) {
        // Print SO Memory
        System.out.println("***** SO Memory *****");
        try {
            final Process process = Runtime.getRuntime().exec("free -m");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final int MegaBytes = 1024 * 1024;
        int j = 0;
        while (true) {
            // Print Memory Status
            System.out.println("***** Iteration: " + j + " *****");
            System.out.println("Max:   " + Runtime.getRuntime().maxMemory() / MegaBytes);
            System.out.println("Total: " + Runtime.getRuntime().totalMemory() / MegaBytes);
            System.out.println("Free:  " + Runtime.getRuntime().freeMemory() / MegaBytes);
            System.out.println("Used:  " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / MegaBytes));

            // Sleep by 5 seg
            try {
                Thread.sleep(5000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }

            // Fill in Memory
            ArrayList<String> objects = new ArrayList<String>();
            for (int i = 0; i < 1000000; i++) {
                objects.add(("" + 10 * 2710));
            }

            j++;
        }
    }
}
