package todo.example.todo.Services;

import todo.example.todo.Models.CreateRequests.UserCreateRequest;
import todo.example.todo.Models.User;

public interface UserService {

    User createUser(UserCreateRequest userCreateRequest);
    
    User getUserByPhoneNumber(String phoneNumber);

    User getUserById(String userId);


}
