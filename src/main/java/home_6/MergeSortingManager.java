package home_6;

import java.io.*;

import static home_6.FileManager.createNewFile;
import static home_6.FileManager.getFullFilePath;

public class MergeSortingManager {

    public void sortLargeFile(String fileName, int sizeOfSingleNumber, int arrayChunkLength) {
        long fileSize = FileManager.getFileSize(fileName);

        int rightIndex = (int) fileSize / sizeOfSingleNumber;
        sortArrayInLargeFile(fileName, 0, rightIndex, rightIndex, arrayChunkLength, "hw6.out");
    }

    public void sortArrayInLargeFile(String largeFile, int left, int right, int length, int arrayChunkLength,String fileName) {
        int middle = (right - left) / 2;
        if (length < arrayChunkLength) {
            int[] tempArray = FileManager.getArrayFromFile(largeFile, left, right);
            new MergeSort().mergeSort(tempArray, tempArray.length);
//            new HeapSort().sort(tempArray);
            FileManager.putArrayToTempFile(tempArray, fileName);
            return;
        }

        String leftFileName = String.format("temp%ssorted_%s_%s", File.separator, left, left + middle);
        sortArrayInLargeFile(largeFile, left, left + middle, middle, arrayChunkLength, leftFileName);

        String rightFileName = String.format("temp%ssorted_%s_%s", File.separator, right - middle - length % 2, right);
        sortArrayInLargeFile(largeFile, right - middle - length % 2, right, right - middle - left, arrayChunkLength, rightFileName);

        merge(leftFileName, rightFileName, createNewFile(fileName));
    }

    private void merge(String leftFileName, String rightFileName, String mergedFileName) {
        DataInputStream dataInputStreamLeft;
        DataInputStream dataInputStreamRight;
        DataOutputStream dataOutputStream;

        int leftShort;
        int rightShort;
        String leftFilePath = getFullFilePath(leftFileName);
        String rightFilePath = getFullFilePath(rightFileName);
        try {
            dataInputStreamLeft = new DataInputStream(new FileInputStream(leftFilePath));

            dataInputStreamRight = new DataInputStream(new FileInputStream(rightFilePath));

            dataOutputStream = new DataOutputStream(new FileOutputStream(mergedFileName));

            leftShort = Short.toUnsignedInt(dataInputStreamLeft.readShort());
            rightShort = Short.toUnsignedInt(dataInputStreamRight.readShort());
            while (true) {
                if (leftShort <= rightShort) {
                    dataOutputStream.writeShort(leftShort);
                    if (dataInputStreamLeft.available() > 0) {
                        leftShort = Short.toUnsignedInt(dataInputStreamLeft.readShort());
                    } else {
                        dataOutputStream.writeShort(leftShort);
                        break;
                    }
                } else {
                    dataOutputStream.writeShort(rightShort);
                    if (dataInputStreamRight.available() > 0) {
                        rightShort = Short.toUnsignedInt(dataInputStreamRight.readShort());
                    } else {
                        dataOutputStream.writeShort(leftShort);
                        break;
                    }
                }
            }

            while (dataInputStreamRight.available() > 0) {
                dataOutputStream.writeShort(Short.toUnsignedInt(dataInputStreamRight.readShort()));
            }
            while (dataInputStreamLeft.available() > 0) {
                dataOutputStream.writeShort(Short.toUnsignedInt(dataInputStreamLeft.readShort()));
            }
            dataInputStreamLeft.close();
            dataInputStreamRight.close();
            dataOutputStream.flush();
            dataOutputStream.close();
            File leftFile = new File(leftFilePath);
            File rightFile = new File(rightFilePath);
            leftFile.delete();
            rightFile.delete();
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка при слиянии двух файлов");
        }
    }
}
