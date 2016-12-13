package exceptions;

import java.util.ArrayList;

import rocketBase.RateDAL;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	private RateDomainModel rate;

	public RateException(RateDomainModel rate) {
		super();
		this.rate = rate;
	}
	public RateDomainModel getRateDomainModel() {
		return rate;
	}
	


	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
