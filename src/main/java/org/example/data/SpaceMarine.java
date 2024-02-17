package org.example.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Data
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class SpaceMarine implements  Comparable<SpaceMarine>{
        private static int objCount = 0;
        private int id = ++objCount; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        @NotNull
        @NotBlank
        @JacksonXmlProperty(localName = "name")
        private String name; //Поле не может быть null, Строка не может быть пустой
        @NotNull
        private Coordinates coordinates; //Поле не может быть null
        @NotNull
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        //@JacksonXmlProperty(localName = "creationDate")
        private LocalDateTime creationDate = LocalDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        @Min(value = 1)
        private long health; //Значение поля должно быть больше 0
        private boolean loyal;
       @NotNull
        private AstartesCategory category; //Поле не может быть null
        @NotNull
        private Weapon weaponType; //Поле может быть null
        @NotNull
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

}
