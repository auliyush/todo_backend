package todo.example.todo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.example.todo.Models.CreateRequests.UserCreateRequest;
import todo.example.todo.Models.User;
import todo.example.todo.Repositories.UserRepository;
import todo.example.todo.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        if (getUserByPhoneNumber(userCreateRequest.getPhoneNumber()) != null) {
            return null;
        }
        User user = new User();
        user.setUserName(userCreateRequest.getUserName());
        user.setPhoneNumber(userCreateRequest.getPhoneNumber());
        user.setPassword(userCreateRequest.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }
}
