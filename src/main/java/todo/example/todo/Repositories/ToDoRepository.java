package todo.example.todo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todo.example.todo.Models.ToDo;

import java.util.List;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo, String> {

    List<ToDo> findAllByUserId(String userId);

    ToDo findByTodoId(String todoId);
}
