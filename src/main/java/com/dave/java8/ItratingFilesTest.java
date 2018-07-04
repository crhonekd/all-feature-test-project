package com.dave.java8;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by David on 19/03/2017.
 */
public class ItratingFilesTest {
    public static void main(String[] args) {
        String home = System.getProperty("user.dir");
        Path path = FileSystems.getDefault().getPath(home);

        try {
            Files.list(path)
                    .forEach(path1 -> path1.getFileName());

            Files.find(path, 10, (file, attr) -> file.endsWith("ItratingFilesTest.java"))
                    .forEach(path1 -> {
                        try {
                            Files.lines(path1).forEach(System.out::println);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
