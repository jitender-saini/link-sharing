package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class StudentController extends MultiActionController {
    @Override
    @RequestMapping("/hello")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    @RequestMapping("/index")
    protected void customMethod(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer =  response.getWriter();
        writer.println("hello Exercise 2");
    }

    @RequestMapping("/")
    ModelAndView defalutAction() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", "Hello World");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/action")
    String action() {
        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("/student/{firstName}/{lastName}")
    String studentDetails(@PathVariable("firstName")String firstName, @PathVariable("lastName")String lastName){
        return "First Name : "+firstName+" Last Name : "+lastName;
    }

    


}
