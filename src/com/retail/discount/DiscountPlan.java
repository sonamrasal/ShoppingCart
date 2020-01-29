package com.retail.discount;

public abstract class DiscountPlan {

	protected DiscountSlab baseSlab;

	public double applyDiscountTo(double price) {
		double discountedPrice = 0;
		DiscountSlab slab = baseSlab;
		while (price > 0) {
			discountedPrice += slab.applyDiscount(price);
			price = price - slab.difference();
			slab = slab.next();
		}
		return discountedPrice;
	}

	public void addSlab(DiscountSlab slab) {
		DiscountSlab current = baseSlab;
		while (Boolean.TRUE) {
			if (slab.isWithinRangeOf(current)) {
				current.adjustWith(slab);
				slab.next(current.next());
				current.next(slab);
				break;
			} else {
				current = current.next();
			}
		}
	}
}
