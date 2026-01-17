public class Main {
    /**
     * nazwa metody:        fill
     * parametry wejściowe: tablica typu logicznego (boolean)
     * wartość zwracana:    brak
     * informacje:          uzupełnia tablice wartościami true
     * autor:               00000000000
     */
    public static void fill(boolean[] arr) {
        for (int i = 2; i <= arr.length-1; i++) {
            arr[i] = true;
        }
    }

    /**
     * nazwa metody:        sieve
     * parametry wejściowe: brak
     * wartość zwracana:    brak
     * informacje:          implementacja algorytmu sita Eratostenesa
     * autor:               00000000000
     */
    public static void sieve() {
        int n = 100;
        boolean[] A = new boolean[n+1];
        fill(A);

        for (int i = 2; i * i <= n; i++) {
            if (!A[i]) continue;
            for (int j = 2 * i; j <= n; j += i) {
                A[j] = false;
            }
        }

        System.out.println("Liczby pierwsze od 2 do " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (A[i]) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        sieve();
    }
}