import home_6.CountingSort;
import home_6.NumberGenerator;
import home_6.RadixSort;
import org.junit.Test;
import utils.TestDataPatches;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static home_6.FileManager.getFullFilePath;

public class FileManagerTest {

    @Test
    public void showSortedArray() {
        int first = 0;
        int second = 1000;
        int[] array = new int[second - first];

        String fullPathToFile = "hw6.out";

        try {
            DataInputStream outputStream = new DataInputStream(
                    new FileInputStream(getFullFilePath(fullPathToFile))
            );

            for (int i = 0; i < second - first; i++) {
                array[i] = Short.toUnsignedInt(outputStream.readShort());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        for (int i = 0; i < second - first - 1; i ++) {
            if (array[i] > array[i + 1]) {
                System.out.println(String.format("ALARM !!! Place a = %s, value = %s. Place b = %s, value = %s. ", i, array[i], i + 1, array[i + 1]));
            }
        }
    }

    @Test
    public void sortedArrayContainAllRawNumbers() {
        String pathToRawArrayFile = "hw6.in";
        String pathToSortedArrayFile = "hw6.out";
        int first = 0;
        int second = 1000;
        int[] rawArray = new int[second - first];
        int[] sortedArray = new int[second - first];

        try {
            DataInputStream outputStream = new DataInputStream(
                    new FileInputStream(getFullFilePath(pathToRawArrayFile))
            );

            for (int i = 0; i < second - first; i++) {
                rawArray[i] = Short.toUnsignedInt(outputStream.readShort());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            DataInputStream outputStream = new DataInputStream(
                    new FileInputStream(getFullFilePath(pathToSortedArrayFile))
            );

            for (int i = 0; i < second - first; i++) {
                sortedArray[i] = Short.toUnsignedInt(outputStream.readShort());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        boolean found;
        for (int i = 0; i < second - first - 1; i ++) {
            found = false;
            for (int j = 0; j < rawArray.length; j ++) {
                if(rawArray[j] == sortedArray[i]) {
                    found = true;
                }
            }
            if (!found) {
                System.out.println(String.format("Element %s not found in raw array", sortedArray[i]));
            }
        }
    }

    @Test
    public void showArray() {
        int first = 812;
        int second = 875;
        int[] array = new int[second - first];

        try {
            DataInputStream outputStream = new DataInputStream(
                    new FileInputStream(getFullFilePath("temp" + File.separator + String.format("sorted_%s_%s", first, second)))
            );

            for (int i = 0; i < second - first; i++) {
                array[i] = Short.toUnsignedInt(outputStream.readShort());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
//        System.out.println(Arrays.toString(array));
    }

    @Test
    public void checkAllSortedFiles() {

        String tempFolderPath = "temp";
        List<String> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(getFullFilePath(tempFolderPath)))) {

            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String pathToFile :result) {
            File file = new File(pathToFile);
            int numberOfElement = (int) file.length() / 2;
            int[] array = new int[numberOfElement];

            try {
                DataInputStream outputStream = new DataInputStream(
                        new FileInputStream(pathToFile)
                );

                for (int i = 0; i < array.length; i++) {
                    array[i] = Short.toUnsignedInt(outputStream.readShort());
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

//            System.out.println(Arrays.toString(array));

            for (int i = 0; i < array.length - 1; i ++) {
                if (array[i] > array[i + 1]) {
                    System.out.println(String.format("ALARM in file %s !!! Place a = %s, value = %s. Place b = %s, value = %s. ", pathToFile, i, array[i], i + 1, array[i + 1]));
                }
            }
        }

    }

//    @Test
//    public void simpleTest() {
//        RadixSort.Numbers[] test1 = new RadixSort.Numbers[5];
//        Arrays.fill(test1, new RadixSort.Numbers());
//        for (int i = 0; i < test1.length; i ++) {
//            System.out.println(test1[i].toString());
//        }
//    }

}
