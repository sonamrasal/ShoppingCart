package com.retail.cart;

import com.retail.discount.DiscountPlan;

public class ShoppingCart {

	private final DiscountPlan plan;
	private final double basePrice;

	public ShoppingCart(DiscountPlan plan, double basePrice) {
		this.plan = plan;
		this.basePrice = basePrice;
	}

	public double bill() {
		double discountAmount = plan.applyDiscount(basePrice);
		return basePrice - discountAmount;
	}

}
