package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID extends Long> {
    Set<T> findAll();
    T save(T entity);
    T findById(ID id);
    T delete(T object);
}
