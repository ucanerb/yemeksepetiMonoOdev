package com.caner.yemeksepeti.constant;

public class EndPointList {
    public static final String PREF = "/dev";
    public static final String VERSIONS = "/v1";

    public static final String CUSTOMER = "/customer";
    public static final String REGISTER = "/register";
    public static final String SAVE = "/save";
    public static final String LOGIN="/login";
    public static final String RESTAURANT="/restaurant";
    public static final String PRODUCT="/product";
    public static final String ORDER="/order";
    public static final String UPDATE="/update";
    public static final String DELETE_BY_ID="/delete-by-id";
    public static final String FIND_BY_ID="/find-by-id";
    public static final String FIND_ALL="/find-all";
    public static final String ACTIVATE_STATUS="/activate-status";

    public static final String FIND_ALL_ORDER_BY_CUSTOMERID = "/find-all-order-by-customer-id/{customerId}";
    public static final String FIND_ALL_ORDER_BY_RESTAURANTID = "/find-all-order-by-restaurant-id/{restaurantId}";
    public static final String FIND_ALL_PRODUCT_BY_RESTAURANTID = "/find-all-product-by-restaurant-id/{restaurantId}";
}
