package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() throws RateException {
		RateBLL R = new RateBLL();
		double pyt = R.getPayment(.04/12, 360, 300000, 0, false);
		double rte = R.getRate(650);
		assertEquals(rte, 4.5,0.01);
		assertEquals(Math.abs(pyt), Math.abs(1432.25),0.01);
	}

}
