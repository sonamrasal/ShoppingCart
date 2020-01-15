package com.retail.cart;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.retail.discount.Default;
import com.retail.discount.DiscountPlan;
import com.retail.discount.Premium;
import com.retail.discount.Regular;

public class ShoppingCartTest {

	private static final double PRECISION = 0.0;
	private static final double ZERO = 0;
	private static final double NO_ITEMS = 0;
	private DiscountPlan discountPlan;
	private double basePrice;

	@Test
	public void emptyShoppingCartHasNoBill() {
		shoppingCartIsEmpty().thenBillIs(ZERO);
	}

	@Test
	public void customerDoesNotShopNoBillGenerated() {
		regularCustomer().shopsFor(NO_ITEMS).thenBillIs(ZERO);
	}

	@Test
	public void regularCustomerShoppingNotEligibleForDiscount() {
		regularCustomer().shopsFor(2000).thenBillIs(2000);
		regularCustomer().shopsFor(1499).thenBillIs(1499);
		regularCustomer().shopsFor(5000).thenBillIs(5000);
	}

	@Test
	public void discountSlabApplicableToItemsShoppedByRegularCustomer() {
		regularCustomer().shopsFor(6500).thenBillIs(6350);
		regularCustomer().shopsFor(10000).thenBillIs(9500);
		regularCustomer().shopsFor(15000).thenBillIs(13500);
	}

	@Test
	public void discountSlabApplicableToItemsShoppedByPremiumCustomer() {
		premiumCustomer().shopsFor(4000).thenBillIs(3600);
		premiumCustomer().shopsFor(8000).thenBillIs(7000);
		premiumCustomer().shopsFor(12000).thenBillIs(10200);
		premiumCustomer().shopsFor(20000).thenBillIs(15800);
	}

	private ShoppingCartTest shoppingCartIsEmpty() {
		this.discountPlan = new Default();
		this.basePrice = NO_ITEMS;
		return this;
	}

	private ShoppingCartTest regularCustomer() {
		this.discountPlan = new Regular();
		return this;
	}

	private ShoppingCartTest premiumCustomer() {
		this.discountPlan = new Premium();
		return this;
	}

	private void thenBillIs(double expectedBillAmount) {
		ShoppingCart cart = new ShoppingCart(discountPlan, basePrice);
		assertEquals(expectedBillAmount, cart.bill(), PRECISION);
	}

	private ShoppingCartTest shopsFor(double itemPrice) {
		this.basePrice = itemPrice;
		return this;
	}

}
