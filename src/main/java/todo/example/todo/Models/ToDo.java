package todo.example.todo.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "todo")
@NoArgsConstructor
public class ToDo {
    @Id
    private String todoId;
    private String todo;
    private String userId;
    private boolean isActive;
    private boolean isComplete;

}
