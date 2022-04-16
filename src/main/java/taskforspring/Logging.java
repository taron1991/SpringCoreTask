package taskforspring;

import java.util.function.Predicate;

public interface Logging<T> {
    public void sendLog(T t);
}
