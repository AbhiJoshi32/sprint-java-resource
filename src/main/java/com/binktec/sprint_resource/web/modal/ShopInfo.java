package com.binktec.sprint_resource.web.modal;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shop_info")
public class ShopInfo{
    @Id
    private String username;
    @Column(name = "shop_name")
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String location;
    @OneToMany(mappedBy = "shopInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Price> prices;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }
}
