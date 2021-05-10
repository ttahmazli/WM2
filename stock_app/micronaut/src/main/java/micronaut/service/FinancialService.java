package micronaut.service;

import micronaut.service.interfce.FinancialServiceInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.inject.Singleton;
import java.io.IOException;
import java.math.BigDecimal;

@Singleton
public class FinancialService implements FinancialServiceInt {
    protected static final Logger LOGGER = LoggerFactory.getLogger(FinancialService.class);


    public String getFinancialData(String provider, String stockIndex) throws IOException {
        if (provider.equals("yahoo")) {
            LOGGER.info(stockIndex);
            Stock stock = YahooFinance.get(stockIndex);
            BigDecimal price = stock.getQuote().getPrice();
          return price.toString();
        } else return "Not Found";
    }
}
