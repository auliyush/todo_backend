package todo.example.todo.Repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todo.example.todo.Models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByPhoneNumber(String phoneNumber);

    User findByUserId(String userId);
}
