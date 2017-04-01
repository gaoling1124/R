package com.atguigu.springmvc.handlers;

//import jdk.internal.org.objectweb.asm.tree.analysis.Value;
//import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import com.atguigu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by gl on 2017/3/25.
 */
@SessionAttributes(value={"user"},types = {String.class})
@RequestMapping ("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS="success";
    private static final String HAPPY="happy";
    private static final String SHEZHI="shezhi";

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, User> map){

        User user=new User("Tom","99999","tom@guiug.com",14);
        map.put("user",user);

        return SUCCESS;
    }

//目标方法可以添加Map类型（实际上也可以是Model类型或ModelMap类型）的参数
    @RequestMapping("/testMap")
    public  String testMap(Map<String,Object>map){

        map.put("names", Arrays.asList("Jasom","娜姐","杰哥"));
        return SUCCESS;
    }


//目标方法的返回值可以是ModelAndView类型，其中可以包含视图和模型信息
// SpringMVCT会把ModelAndView的model中数据放入到request域对象中
@RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

       String viewName=SUCCESS;
       ModelAndView modelAndView=new ModelAndView(viewName);
        //添加模型数据到 modelAndView中
        modelAndView.addObject("time", new Date()) ;
        return modelAndView;
}

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request,
                                  HttpServletResponse response){

        System.out.println("testServletAPI,"+request+","+response );
        return SUCCESS ;
    }


    @RequestMapping("/testPojo")
    public String testPojo(User user ){

        System.out.println("testPojo: "+user);
        return SHEZHI   ;
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID")String sessionID){
        System.out.println("testCookieValue: sessionID: "+sessionID );
        return HAPPY ;
    }

    @RequestMapping ("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept-Language")String al){

        System.out.println("testRequestHeader,\n" +
                "   Accept-Language:"+al);
        return HAPPY  ;
    }


    @RequestMapping (value ="/testRequestParam")
    public String testRequestParam(@RequestParam(value ="username")String un,
                                   @RequestParam (value="age",required = false,defaultValue = "0")int age){

          System.out.println("testRequestParam,username:"+un+",age:"+age);

        return SUCCESS ;
    }

    @RequestMapping ("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){

         System.out.println("testPathVariable:"+"id");
        return SUCCESS ;
    }

    @RequestMapping ("/testAntPath/*/abc")
public String testAntPath(){
    System.out.println("testAntPath");
    return SUCCESS;
}

     @RequestMapping(value="testParamsAndHeaders",
                     params={"username","age!=11"},
                     headers = {"Accept-Language:zh-CN"})
    public String testParamsAndHeaders(){

        System.out.println("testParamsAndHeaders");
        return SUCCESS ;

    }

    @RequestMapping (value="/testMethod",method=RequestMethod.POST )
     public String testMethod(){

         System.out.println("testMethod");
         return SUCCESS;
     }

     @RequestMapping ("/testRequestMapping")
    public String testRequestMapping(){
        System.out.print("testRequestMapping") ;
        return SUCCESS;

    }
}
