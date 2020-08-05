package home_1.testing;

import home_1.luckyTic.LuckyTickets;
import home_1.luckyTic.LuckyTicketsImpl;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        runLuckyTicketsTests();
    }

    public static void runLuckyTicketsTests() throws IOException {
        final String ticketsTestsPath = "\\HomeWork\\1\\Tickets";


        FileReader fileReader = new FileReader();
        LuckyTickets luckyTickets = new LuckyTicketsImpl();

        List<Path> inTestData = fileReader.getTestData(ticketsTestsPath, "in");
        List<Path> outTestData = fileReader.getTestData(ticketsTestsPath, "out");

        System.out.println("Тестирование программы \"Счастливый билет\":");
        for (int i=0; i<inTestData.size(); i++) {
            String inData = Files.readString(inTestData.get(i));
            String outData = Files.readString(outTestData.get(i));

            BigInteger result = luckyTickets.getLuckyTickets(Integer.parseInt(inData));
            System.out.println(String.format("Входные данные теста : %s.", inData));
            System.out.println(String.format("Выходные данные теста : %s.", outData.trim()));
            System.out.println(String.format("Результат : %s.", result));
            System.out.println(String.format("Статус теста: %s. ",
                    BigInteger.valueOf(Long.parseLong(outData.trim())).equals(result)
                            ? "Пройден"
                            : "Провален"));

            System.out.println("\n =========== \n");

        }
    }

    public static void runStringTests() throws IOException {
        final String stringTestsPath = "\\HomeWork\\1\\String";
        FileReader fileReader = new FileReader();

        List<Path> inTestData = fileReader.getTestData(stringTestsPath, "in");
        List<Path> outTestData = fileReader.getTestData(stringTestsPath, "out");

        System.out.println("Тестирование программы \"Длинна строки\":");
        for (int i = 0; i < inTestData.size(); i++) {
            String inData = Files.readString(inTestData.get(i)).trim();
            String outData = Files.readString(outTestData.get(i)).trim();

            int result = inData.length();
            System.out.println(String.format("Входные данные теста : %s", inData));
            System.out.println(String.format("Выходные данные теста : %s", outData));
            System.out.println(String.format("Результат : %s.", result));
            System.out.println(String.format("Статус теста: %s. ",
                    Integer.parseInt(outData) == result
                            ? "Пройден"
                            : "Провален"));

            System.out.println("\n =========== \n");
        }
    }
}
