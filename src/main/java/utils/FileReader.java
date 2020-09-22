package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static List<Path> getTestFiles(String pathToFolder, String postfix) {
        List<Path> inPaths = null;
        try (Stream<Path> paths = Files.walk(Paths.get(ClassLoader.getSystemClassLoader().getResource(pathToFolder).toURI()))) {
            inPaths = paths
                    .sorted()
                    .filter(Files::isRegularFile)
                    .filter(e -> e.toString().endsWith(postfix))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return inPaths;
    }

    public static String getTestData(Path pathToTest) {
        try {
            return Files.readString(pathToTest);
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
