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
            Pair result = solve();
            
            System.out.println(result.first + " " + result.second);
        }
        br.close();

        long tempoFinal = System.currentTimeMillis();
        System.out.printf("\nTempo de execução: " + "%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static Pair solve() {
        if (s.charAt(pos) == '(') {
            pos++;
            Pair left = solve();
            pos++;
            Pair right = solve();
            pos++;
            return new Pair(left.first + right.first + 1, left.second + right.second);
        } else {
            int num = 0;
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                num = num * 10 + (s.charAt(pos) - '0');
                pos++;
            }
            return new Pair(0, num);
        }
    }
}