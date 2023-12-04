import java.io.*;
import java.util.*;

public class Main {
    static int pos;
    static String s;

    public static void main(String[] args) throws IOException {
        long tempoInicial = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("teste.txt"));
        String line;
        System.out.println("");
        while ((line = br.readLine()) != null) {
            s = line;
            pos = 0;
            Neighbourhood.Pair result = Neighbourhood.solve(s, pos);
            
            System.out.println(result.first + " " + result.second);
        }
        br.close();

        long tempoFinal = System.currentTimeMillis();
        System.out.printf("\nTempo de execução: " + "%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }
}