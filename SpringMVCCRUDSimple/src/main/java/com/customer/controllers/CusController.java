package com.customer.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.customer.beans.Cus;
import com.customer.dao.CusDao;  
@Controller  
public class CusController {  
    @Autowired  
    CusDao dao; 
     
    @RequestMapping("/cusform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Cus());
    	return "cusform"; 
    }  
      
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cus") Cus cus){  
        dao.save(cus);  
        return "redirect:/viewcus";  
    }  
    
    @RequestMapping("/viewcus")  
    public String viewcus(Model m){  
        List<Cus> list=dao.getCustomer();  
        m.addAttribute("list",list);
        return "viewcus";  
    }  
      
    @RequestMapping(value="/editcus/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Cus cus=dao.getCusById(id);  
        m.addAttribute("command",cus);
        return "cuseditform";  
    }  
      
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("cus") Cus cus){  
        dao.update(cus);  
        return "redirect:/viewcus";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewcus */  
    @RequestMapping(value="/deletecus/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewcus";  
    }   
}  