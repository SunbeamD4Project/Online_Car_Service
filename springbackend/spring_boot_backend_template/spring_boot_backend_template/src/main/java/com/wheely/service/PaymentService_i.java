package com.wheely.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.wheely.dto.PaymentRequestDTO;

public interface PaymentService_i {
	public PaymentIntent createPaymentIntent(PaymentRequestDTO paymentRequestDTO) throws StripeException;
}
