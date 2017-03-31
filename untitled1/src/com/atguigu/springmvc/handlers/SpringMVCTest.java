package com.atguigu.springmvc.handlers;

//import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by gl on 2017/3/25.
 */
@RequestMapping ("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS="success";




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
