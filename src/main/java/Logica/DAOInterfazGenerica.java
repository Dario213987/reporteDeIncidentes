package Logica;

import java.util.List;

public interface DAOInterfazGenerica<T> {
    T getByID(int id);
    List<T> getAll();
    void save(T t);
    void saveAll(List<T> tList);
    void update(T t);
    void updateAll(List<T> tList);
    void delete(T t);
    void deleteAll(List<T> tList);

}
