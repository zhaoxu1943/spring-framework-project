package dao.impl;

import dao.ZDao;

/**
 * @author zhaoxu
 * @className ZDaoImpl
 * @projectName spring-framework-project
 * @date 2021/1/7 8:19
 */
public class ZDaoWrongImpl implements ZDao {

    /**
     * 侦查前方道路
     *
     * @return
     * @throws
     * @author zhaoxu
     */
    @Override
    public void getRoad() {
        System.out.println("play!");
    }
}
