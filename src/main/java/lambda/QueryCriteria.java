package lambda;

@FunctionalInterface
public interface QueryCriteria {
    boolean match(Employee employee);

    static QueryCriteria byName(String name) {
        return new NameQueryCriteria(name);
    }
}
