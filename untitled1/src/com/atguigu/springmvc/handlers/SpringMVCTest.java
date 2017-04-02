package com.atguigu.springmvc.handlers;

//import jdk.internal.org.objectweb.asm.tree.analysis.Value;
//import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import com.atguigu.springmvc.entities.User;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by gl on 2017/3/25.
 */
//@SessionAttributes(value={"user"},types = {String.class})
@RequestMapping ("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS="success";
    private static final String HAPPY="happy";
    private static final String SHEZHI="shezhi";

    @RequestMapping("/testView")
    public String testView(){
        System.out.println("teseView");
        return "helloView";
    }

    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){

        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

     @ModelAttribute()
    public void getUser(@RequestParam(value="id",required = false)Integer id, Map<String,Object> map) {
         System.out.println("modelAttribute method");
         User user = null;
         if (id != null) {
             //模拟从数据库中获取对象
             user = new User(1, "Tom", "99999", "tom@guiug.com", 14);
         }
         System.out.println("从数据库中获取一个对象：" + user);
         map.put("user", user);
     }

//
//    运行流程：
//    1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入Map中，键为：user
//    2.SpringMVC 从Map中取出User对象，并把表单的请求参数赋给该User对象对应的属性
//    3.SpringMVC把上述对象传入目标方法的参数
// 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user){

        System.out.println("修改"+user);
        return SUCCESS;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, User> map){

        User user=new User("Tom","99999","tom@guiug.com",14);
        map.put("user",user);

        return SUCCESS;
    }

//目标方法可以添加Map类型（实际上也可以是Model类型或ModelMap类型）的参数
    @RequestMapping("/testMap")
    public  String testMap(Map<String,Object>map){

        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Jason","娜姐","杰哥"));
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
