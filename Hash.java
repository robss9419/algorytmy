import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTable {
    public static ArrayList<LastName> lastnames;
    public static ArrayList<LastName> hashlast;


    public HashTable() {
        this.lastnames = new ArrayList<>();
        this.hashlast = new ArrayList<>();
    }

    public static void addLastName(LastName lastname) {
        lastnames.add(lastname);
    }

    public static int insert(String key, int p, int mod) {
        int k = 0;
        for(int c = 0; c < mod; c++) {
            int x = (key.length() + (c * (1 + (key.length() % (mod - 2))))) % mod;
            if (hashlast.get(x).getLastname() == null) {
                hashlast.get(x).setLastname(lastnames.get(p).getLastname());
                hashlast.get(x).setPopularity(lastnames.get(p).getPopularity());
                //System.out.println(p + ". Nazwisko: " + key + " znalazlo sie na pozycji: " + x + " |  liczba kolizji: " + c);
                return c;
            }
        }
        return 0;
    }

    public static void search(String key) {
        for(int i = 0; i < hashlast.size(); i++) {
            if (hashlast.get(i).getLastname().equals(key)) {
                System.out.println("Nazwisko " + key +" znajduje sie na " + (i+1) + " pozycji");
                break;
            }
            else if (i == hashlast.size() - 1) {
                System.out.println("Brak nazwiska na liście");
            }
        }
    }

    public static void delete(String key) {
        for(int i = 0; i < hashlast.size(); i++) {
            if(hashlast.get(i).getLastname().equals(key)) {
                hashlast.get(i).setLastname("DEL");
            }
        }
    }

    static ArrayList<String[]> read() throws FileNotFoundException {
        Scanner ob = new Scanner(new File("nazwiska.txt"));
        ArrayList<String[]> lista = new ArrayList<>();
        while(ob.hasNextLine()) {
            String str = ob.nextLine();
            if(str == null || str.isEmpty()) {
                break;
            }
            else {
                lista.add(str.split(" "));
            }
        }
        return lista;
    }

    public static void main(String[] args) throws FileNotFoundException {
        HashTable hashTable = new HashTable();
        ArrayList<String[]> lista = read();
        for (String[] s : lista) {
            hashTable.addLastName(LastName.create(Integer.parseInt(s[0]), s[1]));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10000);
        arr.add(14000);
        arr.add(17000);
        arr.add(20000);
        for(int mod : arr) {
            for (int i = 0; i < mod; i++) {
                hashlast.add(LastName.create(0, null));
            }
            System.out.println("Test dla " + mod + "elementow");
            int kol = 0;
            long start = System.currentTimeMillis();
            for (int i = 0; i < mod; i++) {
                int col = insert(lastnames.get(i).getLastname(), i, mod);
                kol += col;
            }
            System.out.println("Czas algorytmu: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println("Liczba kolizji: " + kol);
            double result = (double) kol / (double) mod;
            double rs = Math.round(result * 100.00) / 100.00;
            System.out.println("Średnia z liczy prób wstawienia wszystkich elementów: " + rs);
            System.out.println();
        }
    }
}
