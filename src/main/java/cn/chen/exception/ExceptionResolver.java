package cn.chen.exception;

import cn.chen.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {
    @Autowired
    ExceptionService eService;
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        eService.put(e.getMessage());
        System.out.println(e.getMessage());
        ModelAndView mv=new ModelAndView();
        mv.setViewName("exception");
        return mv;
    }
}
