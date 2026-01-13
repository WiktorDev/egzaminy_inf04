public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Jakis film");

        System.out.println(movie.getTitle());

        System.out.println(movie.getRentalsCount());
        movie.increment();
        System.out.println(movie.getRentalsCount());
    }
}