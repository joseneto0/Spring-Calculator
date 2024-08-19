package br.com.joseneto.springcalculator.Controllers;

import br.com.joseneto.springcalculator.Exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value ="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    @RequestMapping(value ="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    private Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        return convertDouble(numberOne) - convertDouble(numberTwo);
    }

    private Double convertDouble(String number){
        if (number == null){
            return 0D;
        }
        String n = number.replace(",", ".");
        if (isNumeric(n)) return Double.parseDouble(n);
        return 0D;
    }

    private boolean isNumeric(String number){
        if (number == null) return false;
        String n = number.replaceAll(",", ".");
        return n.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
