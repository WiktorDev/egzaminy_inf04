import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Files {
    public static void loadFiledWithNIO() throws Exception {
        Path path = Path.of(Main.class.getClassLoader().getResource("data.txt").toURI());
        List<String> lines = java.nio.file.Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void saveToFile(String content, String fileName) {
        try {
            Path path = Path.of(fileName);
            java.nio.file.Files.writeString(path, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToFileBuffered(String content, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadFileByScanner() {
        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("/data.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    public static void loadFileClassic() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/data.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
