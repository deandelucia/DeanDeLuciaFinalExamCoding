package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			if (message instanceof LoanRequest) {
				resetOutput();
				
				LoanRequest lq1 = (LoanRequest) message;
				
				try {
					int creditScore = lq1.getiCreditScore();
					lq1.setdRate(RateBLL.getRate(creditScore));
				} catch (RateException e) {
					sendToAll(e);
					System.out.println("Error: Credit Score not sufficient");
				}

				double payment = RateBLL.getPayment(lq1.getdRate()/100,lq1.getiTerm()*12,lq1.getdAmount()-lq1.getiDownPayment(), 0.0, false);
				lq1.setdPayment(payment);
				
				sendToAll(lq1);
			}
		}
	}
}
