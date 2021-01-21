import annotation.Color;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *
 * 基于注解的实现类扫描
 * @author zhaoxu
 * @className ZAnnotationSpringApplication
 * @projectName spring-framework-project
 * @date 2021/1/21 9:03
 */
public class ZAnnotationSpringApplication {

  public static void main(String[] args) {
    //ApplicationContext 中有一个方法叫 getBeansWithAnnotation ，它可以传入一个注解的 class ，返回所有被这个注解标注的 bean
      //暂时还是用我们之前的XML注解
      ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-bytype.xml");
      //传入注解的类文件,得到所有的bean
      Map<String, Object> colorBeanMap =  ctx.getBeansWithAnnotation(Color.class);
      //hashmap的遍历
      colorBeanMap.forEach((k,v) -> System.out.println(k+v.toString()));
  }
}
