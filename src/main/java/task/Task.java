package task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task {

    public int sum() {
        IntStream stream = IntStream.range(1, 30);
        return stream.sum();
    }

    public long countNegative() {
        IntStream stream = IntStream.range(-10, 10);
        return stream.filter(num -> num<0).count();
    }

    public long longestWord() {
        List<String> words = List.of("alma", "körte","szilva", "barack", "dió", "szőlő", "sárga dinnye");
        return words.stream().max(Comparator.comparingInt(String::length)).get().length();
    }

    public boolean allOdds() {
        IntStream stream = IntStream.range(1, 10);
        return stream.anyMatch(x -> x % 2 != 0);
    }

    public List<String> allEmployees() {
        List<Employee> employeeList = List.of(new Employee("John", 110000),
                new Employee("Mike", 105000),
                new Employee("Jockey", 115000));
        return employeeList
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }


    public List<Employee> moreThen() {
        List<Employee> employeeList = List.of(new Employee("John", 110000),
                new Employee("Mike", 95000),
                new Employee("Jockey", 115000));
        return employeeList
                .stream()
                .filter(emp -> emp.getSalary()>100000).toList();
    }

    public List<String> flatMap() {
        List<String> names = List.of("John Doe", "John Doe Junior Jack");
        return names.stream()
                .flatMap(s -> (Arrays.stream(s.split(" "))))
                .distinct()
                .toList();
    }

    public List<String> getMiddleNames(List<String> names) {
        return names.stream().flatMap(name -> getMiddleName(name).stream()).toList();
    }

    public static Optional<String> getMiddleName(String name) {
        String[] parts = name.split(" ");
        if (parts.length==3) {
            return Optional.of(parts[1]);
        }
        return Optional.empty();
    }



    public static void main(String[] args) {
        Task t = new Task();
        System.out.println(t.sum());
        System.out.println(t.countNegative());
        System.out.println(t.longestWord());
        System.out.println(t.allOdds());
        for (String s: t.allEmployees()) {
            System.out.println(s);
        }

        for (Employee emp: t.moreThen()) {
            System.out.println(emp);
        }

        for (String s: t.flatMap()) {
            System.out.println(s);
        }

        List<String> names = List.of("Aaaa Bbbb CCC", "John Doe", "Jack Doe", "Agre ewr ewrw");
        List<String> middleNames = t.getMiddleNames(names);
        for (String s: middleNames) {
            System.out.println(s);
        }

        try (var lines = Files.lines(Path.of("C:/Users/Training/IdeaProjects/java-se8-2022-06-20/index.html"))) {
            long count = lines.filter(s -> s.contains("Putyin"))
                    .peek(System.out::println)
                    .count();
            System.out.println("Count: "+ count);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }

}
