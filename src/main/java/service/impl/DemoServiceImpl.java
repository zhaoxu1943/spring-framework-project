package service.impl;

import core.BeanFactory;
import dao.DemoDao;
import dao.ZDao;
import dao.impl.DemoDaoMysqlImpl;
import dao.impl.ZDaoRightImpl;
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
    private DemoDao demoDao = BeanFactory.getDemoDao();

    //简简单单的一个多态
    private ZDao zDao =  BeanFactory.getZDao();

    @Override
    public List<String> findAll() {
        zDao.getRoad();
       return demoDao.findAll();
    }
}
