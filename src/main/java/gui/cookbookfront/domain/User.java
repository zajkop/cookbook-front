package gui.cookbookfront.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Getter
    private int id;
    private String login;
    private String password;

    @Getter
    private List<String> meals;
}
