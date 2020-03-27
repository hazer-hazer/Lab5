package comps;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDateTime;

@JsonAutoDetect
public class HumanBeingDTO {

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    private String name; //Поле не может быть null, Строка не может быть пустой

    @JsonDeserialize(as = Coordinates.class)
    private Coordinates coordinates; //Поле не может быть null

    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private boolean realHero;

    private boolean hasToothpick;

    private float impactSpeed;

    private String soundtrackName; //Поле не может быть null

    private float minutesOfWaiting;

    private Mood mood; //Поле может быть null

    @JsonDeserialize(as = Car.class)
    private Car car; //Поле не может быть null

    public HumanBeingDTO(){}

    public HumanBeingDTO(@NotNull HumanBeing hb){
        id = hb.getId();
        name = hb.getName();
        coordinates = hb.getCoordinates();
        LocalDateTime creationDateHb = hb.getCreationDate();
        creationDate = creationDateHb != null ? creationDateHb : LocalDateTime.now();
        realHero = hb.getRealHero();
        hasToothpick = hb.getHasToothpick();
        impactSpeed = hb.getImpactSpeed();
        soundtrackName = hb.getSoundtrackName();
        minutesOfWaiting = hb.getMinutesOfWaiting();
        mood = hb.getMood();
        car = hb.getCar();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(@NotNull String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(@NotNull Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCreationDate() {
        return creationDate.toString();
    }
    public void setCreationDate(@NotNull String creationDate) {
        this.creationDate = LocalDateTime.parse(creationDate);
    }

    public boolean getRealHero(){
        return realHero;
    }
    public void setRealHero(boolean realHero){
        this.realHero = realHero;
    }

    public boolean getHasToothpick(){
        return hasToothpick;
    }
    public void setHasToothpick(boolean hasToothpick){
        this.hasToothpick = hasToothpick;
    }

    public float getImpactSpeed(){
        return impactSpeed;
    }
    public void setImpactSpeed(float impactSpeed){
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName(){
        return soundtrackName;
    }
    public void setSoundtrackName(@NotNull String soundtrackName){
        this.soundtrackName = soundtrackName;
    }

    public float getMinutesOfWaiting(){
        return minutesOfWaiting;
    }
    public void setMinutesOfWaiting(float minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Mood getMood(){
        return mood;
    }
    public void setMood(@NotNull Mood mood){
        this.mood = mood;
    }

    public Car getCar(){
        return car;
    }
    public void setCar(@NotNull Car car){
        this.car = car;
    }

    public void validateFields(){
    }

    @JsonIgnore
    public HumanBeing toHumanBeing(){
        return new HumanBeing(id,
                name,
                coordinates,
                creationDate,
                realHero,
                hasToothpick,
                impactSpeed,
                soundtrackName,
                minutesOfWaiting,
                mood,
                car);
    }

}