package com.lin.exception;
/*
 * 购物车异常提醒
 * */
public class ShopCartException extends RuntimeException {
	public ShopCartException() {}
	public ShopCartException(String message) {
        super(message);
    }

    public ShopCartException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopCartException(Throwable cause) {
        super(cause);
    }

    public ShopCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
