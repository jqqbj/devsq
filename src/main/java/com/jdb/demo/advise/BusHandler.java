package com.jdb.demo.advise;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import com.jdb.demo.exception.LoginException;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class BusHandler {

    @ExceptionHandler(Exception.class)
    Map exceptionHandler(Exception e){
        Map a = new HashMap<>();
        a.put("code",100);
        a.put("msg",e.getMessage());
        e.printStackTrace();
        return a;
    }

    @ExceptionHandler(LoginException.class)
    Map exceptionHandler2(LoginException e){
        Map a = new HashMap<>();
        a.put("msg",e.getMessage());
        return a;
    }

//    @ExceptionHandler(LoginException.class)
//    ModelAndView exceptionHandler2(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("hello");
//        return mav;
//    }

}
