package taskforspring;

import lombok.Getter;
import lombok.Setter;

public final class Pair<T, K> {
    private T t;
    private K k;

    public Pair(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getFirstElement() {
        return t;
    }

    public K getSecondElement() {
        return k;
    }
}
