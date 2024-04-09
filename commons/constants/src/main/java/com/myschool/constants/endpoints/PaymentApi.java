package com.myschool.constants.endpoints;

public class PaymentApi {
    private PaymentApi() {}

    public static final String ADD_EXPENSE = "/payment/addExpense";
    public static final String GET_EXPENSE = "/payment/getExpense/{id}";
    public static final String UPDATE_EXPENSE = "/payment/getExpense/{id}";

    public static final String ADD_FEES_PAYMENT = "/payment/recordFeesPayment";
    public static final String GET_FEES_PAYMENT = "/payment/getFeesRecord";
    public static final String UPDATE_FEES_PAYMENT = "/payment/getFeesRecord";

    public static final String ADD_SALARY_PAID = "/payment/recordSalaryPayment";
    public static final String GET_SALARY_PAID = "/payment/getSalaryRecord";
    public static final String UPDATE_SALARY_PAID = "/payment/getSalaryRecord";

}
