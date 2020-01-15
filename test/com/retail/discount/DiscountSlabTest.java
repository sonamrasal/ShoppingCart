package com.retail.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import static com.retail.discount.DiscountSlab.NO_UPPER_LIMIT;

public class DiscountSlabTest {

	private static final double PRECISION = 0.0;

	@Test
	public void slabHasLowerAndUpperRange() {
		DiscountSlab slabWithBothLimits = new DiscountSlab(1000, 1400, 10, null);
		assertEquals(400, slabWithBothLimits.difference(), PRECISION);
	}

	@Test
	public void slabHasNoUpperLimit() {
		DiscountSlab slabWithNoUpperLimit = new DiscountSlab(10000, NO_UPPER_LIMIT, 20, null);
		assertEquals(Integer.MAX_VALUE - 10000, slabWithNoUpperLimit.difference(), PRECISION);
	}

	@Test
	public void nextSlabInChainRequested() {
		DiscountSlab slab = new DiscountSlab(100, 2000, 10, null);
		assertNull(slab.nextSlab());
		DiscountSlab nextSlab = new DiscountSlab(2500, 3000, 15, null);
		slab.next(nextSlab);
		assertEquals(nextSlab, slab.nextSlab());
	}

	@Test
	public void applyDiscountToPriceAsPerSlab() {
		DiscountSlab slab = new DiscountSlab(1000, 3000, 20, null);
		assertEquals(1039.2, slab.applyDiscount(1299), PRECISION);
	}
}
