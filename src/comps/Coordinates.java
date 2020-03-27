package comps;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

@JsonAutoDetect
public class Coordinates {
    private Integer x; //Максимальное значение поля: 319, Поле не может быть null
    private Integer y; //Поле не может быть null

    @JsonCreator
    public Coordinates(
            @JsonProperty("x") Integer x,
            @JsonProperty("y") Integer y){
        this.x = x;
        this.y = y;
    }

    public boolean greaterThan(Coordinates coords){
        return x > coords.x && y > coords.y;
    }

    public Integer getX(){
        return x;
    }

    public void setX(@NotNull Integer x){
        this.x = x;
    }

    public Integer getY(){
        return y;
    }

    public void setY(@NotNull Integer y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "x: " + x + "; y: " + y;
    }
}