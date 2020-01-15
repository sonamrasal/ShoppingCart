package com.retail.discount;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscountPlanTest {
	private static final double PRECISION = 0.0;
	DiscountPlan plan;

	@Test
	public void regularPlanDiscounts() {
		plan = new Regular();
		assertEquals(0, plan.applyDiscountTo(0), PRECISION);
		assertEquals(1234, plan.applyDiscountTo(1234), PRECISION);
		assertEquals(5610.2, plan.applyDiscountTo(5678), PRECISION);
		assertEquals(11376, plan.applyDiscountTo(12345), PRECISION);

		assertEquals(5000, plan.applyDiscountTo(5000), PRECISION);
		assertEquals(9500, plan.applyDiscountTo(10000), PRECISION);
		assertEquals(13500, plan.applyDiscountTo(15000), PRECISION);
	}

	@Test
	public void premiumPlanDiscounts() {
		plan = new Premium();

		assertEquals(0, plan.applyDiscountTo(0), PRECISION);
		assertEquals(2249.1, plan.applyDiscountTo(2499), PRECISION);
		assertEquals(4919.2, plan.applyDiscountTo(5552), PRECISION);

		assertEquals(3600, plan.applyDiscountTo(4000), PRECISION);
		assertEquals(7000, plan.applyDiscountTo(8000), PRECISION);
		assertEquals(10200, plan.applyDiscountTo(12000), PRECISION);
		assertEquals(15800, plan.applyDiscountTo(20000), PRECISION);
	}

}
