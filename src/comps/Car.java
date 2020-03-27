package comps;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String name; //Поле может быть null

    public Car(@JsonProperty("name") String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Car ("+ name +")";
    }
}
