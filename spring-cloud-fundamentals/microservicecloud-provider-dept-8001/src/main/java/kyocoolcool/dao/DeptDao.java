package kyocoolcool.dao;

import kyocoolcool.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//@Component(value = "deptDao")
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();

}
