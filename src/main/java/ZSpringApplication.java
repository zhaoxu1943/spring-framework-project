import bean.Cat;
import bean.Person;
import dao.DemoDao;
import dao.impl.DemoDaoMysqlImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * spring启动类 BeanFactory 接口提供了一个抽象的配置和对象的管理机制，ApplicationContext 是 BeanFactory 的子接口，它简化了与 AOP
 * 的整合、消息机制、事件机制，以及对 Web 环境的扩展（ WebApplicationContext 等），BeanFactory 是没有这些扩展的。
 *
 * <p>ApplicationContext 主要扩展了以下功能：
 *
 * <p>AOP 的支持（ AnnotationAwareAspectJAutoProxyCreator 作用于 Bean 的初始化之后 ）
 * 配置元信息（ BeanDefinition、Environment 、注解等 ）
 * 资源管理（ Resource 抽象 ）
 * 事件驱动机制（ ApplicationEvent 、ApplicationListener ）
 * 消息与国际化（
 * LocaleResolver ）
 * Environment 抽象（ SpringFramework 3.1 以后）
 *
 * @author zhaoxu
 * @className ZSpringApplication
 * @projectName spring-framework-project
 * @date 2021/1/14 9:54
 */
public class ZSpringApplication {

  public static void main(String[] args) {

      //根据BEAN 别名查找
      //读取配置文件，需要一个载体来加载它，这里咱选用 ClassPathXmlApplicationContext 来加载
      BeanFactory factory1 = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
      Person person1 = (Person) factory1.getBean("person");
      System.out.println(person1);
      //如果一个接口有多个实现，而咱又想一次性把这些都拿出来，那 getBean() 方法显然就不够用了，需要使用额外的方式。
      //getBean只要能接受单一参数
//      factory1.getBean("单个参数,返回一个bean");
      //将 BeanFactory 接口换为 ApplicationContext
      ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
      //发现了这样一个方法,传入一个类型，返回一个 Map,而 Map 中的 value 不难猜测就是传入的参数类型对应的那些类 / 实现类。
      Map<String, DemoDao> beanMap =  ctx.getBeansOfType(DemoDao.class);
      for (Map.Entry<String, DemoDao> entry :beanMap.entrySet() ) {
          System.out.println(entry.getValue());
      }

      beanMap.forEach((beanName, bean) -> {
          System.out.println(beanName + " : " + bean.toString());
      });

    System.out.println("-------------------------------------------------------");

      //根据类型查找
      //读取配置文件，需要一个载体来加载它，这里咱选用 ClassPathXmlApplicationContext 来加载
      BeanFactory factory2 = new ClassPathXmlApplicationContext("basic_dl/quickstart-bytype.xml");
      //这次接收的 person 不用强转了！
      Person person2 = factory2.getBean(Person.class);
      System.out.println(person2);
      //BeanFactory 可以根据接口类型 找到对应的实现类。
      DemoDao demoDao = factory2.getBean(DemoDaoMysqlImpl.class);
      System.out.println(demoDao.findAll());

      System.out.println("-------------------------------------------------------");

      //依赖注入
      BeanFactory beanFactory3 = new ClassPathXmlApplicationContext("basic_di/inject-set.xml");
      Person person3 = beanFactory3.getBean(Person.class);
      System.out.println(person3);

      Cat cat = beanFactory3.getBean(Cat.class);
      System.out.println(cat);
  }
}
