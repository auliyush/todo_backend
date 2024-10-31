package todo.example.todo.Models.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreateRequest {
    private String userName;
    private String phoneNumber;
    private String password;
}
