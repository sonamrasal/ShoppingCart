package com.retail.discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountSlab {

	private static final int NO_DISCOUNT = 0;

	public class PriceRange {
		public static final double NO_UPPER_LIMIT = -1;
		private double lower;
		private double higher;
		private double value;

		public PriceRange(double lower, double higher, double value) {
			this.lower = lower;
			this.higher = higher;
			this.value = value;
		}

		public boolean contains(double price) {
			return lower <= price && (higher >= price || higher == NO_UPPER_LIMIT);
		}

		public double get() {
			return value;
		}
	}

	private List<PriceRange> ranges = new ArrayList();

	public void add(double lower, double higher, double value) {
		ranges.add(new PriceRange(lower, higher, value));
	}

	public double getDiscountPercentFor(double price) {
		for (PriceRange range : ranges) {
			if (range.contains(price)) {
				return range.get();
			}
		}
		return NO_DISCOUNT;
	}

}
