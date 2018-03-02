package com.preorder.dao;

import java.util.List;

import com.preorder.beans.Orderdetails;

public interface OrderdetailsDao {
    public  List<Orderdetails> getOrderdetails(Integer preorderID) ;

}
