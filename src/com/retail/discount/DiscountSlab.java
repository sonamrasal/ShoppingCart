package com.retail.discount;

public class DiscountSlab {

	public static final double NO_UPPER_LIMIT = -1;
	private final double lower;
	private double upper;
	private double value;
	private DiscountSlab next;

	public DiscountSlab(double lower, double upper, double value, DiscountSlab next) {
		this.lower = lower;
		this.upper = upper;
		this.value = value;
		this.next = next;
	}

	public double difference() {
		return upper == NO_UPPER_LIMIT ? Integer.MAX_VALUE - lower : upper - lower;
	}

	public DiscountSlab next() {
		return next;
	}

	public double applyDiscount(double price) {
		double applicableAmount = Math.min(price, difference());
		return applicableAmount * (1 - (value / 100));
	}

	public void next(DiscountSlab next) {
		this.next = next;
	}

	public boolean isWithinRangeOf(DiscountSlab slab) {
		return slab.lower <= this.lower 
				&& (slab.upper == NO_UPPER_LIMIT ? Boolean.TRUE : slab.upper > this.upper);
	}

	public void adjustWith(DiscountSlab slab) {
		adjustUpperLimit(slab);
		adjustDiscountPercent(slab);
	}

	private void adjustDiscountPercent(DiscountSlab slab) {
		double value = this.value;
		this.value = slab.value;
		slab.value = value;
	}

	private void adjustUpperLimit(DiscountSlab slab) {
		double upper = this.upper;
		this.upper = slab.upper;
		slab.upper = upper;
	}

}
