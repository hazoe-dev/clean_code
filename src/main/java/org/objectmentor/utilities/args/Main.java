package org.objectmentor.utilities.args;


public class Main {
    /**
     * java -cp out org.objectmentor.utilities.args.Main -l -p 8080 -d /home/user
     * @param args
     */
    public static void main(String[] args) {
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }

    public static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("Logging: %b, Port: %d, Directory: %s\n", logging, port, directory);
    }
}
