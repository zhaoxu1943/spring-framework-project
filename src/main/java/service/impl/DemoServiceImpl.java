package service.impl;

import core.BeanFactory;
import dao.DemoDao;
import dao.ZDao;
import service.DemoService;

import java.util.List;

/**
 * @author zhaoxu
 * @className DemoServiceImpl
 * @projectName spring-framework-project
 * @date 2020/12/24 12:34
 */
public class DemoServiceImpl implements DemoService {



    //简简单单的一个多态
    private DemoDao demoDao = (DemoDao) BeanFactory.getBean("demoDao");


    @Override
    public List<String> findAll() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("demoDao"));
        }
       return demoDao.findAll();
    }
}
