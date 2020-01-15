package com.retail.discount;

public class Regular extends DiscountPlan {

	public Regular() {
		baseSlab = new DiscountSlab(0, 5000, 0,
				new DiscountSlab(5000, 10000, 10, 
						new DiscountSlab(10000, DiscountSlab.NO_UPPER_LIMIT, 20, 
								null)));
	}
}
