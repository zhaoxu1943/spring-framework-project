package core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhaoxu
 * @className BeanFactory
 * @projectName spring-framework-project
 * @date 2021/1/7 8:18
 */
public class ZBeanFactory {

  private static Properties properties;

  // 静态缓存区，保存已经创建好的对象
  private static Map<String, Object> beanMap = new HashMap<>();



  // 使用静态代码块初始化properties，加载factord.properties文件
  static {
    properties = new Properties();
    try {
      // 必须使用类加载器读取resource文件夹下的配置文件
      properties.load(ZBeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
    } catch (IOException e) {
      // BeanFactory类的静态初始化都失败了，那后续也没有必要继续执行了
      throw new ExceptionInInitializerError(
          "BeanFactory initialize error, cause: " + e.getMessage());
    }
  }





  /**
   * 传定义的别名即可
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  public static Object getBean(String beanName) {
    // 双检锁保证beanMap中确实没有beanName对应的对象
      if (!beanMap.containsKey(beanName)){
        synchronized (ZBeanFactory.class){
          // 过了双检锁，证明确实没有，可以执行反射创建
          if (!beanMap.containsKey(beanName)){
            Object bean = null;
            try {
              bean = Class.forName(properties.getProperty(beanName)).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
              e.printStackTrace();
            }
            beanMap.put(beanName,bean);
          }
        }
    }
    return beanMap.get(beanName);
  }

}
