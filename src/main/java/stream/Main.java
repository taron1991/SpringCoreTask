package stream;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student nikita = Student.builder()
                .name("Никита")
                .age(22)
                .lessons(
                        List.of(
                           new Lesson("Математика", 1),
                           new Lesson("Литература", 2),
                           new Lesson("Русский язык", 4),
                           new Lesson("Физкультура", 3)
                        )
                )
                .build();

        Student zaur = Student.builder()
                .name("Заур")
                .age(20)
                .lessons(
                        List.of(
                                new Lesson("Математика", 3),
                                new Lesson("Литература", 1),
                                new Lesson("Русский язык", 2),
                                new Lesson("Физкультура", 4)
                        )
                )
                .build();

        Student polina = Student.builder()
                .name("Полина")
                .age(23)
                .lessons(
                        List.of(
                                new Lesson("Философия", 3),
                                new Lesson("Английский язык", 5),
                                new Lesson("Русский язык", 1),
                                new Lesson("Психология", 2),
                                new Lesson("Обществознание", 4)
                        )
                )
                .build();


        Sheduled.collectTable(List.of(nikita, zaur, polina))
                .entrySet()
                .stream()
                .map(entry -> String.format("Name : %s | TableLessons: %s\n", entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
