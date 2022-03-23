package com.shoppingcart.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.org.model.Coupon;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

	void deleteByCode(String code);

}
