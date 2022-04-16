package taskforspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SendInformationService implements Logging<TypeOfMessage> {

    private final StatisticService statisticService;
    private final ConfigurationFile configurationFile;

    public void sendInformation(Predicate<TypeOfMessage> predicate) {
        String result = statisticService.getStatistic()
                .stream()
                .filter(element -> predicate.test(element.getSecondElement()))
                .map(Pair::getFirstElement)
                .collect(Collectors.joining("\n"));

        try {
            createLogFile(configurationFile.getPath(), configurationFile.getExtension(), result);
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл");
        }
    }

    @Override
    public void sendLog(TypeOfMessage typeOfMessage) {
        sendInformation(typeOfMessage::equals);
    }

    private void createLogFile(String path, String extension, String text) throws IOException {
        StringJoiner nameFile = new StringJoiner(Constants.EMPTY).add(path).add(extension);
        Path name = Paths.get(nameFile.toString());
        Files.write(name, text.getBytes());
    }
}
