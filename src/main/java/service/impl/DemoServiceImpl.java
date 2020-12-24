package service.impl;

import dao.DemoDao;
import dao.impl.DemoDaoImpl;
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
    private DemoDao demoDao = new DemoDaoImpl();

    @Override
    public List<String> findAll() {
       return demoDao.findAll();
    }
}
