package dao.impl;

import dao.DemoDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoxu
 * @className DemoDaoImpl
 * @projectName spring-framework-project
 * @date 2020/12/24 12:34
 */
public class DemoDaoImpl implements DemoDao {

    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa","bbb","ccc");
    }
}
