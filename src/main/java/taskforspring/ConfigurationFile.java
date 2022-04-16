package taskforspring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:file-configuration.properties")
@Data
public class ConfigurationFile {

    @Value("${path}")
    private String path;

    @Value("${extension}")
    private String extension;
}
