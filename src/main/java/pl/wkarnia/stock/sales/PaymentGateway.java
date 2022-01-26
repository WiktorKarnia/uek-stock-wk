package pl.wkarnia.stock.sales;

import pl.wkarnia.stock.sales.ordering.CustomerDetails;
import pl.wkarnia.stock.sales.ordering.PaymentDetails;

import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentDetails register(String id, BigDecimal total, CustomerDetails customerDetails);
}

