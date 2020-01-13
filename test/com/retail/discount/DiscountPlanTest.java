package com.retail.discount;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscountPlanTest {
	private static final double PRECISION = 0.0;
	DiscountPlan plan;
	
	@Test
	public void regularPlanDiscounts() {
		plan = new Regular();
		assertEquals(0, plan.applyDiscount(1234), PRECISION);
		assertEquals(567.8, plan.applyDiscount(5678), PRECISION);
		assertEquals(2469, plan.applyDiscount(12345), PRECISION);
		assertEquals(0, plan.applyDiscount(0),PRECISION);
		assertEquals(0, plan.applyDiscount(5000), PRECISION);
		assertEquals(1000, plan.applyDiscount(10000), PRECISION);
	}
	
	@Test
	public void premiumPlanDiscounts() {
		plan = new Premium();
		assertEquals(0, plan.applyDiscount(0), PRECISION);
		assertEquals(400, plan.applyDiscount(4000), PRECISION);
		assertEquals(249.9, plan.applyDiscount(2499), PRECISION);
		assertEquals(832.8, plan.applyDiscount(5552), PRECISION);
		assertEquals(1200, plan.applyDiscount(8000), PRECISION);
		assertEquals(2400, plan.applyDiscount(12000), PRECISION);
		assertEquals(6000, plan.applyDiscount(20000), PRECISION);
	}

}
