package com.retail.discount;

import static com.retail.discount.DiscountSlab.PriceRange.NO_UPPER_LIMIT;

public class Regular extends DiscountPlan {

	public Regular() {
		slabs = new DiscountSlab();
		slabs.add(0, 5000, 0);
		slabs.add(5000, 10000, 10);
		slabs.add(10000, NO_UPPER_LIMIT, 20);
	}
}
