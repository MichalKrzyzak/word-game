package com.myproject.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class FileParser {
    void gatherAllWords(List<Character> userChars) {

        try (Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\words.txt"))) {
            //TODO filter just string that contains some or all characters from list and not any other characters
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
