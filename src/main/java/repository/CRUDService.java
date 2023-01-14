package repository;

import java.util.List;
import java.util.UUID;

public interface CRUDService<Entity> {

    Entity getById(UUID id);

    List<Entity> getAll();

    void create(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

}
