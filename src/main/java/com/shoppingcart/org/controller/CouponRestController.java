package com.shoppingcart.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.org.model.Coupon;
import com.shoppingcart.org.repository.CouponJpaRepository;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	@Autowired
	private CouponJpaRepository couponJpaRepository;
	
	@RequestMapping(value = "/coupons", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {
		return couponJpaRepository.save(coupon);
	}
	
	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponJpaRepository.findByCode(code);
	}
	
	@RequestMapping(value = "/coupons", method = RequestMethod.GET)
	public List<Coupon> getAllCoupons(){
		return couponJpaRepository.findAll();
	}
	
	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.DELETE)
	public String deleteCoupon(@PathVariable("code") String code) {
		Coupon coupon = couponJpaRepository.findByCode(code);
		if(coupon == null) {
			throw new RuntimeException("Coupon code not found - " + code);
		}
		couponJpaRepository.deleteById(coupon.getId());
		return "Deleted Coupon code - " + code;
	}
}
