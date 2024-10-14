package hospital.interfaces;

public interface CrudOperations<T> {
    void create(T item);
    T read(String name);
    void update(String name, T newItem);
    void delete(String name);
}
