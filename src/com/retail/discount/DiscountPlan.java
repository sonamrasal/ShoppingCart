package com.retail.discount;

public abstract class DiscountPlan {

	protected DiscountSlab slabs;

	public double applyDiscount(double basePrice) {
		return (slabs.getDiscountPercentFor(basePrice) * basePrice) / 100;
	}

}
