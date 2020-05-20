package com.dumbao.limit;

import com.google.common.util.concurrent.RateLimiter;

public class LimitDemo {
    public static void main(String[] args) {
        RateLimiter rateLimiter =  RateLimiter.create(5);
    }
}
