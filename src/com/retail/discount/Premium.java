package com.retail.discount;

import static com.retail.discount.DiscountSlab.NO_UPPER_LIMIT;

public class Premium extends DiscountPlan {
	
	public Premium() {
		baseSlab = new DiscountSlab(0, 4000, 10, 
				new DiscountSlab(4000, 8000, 15, 
						new DiscountSlab(8000, 12000, 20, 
								new DiscountSlab(12000, NO_UPPER_LIMIT, 30, null))));
	}
}
