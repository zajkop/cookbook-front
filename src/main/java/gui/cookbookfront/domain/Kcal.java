package gui.cookbookfront.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Kcal implements Serializable {

    private int id;
    private String value;
    private String b;
    private String t;
    private String w;

    @Override
    public String toString() {
        return "Kalorie: " + value + ", bialko: " + b + ", tluszcze: " + t + ", weglowodany: " + w;
    }
}
