package com.caner.yemeksepeti.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Bu sınıf uygulama içinde oluşacak tüm istisnaların yakalanması için kullanılacaktır.
 * burada bu sınıfın bizim belirlediğimiz özelleştirilmiş istisnaları yakalayacağız.
 * Bunun dışında ek kullandığımız kütüphanelerin  istisnalarını da ayrıca belirleyip
 * yakalayacağız.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private ErrorMessage createErrorMessage (ErrorType errorType, Exception exception){
        System.out.println("Bu kısımda hata mesajlarının loglama işlemlerini yapmalıyız");
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }


    @ExceptionHandler(CustomerManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handlerJava7MonoException(CustomerManagerException exception){
        /**
         * burada oluşan istisna ile ilgili eğer log tutulacak ise bu işlemler yapılır.
         */
        System.out.println("Java7MonoException hatası...: " +exception.toString());
        return new ResponseEntity(createErrorMessage(exception.getErrorType(),exception),exception.getErrorType().getHttpStatus());
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseEntity<String> handleArithmeticException (ArithmeticException exception){
        /**
         * burada oluşan istisna ile ilgili eğer log tutulacak ise bu işlemler yapılır.
         */
        System.out.println("Arithmetic exception hatası...: " +exception.toString());
        return ResponseEntity.ok("sıfıra bölme işlem hatası oluştu.");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){

        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }
    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMissingPathVariableExceptionn(MissingPathVariableException exception){

         ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception exception){

        return ResponseEntity.badRequest().body("Beklenmeyen bir hata oluştu. Lütfen daha sonra tekrar deneyiniz.");
    }

}
