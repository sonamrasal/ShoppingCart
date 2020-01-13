package com.retail.discount;

import static com.retail.discount.DiscountSlab.PriceRange.NO_UPPER_LIMIT;

public class Premium extends DiscountPlan {
	public Premium() {
		slabs = new DiscountSlab();
		slabs.add(0, 4000, 10);
		slabs.add(4000, 8000, 15);
		slabs.add(8000, 12000, 20);
		slabs.add(12000, NO_UPPER_LIMIT, 30);
	}
}
