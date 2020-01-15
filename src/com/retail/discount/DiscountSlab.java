package com.retail.discount;

public class DiscountSlab {

	public static final double NO_UPPER_LIMIT = -1;
	private final double lower;
	private final double upper;
	private final double value;
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

	public DiscountSlab nextSlab() {
		return next;
	}

	public double applyDiscount(double price) {
		double applicableAmount = Math.min(price, difference());
		return applicableAmount * (1 - (value / 100));
	}

	public void next(DiscountSlab next) {
		this.next = next;
	}

}
