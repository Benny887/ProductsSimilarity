import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MyFileReader {

    public static void handleInputFile(String file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            Queue<String> allReadLines = new LinkedList<>();
            while (bufferedReader.ready())
                allReadLines.add(bufferedReader.readLine());
            allReadLines.removeIf(String::isEmpty);
            for (int i = 0; i < 2; i++) {
                int countToReadLines = Integer.parseInt(Objects.requireNonNull(allReadLines.poll()));
                getProdLists(countToReadLines, allReadLines, SearchForCoincidence.getAllProds());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении файла. Проверьте корректность входных данных.");
            throw new IOException();
        }
    }

    private static void getProdLists(int countStringsToRead, Queue<String> allReadLines, List<List<String>> allProds) throws IOException {
        List<String> prods = new ArrayList<>();
        for (int i = 0; i < countStringsToRead; i++) {
            prods.add(allReadLines.poll());
        }
        allProds.add(prods);
    }
}
