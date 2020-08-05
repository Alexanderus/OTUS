package home_1.testing;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<Path> getTestData(String path, String postfix) {
        List<Path> inPaths = null;
        try (Stream<Path> paths = Files.walk(Paths.get(ClassLoader.getSystemResource(path).toURI()))) {
            inPaths = paths
                    .filter(Files::isRegularFile)
                    .filter(e -> e.toString().endsWith(postfix))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return inPaths;
    }
}
