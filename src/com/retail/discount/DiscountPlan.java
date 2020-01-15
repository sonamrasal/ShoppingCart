package com.retail.discount;

public abstract class DiscountPlan {

	protected DiscountSlab baseSlab;

	public double applyDiscountTo(double price) {
		double discountedPrice = 0;
		DiscountSlab slab = baseSlab;
		while (price > 0) {
			discountedPrice += slab.applyDiscount(price);
			price = price - slab.difference();
			slab = slab.nextSlab();
		}
		return discountedPrice;
	}
}
