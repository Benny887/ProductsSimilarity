import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class MyFileWriter {

    public static void writeResults(String file, List<String> results) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            for (String s : results)
                bufferedWriter.write(s + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл. Проверьте корректность выходных данных.");
            throw new IOException();
        }
    }
}
