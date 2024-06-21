package com.atguigu.gulimall.member.feign;

import com.atguigu.gulimall.common.utils.Result;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @GetMapping("/coupon/coupon/getCouponByMember")
    public Result getCouponByMember(@RequestParam("couponName") String couponName);

}
