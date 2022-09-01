public class Main {

    public static void main(String[] args) {
        try {
            MyFileReader.handleInputFile(args[0]);
            SearchForCoincidence search = new SearchForCoincidence();
            MyFileWriter.writeResults(args[1], search.searchCoincidence());
            System.out.println("Программа выполнена.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка. Программа завершает работу.");
        }
    }

}
