package eu.learn;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * This program reads arguments passed to it from the command-line
 * or the lines from STDIN, sorts them, and writes the result to STDOUT.
 */
public class Sort {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {

            /* Input from args */

            File file = new File(args[0]);
            if ( file.isDirectory() || file.isFile() ) {

                // Input from file
                Stream<String> inputStream = Files.lines(Paths.get(args[0]));
                inputStream.forEach(System.out::println);

                inputStream.close();

            } else {
                Arrays.sort(args);

                // for (int i = 0; i < args.length; i++) {
                for (String arg : args) {
                    System.out.println(arg);
                }
            }

        } else {

            /* Input from console */

            /*
             * we are connecting the BufferedReader stream with the InputStreamReader
             * stream for reading the line by line data from the keyboard.
             */

            List lines = new ArrayList();

            // BufferedReader class can be used to read data line by line by readLine() method.
            InputStreamReader inputStream =new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader( inputStream );

            String line = null;
            while (!(line = reader.readLine()).equals("stop")) {
                lines.add(line);
            }

            Collections.sort(lines);

            for (Iterator i = lines.iterator(); i.hasNext();) {
                System.out.println(i.next());
            }

            inputStream.close();
            reader.close();
        }
    }
}
