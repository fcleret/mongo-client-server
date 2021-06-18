package fr.iut.blankproject.controller.advice;

import fr.iut.blankproject.controller.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Une classe avec l'annotation {@link ControllerAdvice} est une classe utilitaire permettant
 * à Spring de renvoyer à l'utilisateur une réponse HTTP pré-définie si jamais une exception venait à être
 * levée dans un Controller.
 * <p>
 * L'utilisation d'advice permet de mutualiser entre plusieurs endpoints et/ou plusieurs Controller un comportement
 * que l'on veut appliquer pour une exception donnée. Son utilisation permet également de ne pas gérer ces cas d'erreurs
 * au sein des Controller, ce qui simplifie le code.
 */
@ControllerAdvice
public class CustomExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String customExceptionHandler(CustomException ex) {
        return ex.getMessage();
    }
}
