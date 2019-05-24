package com.myproject.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class FileParser {
    void gatherAllWords(List<String> userLetters) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\words.txt"))) {
            String word = bufferedReader.readLine();
            while (word != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        try (Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\words.txt"))) {
//            stream.filter()
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
