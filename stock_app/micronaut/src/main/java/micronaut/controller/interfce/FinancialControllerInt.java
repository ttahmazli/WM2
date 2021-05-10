package micronaut.controller.interfce;

import java.io.IOException;

public interface FinancialControllerInt {
    Object getFinancialData(String financial_data_provider, String stock_index) throws IOException;
}
