package com.retail.discount;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.retail.discount.DiscountSlab.PriceRange;

public class DiscountSlabTest {

	DiscountSlab slabs = new DiscountSlab();

	private static final double PRECISION = 0.0;

	@Before
	public void addDiscountSlabs() {
		slabs.add(0, 5000, 0);
		slabs.add(5000, 10000, 10);
		slabs.add(10000, PriceRange.NO_UPPER_LIMIT, 20);
	}

	@Test
	public void amountUptoFiveThousandEligibleForZeroDiscount() {
		assertEquals(0, slabs.getDiscountPercentFor(0), PRECISION);
		assertEquals(0, slabs.getDiscountPercentFor(5000), PRECISION);
		assertEquals(0, slabs.getDiscountPercentFor(3999), PRECISION);
	}

	@Test
	public void amountBetweenFiveAndTenThousandEligibleForTenPercentDiscount() {
		assertEquals(10, slabs.getDiscountPercentFor(5000.1), PRECISION);
		assertEquals(10, slabs.getDiscountPercentFor(6326.99), PRECISION);
		assertEquals(10, slabs.getDiscountPercentFor(10000), PRECISION);
	}

	@Test
	public void amountBeyondTenThousandEligibleForTwentyPercentDiscount() {
		assertEquals(20, slabs.getDiscountPercentFor(12000), PRECISION);
		assertEquals(20, slabs.getDiscountPercentFor(10000.001), PRECISION);
	}

}
