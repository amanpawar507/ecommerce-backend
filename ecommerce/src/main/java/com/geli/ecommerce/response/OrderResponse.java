package com.geli.ecommerce.response;

import com.geli.ecommerce.model.Address;
import com.geli.ecommerce.model.CreditCard;
import com.geli.ecommerce.model.OrderItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderResponse {

    private int orderId;
    private List<OrderItem> orderItemList = new ArrayList<>();

    private double totalPrice;
    private Address shippingAddress;
    private CreditCard creditCardUsed;
    private Date dateCreated;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public CreditCard getCreditCardUsed() {
        return creditCardUsed;
    }

    public void setCreditCardUsed(CreditCard creditCardUsed) {
        this.creditCardUsed = creditCardUsed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
