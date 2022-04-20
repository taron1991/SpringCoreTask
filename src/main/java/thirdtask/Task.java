package thirdtask;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * На вход идет строка статусов
 * Задача: найти все успешные статусы и собрать их в итоговый список
 * Примечание: статус считается успешным, если его код лежит в диапазоне от 200 до 208 или равен 226
 */
public class Task {

    /**
     * @param logRequests строка статусов
     * @return
     */
    public List<ResponseSuccess> collect(String logRequests) {
        return List.of();
    }

    private boolean isEmpty(String string) {
        return Objects.isNull(string) || Objects.equals(string.length(), 0);
    }
}
