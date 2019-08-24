package kyocoolcool.service.impl;

import kyocoolcool.dao.DeptDao;
import kyocoolcool.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kyocoolcool.service.DeptService;

import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author chris
 * @Date 2019-02-23 14:02
 * @Version 1.0
 **/
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    public Dept get(Long id) {
        return dao.findById(id);
    }

    public List<Dept> list() {
        return dao.findAll();
    }
}