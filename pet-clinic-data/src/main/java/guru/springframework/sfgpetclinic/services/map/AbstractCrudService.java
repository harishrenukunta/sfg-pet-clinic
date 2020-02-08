package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractCrudService<T, ID>  {

    protected Map<ID, T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<T>(map.values());
    }

    public T findById(ID id){
       return map.get(id);
    }

    public T save(ID id, T object){
        map.put(id, object);
        return object;
    }

    public T delete(T object){
        return map.remove(object);
    }
}
