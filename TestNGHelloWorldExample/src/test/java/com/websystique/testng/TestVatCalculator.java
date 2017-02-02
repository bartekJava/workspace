package com.websystique.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVatCalculator 
{
	@Test
	public void testGetVatOnAmount()
	{
		VatCalculator calc = new VatCalculator();
		double expected = 21;
		Assert.assertEquals(calc.getVatOnAmount(100), expected);
		Assert.assertNotEquals(calc.getVatOnAmount(120), expected);
	}
}
