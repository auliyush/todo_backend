package todo.example.todo.Models.CreateRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ToDoCreateRequest {
    private String userId;
    private String todo;
}
