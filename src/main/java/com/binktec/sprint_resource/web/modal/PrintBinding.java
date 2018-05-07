package com.binktec.sprint_resource.web.modal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "binding")
public class PrintBinding extends NamedEntity{
    private int cost;

    public int getPrice() {
        return cost;
    }

    public void setPrice(int cost) {
        this.cost = cost;
    }
}
