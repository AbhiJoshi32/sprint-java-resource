package com.binktec.sprint_resource.web.modal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "username")
    private ShopInfo shopInfo;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public ShopInfo getShopInfo() {
        return shopInfo;
    }

    public void setShopInfo(ShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    private float cost;
}
