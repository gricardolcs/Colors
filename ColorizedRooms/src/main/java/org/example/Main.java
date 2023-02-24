package org.example;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BRIGHT_BG_CYAN = "\u001B[106m";

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        URL res = Main.class.getClassLoader().getResource("demo.txt");
        File file = Paths.get(res.toURI()).toFile();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        int c = 0;

        String verifica = null;
        while ((c = br.read()) != -1) {
            char character = (char) c;
            verifica = String.valueOf(character);
            if (verifica.equals(" ")) {
                fillColor(sb, verifica);
            } else {
                sb.append(verifica);
            }
        }
          System.out.println(sb.toString());
    }

    private static void noFill(StringBuilder sb, String verifica){
        sb.append(verifica.replace(" ", " "));
    }

    private static void fillColor(StringBuilder sb, String verifica) {
         if (!(sb.length() == 178  || sb.length() == 183  || sb.length() == 477
                    || sb.length() == 489  || sb.length() ==  512 )) {
                    sb.append(verifica.replace(" ", ANSI_BRIGHT_BG_CYAN + " " + ANSI_RESET));
            } else {
             sb.append(verifica.replace(" ", " "));
         }
    }
}
