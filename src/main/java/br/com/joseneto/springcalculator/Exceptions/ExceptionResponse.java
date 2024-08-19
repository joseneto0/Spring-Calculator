package br.com.joseneto.springcalculator.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date time;
    private String message;
    private String details;
}
