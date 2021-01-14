import bean.Cat;
import bean.Person;
import dao.DemoDao;
import dao.impl.DemoDaoMysqlImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring启动类
 *
 * @author zhaoxu
 * @className ZSpringApplication
 * @projectName spring-framework-project
 * @date 2021/1/14 9:54
 */
public class ZSpringApplication {

  public static void main(String[] args) {

      //读取配置文件，需要一个载体来加载它，这里咱选用 ClassPathXmlApplicationContext 来加载
      BeanFactory factory1 = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
      Person person1 = (Person) factory1.getBean("person");
      System.out.println(person1);

      //根据类型查找
      //读取配置文件，需要一个载体来加载它，这里咱选用 ClassPathXmlApplicationContext 来加载
      BeanFactory factory2 = new ClassPathXmlApplicationContext("basic_dl/quickstart-bytype.xml");
      //这次接收的 person 不用强转了！
      Person person2 = factory2.getBean(Person.class);
      System.out.println(person2);
      //BeanFactory 可以根据接口类型 找到对应的实现类。
      DemoDao demoDao = factory2.getBean(DemoDaoMysqlImpl.class);
      System.out.println(demoDao.findAll());


      BeanFactory beanFactory3 = new ClassPathXmlApplicationContext("basic_di/inject-set.xml");
      Person person3 = beanFactory3.getBean(Person.class);
      System.out.println(person3);

      Cat cat = beanFactory3.getBean(Cat.class);
      System.out.println(cat);
  }
}
