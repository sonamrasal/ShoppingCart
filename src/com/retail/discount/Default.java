package com.retail.discount;

public class Default extends DiscountPlan {

	@Override
	public double applyDiscountTo(double basePrice) {
		return basePrice;
	}

}
