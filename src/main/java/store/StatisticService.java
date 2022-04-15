package store;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class StatisticService {

    public int changes() {
        return 5;
    }
}
