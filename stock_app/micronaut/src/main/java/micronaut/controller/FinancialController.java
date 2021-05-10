package micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import micronaut.controller.interfce.FinancialControllerInt;
import micronaut.service.FinancialService;

import javax.inject.Inject;
import java.io.IOException;

@Controller("/finance")
public class FinancialController implements FinancialControllerInt {

    @Inject
    private FinancialService financialService;

    protected static final Logger LOGGER = LoggerFactory.getLogger(FinancialController.class);
    @Get(produces = MediaType.APPLICATION_JSON)
    public String getFinancialData(@QueryValue("provider") String provider,
                                   @QueryValue("stock_index") String stockIndex) throws IOException {

        LOGGER.info(provider);
        LOGGER.info(stockIndex);

        return financialService.getFinancialData(provider,stockIndex);
    }
}
