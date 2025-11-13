package domain.Controller;

import domain.Service.CalcService;

public class CalcController {

    private final CalcService calcService;

    public CalcController() {
        this(new CalcService());
    }

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    public int run() {
        return calcService.calculateFromScanner();
    }
}
