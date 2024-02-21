package org.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;

@Data
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class SpaceMarine implements Comparable<SpaceMarine> {
    public static int objCount = 0;
    private int id = ++objCount; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate = LocalDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long health; //Значение поля должно быть больше 0
    private boolean loyal;
    private AstartesCategory category; //Поле не может быть null
    private Weapon weaponType; //Поле может быть null
    private Chapter chapter; //Поле может быть null


    public SpaceMarine(String name, Coordinates coordinates, long health, boolean loyal, AstartesCategory category, Weapon weaponType, Chapter chapter) {
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.loyal = loyal;
        this.category = category;
        this.weaponType = weaponType;
        this.chapter = chapter;
    }

        @XmlElement(name = "creationDate")
        public String getCreationDate() {
                return creationDate.toString();
        }


        @Override
        public int compareTo(SpaceMarine o) {
                return this.id - o.id;
        }

        public static SpaceMarine createPracticeObject(){
                SpaceMarine sp = new SpaceMarine(
                        "The First",
                        new Coordinates(1L, 2.0),
                        23,
                        true,
                        AstartesCategory.HELIX,
                        Weapon.BOLT_RIFLE,
                        new Chapter("The first chapter", "Parents")
                );
            return sp;
        }

    @XmlTransient
    public int getId() {
        return id;
    }
}
