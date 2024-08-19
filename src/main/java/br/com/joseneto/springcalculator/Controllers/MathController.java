package br.com.joseneto.springcalculator.Controllers;

import br.com.joseneto.springcalculator.Exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value ="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws UnsupportedMathOperationException  {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    @RequestMapping(value ="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    private Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        return convertDouble(numberOne) - convertDouble(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}")
    private Double mult(@PathVariable String numberOne, @PathVariable String numberTwo) throws UnsupportedMathOperationException  {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        return convertDouble(numberOne) * convertDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    private Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws UnsupportedMathOperationException  {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        if (convertDouble(numberTwo) == 0D){
            throw new UnsupportedMathOperationException("Division by zero");
        }
        return convertDouble(numberOne) / convertDouble(numberTwo);
    }

    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    private Double average(@PathVariable String numberOne, @PathVariable String numberTwo) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numerics values");
        }
        return (convertDouble(numberOne) + convertDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    private Double sqrt(@PathVariable String number) throws UnsupportedMathOperationException {
        if (!isNumeric(number)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        if (convertDouble(number) < 0D){
            throw new UnsupportedMathOperationException("Set a value greater than zero");
        }
        return Math.sqrt(convertDouble(number));
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
