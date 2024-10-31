package todo.example.todo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todo.example.todo.Models.Response.LoginResponse;
@Repository
public interface LoginResponseRepository extends MongoRepository<LoginResponse, String> {

}
