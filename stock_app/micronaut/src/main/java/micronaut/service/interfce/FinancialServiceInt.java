package micronaut.service.interfce;

import java.io.IOException;

public interface FinancialServiceInt {
    Object getFinancialData(String provider, String stockIndex) throws IOException;
}
