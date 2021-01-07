package dao.impl;

import dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoxu
 * @className DemoDaoOracleImpl
 * @projectName spring-framework-project
 * @date 2021/1/7 8:11
 */
public class DemoDaoOracleImpl implements DemoDao {

    @Override
    public List<String> findAll() {
        return Arrays.asList("oracle","oracle","oracle");
    }
}
