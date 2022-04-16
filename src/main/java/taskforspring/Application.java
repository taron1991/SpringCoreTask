package taskforspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        User firstUser = new User(1, "Никита");
        User secondUser = new User(2, "Иван");
        User thirdUser = new User(3, "Георгий");
        User exUser = null; // косячный пользователь, чтобы залогировалось ошибка.

        storeService.add(firstUser);
        storeService.add(secondUser);
        storeService.add(thirdUser);

        secondUser.setName("Заменили Ивана на Арсения");
        storeService.update(secondUser);

        storeService.delete(thirdUser);

        storeService.delete(exUser);

        // Создаем файл с логами типа, который захотим.
        sendInformationService.sendLog(TypeOfMessage.ERROR);
    }
}
