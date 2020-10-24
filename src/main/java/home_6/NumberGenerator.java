package home_6;

import java.io.*;
import java.util.Random;

import static home_6.FileManager.createNewFile;

public class NumberGenerator {

    public static int[] generateArray(int len, int maxValue) {
        Random random = new Random();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }

    public static void generateArrayToFile(String fileName, int len) {
        Random random = new Random();
        DataOutputStream dataOutputStream;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(createNewFile(fileName)));
            for (int i = 0; i < len; i++) {
                dataOutputStream.writeShort(random.nextInt(65536));
            }

            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Ошибка при записи массива длинной %s в файл %s.", len, fileName));
        }
    }

}
