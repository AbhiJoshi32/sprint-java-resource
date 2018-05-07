package com.binktec.sprint_resource.web.modal;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class ShopTransaction extends BaseEntity {
    @Column(name = "issue_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar issueTime;
    @Column(name = "printed_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar printedTime;
    @ManyToOne
    @JoinColumn(name = "username")
    private ShopInfo shopInfo;
    private String clientUsername;
    @ManyToOne
    @JoinColumn(name="service_id")
    private Service service_id;
    private int numberOfPages;
    private int price;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ShopTransaction(Calendar issueTime, Calendar printedTime, ShopInfo shopInfo, Service service_id, int numberOfPages, int price, PrintBinding printBinding) {
        this.issueTime = issueTime;
        this.printedTime = printedTime;
        this.shopInfo = shopInfo;
        this.service_id = service_id;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.printBinding = printBinding;
    }

    public PrintBinding getPrintBinding() {
        return printBinding;
    }

    public void setPrintBinding(PrintBinding printBinding) {
        this.printBinding = printBinding;
    }

    public ShopInfo getShopUsername() {
        return shopInfo;
    }

    public void setShopUsername(ShopInfo shopUsername) {
        this.shopInfo = shopUsername;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public Service getService_id() {
        return service_id;
    }

    public void setService_id(Service service_id) {
        this.service_id = service_id;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "binding_id")
    private PrintBinding printBinding;

    public Calendar getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Calendar issueTime) {
        this.issueTime = issueTime;
    }

    public Calendar getPrintedTime() {
        return printedTime;
    }

    public void setPrintedTime(Calendar printedTime) {
        this.printedTime = printedTime;
    }
}
