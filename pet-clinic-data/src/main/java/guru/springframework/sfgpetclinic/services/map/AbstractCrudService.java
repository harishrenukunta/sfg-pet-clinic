package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractCrudService<T extends BaseEntity, ID extends Long>  {

    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll(){
        return new HashSet<T>(map.values());
    }

    public T findById(ID id){
       return map.get(id);
    }

    public T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
                map.put(object.getId(), object);
            }
        }
        return object;
    }

    public T delete(T object){
        return map.remove(object);
    }

    public Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }catch(NoSuchElementException ex){
            nextId = 2L;
        }
        return nextId;
    }
}
