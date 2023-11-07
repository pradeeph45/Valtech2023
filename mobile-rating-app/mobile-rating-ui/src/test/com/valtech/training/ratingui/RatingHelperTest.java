package com.valtech.training.ratingui;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingHelperTest {

	@Test
	public void test() {
		RatingHelper helper=new RatingHelper();
		Assert.assertEquals(0,helper.getRanking("12345689"));
	}

}
