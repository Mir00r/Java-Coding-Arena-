/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.controller;

import com.mir00r.model.Employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
@Controller
//@RequestMapping(value = "/welcome")
public class HelloController {
    
     @RequestMapping (value = "/", method = RequestMethod.GET)
    public String HelloMessage ( ModelMap map ) {
        map.addAttribute("hello", "Hello Spring MVC Framework");
        return "index";
    }
    
    
    // If we not bind any specific section data then we should use this method 
    @InitBinder
    public void MyInitBinder ( WebDataBinder binder ) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        binder.registerCustomEditor(Date.class, "empDOB", 
                new CustomDateEditor(format, false));
      //  binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
   
    // Multi Action Controller and Path varible Example 
//    @RequestMapping (value = ("/welcome/{country}/{name}") )  
//    public String HioMessage ( ModelMap map, 
//            @PathVariable("name") String name, 
//            @PathVariable("country") String country ) {
//        
//        map.addAttribute("hello", "Hello " + name + "You are from " +country);
//        return "index";
//    }
    
    // Multi Action Controller and Path varible Example using Map
    @RequestMapping (value = ("/welcome/{country}/{name}") )  
    public String HioMessage ( ModelMap map, 
            @PathVariable Map < String, String > pathvars ) {
        
        String name = pathvars.get("name");
        String country = pathvars.get("country");
        map.addAttribute("hello", "Hello " + name + "You are from " +country);
        return "index";
    }
    
    @RequestMapping(value = "/addemp", method = RequestMethod.GET)
    public String displayEmployee () {
        return "addemployee";
    }
    
//    @RequestMapping(value = "/addemp", method = RequestMethod.POST)
//    public String addEmployee ( ModelMap map, 
//            @RequestParam("ename") String ename, 
//            @RequestParam("eaddress") String eaddress ) {
//        
//        Employee employee = new Employee();
//        employee.setEname(ename);
//        employee.setEaddress(eaddress);
//        
//       // map.addAttribute("edetails", "Name : " + ename + " Address : " + eaddress);
//        map.addAttribute("employee", employee);
//        return "einfo";
//    }
    
    // Model Attribute Annotation Example 
    @RequestMapping(value = "/addemp", method = RequestMethod.POST)
    public String addEmployee ( ModelMap map, @Valid 
            @ModelAttribute("employee") Employee employee, 
            BindingResult result) {
        
        if ( result.hasErrors()  ) {
            return "addemployee";
        }
        
        // No need to declear this section
//        Employee employee = new Employee();
//        employee.setEname(ename);
//        employee.setEaddress(eaddress);
//        map.addAttribute("employee", employee);
        return "einfo";
    }
    
    @ModelAttribute
    public String ShowCommonMsg ( ModelMap map ) {
        map.addAttribute("msg", "Message Set PErfectly");
        return "einfo";
    }
}
