package cn.chen.controller;

import cn.chen.bean.Account;
import cn.chen.bean.Student;
import cn.chen.service.ImgService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Arrays;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    ImgService imgService;
    @RequestMapping("/setImg")
   public String setImg(HttpSession session, MultipartFile upload) throws IOException {
        System.out.println("setImg");
        String path=session.getServletContext().getRealPath("/head");
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        Account account=(Account)session.getAttribute("account");
        String filename=account.getId()+".jpg";
        imgService.saveImg(account.getId(),upload.getBytes());
        try {
            upload.transferTo(new File(path,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "person";
   }
   @RequestMapping("/getMess")
   public @ResponseBody String getMess(HttpSession session){
        Account account= (Account) session.getAttribute("account");
       System.out.println("getMess"+account.getName());
       String name=account.getName();
      return name;
   }
    @RequestMapping("/getId")
    public @ResponseBody String getId(HttpSession session){
        Account account= (Account) session.getAttribute("account");
        System.out.println("getIds"+account.getName());
        int id=account.getId();
        return id+"";
    }
//   @RequestMapping("/header")
//   public String getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            System.out.println("getImg");
//            HttpSession session=request.getSession();
//            Account account = (Account) session.getAttribute("account");
//            System.out.println(account.getId());
////            byte[] img = imgService.getImg(account.getId());
////            if (img.length < 2) {
////                if (defaultImg != null) {
////                    img = defaultImg;
////                } else {
////                    String path = session.getServletContext().getRealPath("/img/defaultImg.jpg");
////                    System.out.println(path);
////                    try {
////                        defaultImg= FileUtils.readFileToByteArray(new File(path));
////                        img = defaultImg;
////                    } catch (FileNotFoundException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////            System.out.println(Arrays.toString(img));
//            OutputStream os = response.getOutputStream();
//            os.write(img);
//            os.flush();
//            os.close();
//            return "person";
//    }
    @RequestMapping("/goToSetImg")
    public String goToSetImg(){
        return "setImg";
    }
}
