import bean.Person;
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
      BeanFactory factory = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
      Person person = (Person) factory.getBean("person");
      System.out.println(person);
  }
}
