package org.example.core;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.SpaceMarine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

/**
 * this class manages the creation and interaction with space-marine objects
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "SpaceMarines")
@JacksonXmlRootElement(localName = "CollectionManager")
public class CollectionManager {
    @JacksonXmlProperty(localName = "spaceMarine")

    private PriorityQueue<SpaceMarine> priorityQueue = new PriorityQueue<>();
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime creationDate = LocalDateTime.now();

    //@XmlAnyElement(lax = true)
    @XmlElement(name = "spaceMarine")
    public PriorityQueue<SpaceMarine> getPriorityQueue() {
        return priorityQueue;
    }

    public void add(SpaceMarine sp) {
        this.getPriorityQueue().add(sp);
    }

    public void show() {
        this.getPriorityQueue().forEach(
                s -> System.out.println(s.toString())
        );
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public void clear() {
        this.getPriorityQueue().clear();
    }

    public void updateById(SpaceMarine spaceMarine, int id) {
        SpaceMarine sp = findById(id);
        try {
            sp.setChapter(spaceMarine.getChapter());
            sp.setCategory(spaceMarine.getCategory());
            sp.setHealth(spaceMarine.getHealth());
            sp.setLoyal(spaceMarine.isLoyal());
            sp.setWeaponType(spaceMarine.getWeaponType());
            sp.setName(spaceMarine.getName());
            sp.setCoordinates(spaceMarine.getCoordinates());
        } catch (NullPointerException e) {
            System.out.println("No such space marine");
        }

    }


    public SpaceMarine findById(int id) {
        for (SpaceMarine sp : this.getPriorityQueue()) {
            if (sp.getId() == id) {
                return sp;
            }
        }

        System.out.printf("No spacemarine with id %d in list\n", id);
        return null;
    }

    public boolean removeById(int id) {
        for (SpaceMarine sp : this.getPriorityQueue()) {
            if (sp.getId() == id) {
                this.getPriorityQueue().removeIf(s -> s.getId() == id);
                return true;
            }
        }

        System.out.printf("No spacemarine with id %d in list", id);
        System.out.println();
        return false;
    }
}
