package taskforspring;

import java.util.ArrayList;
import java.util.List;

public class StatisticService {

    private final List<Pair<String, TypeOfMessage>> statisticLogs = new ArrayList<>();

    /**
     * Данный метод записывает статистику по успешным событиям
     */
    public void writeSuccessEvent(MessageSuccess success) {
        Pair<String, TypeOfMessage> pair = new Pair<>(success.name(), TypeOfMessage.SUCCESS);
        statisticLogs.add(pair);
    }

    /**
     * Данный метод записывает статистику по неуспешным событиям.
     */
    public void writeErrorEvent(MessageErrors errors) {
        Pair<String, TypeOfMessage> pair = new Pair<>(errors.name(), TypeOfMessage.ERROR);
        statisticLogs.add(pair);
    }


    /**
     * Данный метод возвращает собранную статистику
     */
    public List<Pair<String, TypeOfMessage>> getStatistic() {
        return statisticLogs;
    }
}
