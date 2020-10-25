package home_6;

import utils.TestDataPatches;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    public static void putArrayToFile(int[] array, String fileName) {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(createNewFile(fileName)));
            for (int i = 0; i < array.length; i++) {
                dataOutputStream.writeShort(array[i]);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при сохранении массива в файл.");
        }
    }

    public static void putArrayToTempFile(int[] array, String fileName) {
        putArrayToFile(array, fileName);
    }

    public static int[] getArrayFromFile(String fileName, int indexFrom, int indexTo) {
        int arrayChunkLength = indexTo - indexFrom;
        int numberOfRead;
        byte[] byteBuff = new byte[2 * arrayChunkLength];
        short[] shortBuff = new short[arrayChunkLength];
        int[] array = new int[arrayChunkLength];

        DataInputStream dataInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            dataInputStream = new DataInputStream(new FileInputStream(getFullFilePath(fileName)));
            byteArrayOutputStream = new ByteArrayOutputStream();

            dataInputStream.skip(indexFrom * 2);
            numberOfRead = dataInputStream.read(byteBuff, 0, byteBuff.length);
            byteArrayOutputStream.write(byteBuff, 0, numberOfRead);

        } catch (IOException exception) {
            throw new RuntimeException("Ошибка при чтении данных из файла.");
        }

        ByteBuffer.wrap(byteArrayOutputStream.toByteArray()).order(ByteOrder.BIG_ENDIAN).asShortBuffer().get(shortBuff);

        for (int i = 0; i < shortBuff.length; i++) {
            array[i] = Short.toUnsignedInt(shortBuff[i]);
        }
        return array;
    }

    public static long getFileSize(String fileName) {
        try {
            return Files.size(Paths.get(getFullFilePath(fileName)));
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при получении размера файла ");
        }
    }

    public static String createNewFile(String fileName) {
        String fullFileName = ClassLoader.getSystemClassLoader().getResource(TestDataPatches.HW_6_TEST_DATA_FOLDER).getPath()
                + File.separator + fileName;
        File file = new File(fullFileName);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Ошибка при создании временного файла.");
        }
        return fullFileName;
    }

    public static String getFullFilePath(String fileName) {
        String pathToHW6File = TestDataPatches.HW_6_TEST_DATA_FOLDER + File.separator + fileName;
        return ClassLoader.getSystemClassLoader().getResource(pathToHW6File).getPath();
    }
}
