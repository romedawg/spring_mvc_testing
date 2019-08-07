package com.romedawg.rome.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;

    public Owner(String name){
            this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
