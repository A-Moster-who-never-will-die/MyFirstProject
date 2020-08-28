package cn.chen.controller;
import cn.chen.bean.Account;
import cn.chen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/login")
@SessionAttributes("account")
public class LoginController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/index")
    public ModelAndView login(Model model,String name,String password ){
        System.out.println(name+password);
        ModelAndView mv=new ModelAndView();
        Account account=accountService.getPassword(name);
        if(password!=null&&password.equals(account.getPassword())){
                System.out.println("success");
                mv.setViewName("person");
                int id=accountService.getId(name);
                account.setName(name);
                account.setId(id);
                model.addAttribute("account",account);
        }else {
            mv.setViewName("redirect:/index.html");
        }
        return mv;
    }
    @RequestMapping("/register")
    public ModelAndView register(String name,String password){
        System.out.println("register"+name);
        ModelAndView mv=new ModelAndView();
        if (accountService.haveSame(name)){
            mv.setViewName("register");
            return mv;
        }else {
            System.out.println("register"+name);
            accountService.saveAccount(name,password);
            mv.setViewName("redirect:/index.html");
            return mv;
        }
    }
    @RequestMapping("/toReg")
    public String reg(){
        return "register";
    }
    @RequestMapping("/hasSame")
    public @ResponseBody String hasSame(String name){
        System.out.println("haha");
        if (accountService.haveSame(name)) {
            System.out.println("账号重复");
            return "9";
        }else {
            System.out.println("不重复");
            return "0";
        }
    }

}
