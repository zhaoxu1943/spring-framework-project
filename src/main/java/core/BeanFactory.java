package core;

import dao.DemoDao;
import dao.ZDao;
import dao.impl.DemoDaoMysqlImpl;
import dao.impl.DemoDaoOracleImpl;
import dao.impl.ZDaoRightImpl;

/**
 * @author zhaoxu
 * @className BeanFactory
 * @projectName spring-framework-project
 * @date 2021/1/7 8:18
 */
public class BeanFactory {

    public static DemoDao getDemoDao(){
        return new DemoDaoMysqlImpl();
        //return new DemoDaoOracleImpl();
    }



    public static ZDao getZDao(){
        return new ZDaoRightImpl();
        //return new DemoDaoOracleImpl();
    }

}
