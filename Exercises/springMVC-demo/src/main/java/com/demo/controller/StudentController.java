package com.demo.controller;

import com.demo.CO.StudentCO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class StudentController extends MultiActionController {

//    Exercise 1
    @Override
    @RequestMapping("/hello")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    //    Exercise 2
    @RequestMapping("/index")
    protected void customMethod(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer =  response.getWriter();
        writer.println("hello Exercise 2");
    }

    //    Exercise 3 & 4
    @RequestMapping("/")
    ModelAndView defalutAction() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", "Hello World");
        return modelAndView;
    }

    //    Exercise 5
    @ResponseBody
    @RequestMapping("/action")
    String action() {
        return "Hello World";
    }

    //    Exercise 6
    @ResponseBody
    @RequestMapping("/student/{firstName}/{lastName}")
    String studentDetails(@PathVariable("firstName")String firstName, @PathVariable("lastName")String lastName){
        return "First Name : "+firstName+" Last Name : "+lastName;
    }

    //    Exercise 7
    @ResponseBody
    @RequestMapping("/studentmap/{firstName}/{lastName}")
    String studentMap(@PathVariable Map<String,String> studentMap){
        return "First Name : "+studentMap.get("firstName")+" Last Name : "+ studentMap.get("lastName");
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    //    Exercise 8
//    @ResponseBody
//    @RequestMapping(value = "/loginData.html", method = RequestMethod.POST)
//    String submitForm(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
////        ModelAndView modelAndView = new ModelAndView("login");
//        return "First Name : "+firstName+" Last Name : "+lastName;
////        return modelAndView;
//    }

    //    Exercise 9
    @ResponseBody
    @RequestMapping(value = "/loginData.html", method = RequestMethod.POST)
    ModelAndView submitForm(@ModelAttribute("student")StudentCO student){
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("firstName",student.getFirstName());
        modelAndView.addObject("lastName",student.getLastName());
        return modelAndView;
    }

    //    Exercise 10
    @ModelAttribute
    void addingObject(Model model){
        model.addAttribute("heading","Spring MVC Demo");
    }
}
