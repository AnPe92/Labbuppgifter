package uppgift1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Person{
    private String name;
    private String gender;
    private double salary;

    public Person(String name, String gender, double salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class Main {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Kalle", "Male", 32000),
                new Person("Stina", "Female", 31000),
                new Person("Lisa", "Female", 37500),
                new Person("Fredrik", "Male", 42300),
                new Person("Oscar", "Male", 29550),
                new Person("Ove", "Male", 31750),
                new Person("Anna", "Female", 31600),
                new Person("Gunnar", "Male", 48200),
                new Person("Gun-hilda", "Female", 33000),
                new Person("Gustav", "Male", 32900)
        ) ;


        // 1.1


        double femaleAverageSalary = persons
                .stream()
                .filter(x -> x.getGender().equals("Female"))
                .mapToDouble(Person::getSalary)
                .summaryStatistics()
                .getAverage();

        double maleAverageSalary = persons
                .stream()
                .filter(x -> x.getGender().equals("Male"))
                .mapToDouble(Person::getSalary)
                .summaryStatistics()
                .getAverage();

        System.out.println("Kvinnliga snittlönen är: " + femaleAverageSalary + "\nManliga snittlönen är: " +maleAverageSalary);

        // 1.2 & 1.3


        //Om man bara vill spara namnen på de som har högst respektive lägst lönen
        String highestSalary = persons
                .stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(1)
                .map(Person::getName)
                .collect(Collectors.joining(""));



        System.out.println("Högsta lönen har: " + highestSalary);

        String lowestSalary = persons
                .stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .limit(1)
                .map(Person::getName)
                .collect(Collectors.joining(""));

        System.out.println("Lägsta lönen har: " + lowestSalary);

        //Om man vill spara hela objectet i en lista

        List<Person> highestSalaryObj = persons
                .stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(highestSalaryObj);

        List<Person> lowestSalaryObj = persons
                .stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(lowestSalaryObj);


    }
}
