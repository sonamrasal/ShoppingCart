package com.retail.discount;

public class Default extends DiscountPlan {

	@Override
	public double applyDiscount(double basePrice) {
		return basePrice;
	}

}
