package models.dao.impl;

import models.dao.DepartmentDao;
import models.entities.Department;

import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    @Override
    public void insert(Department obj){

    }

    public void update(Department obj) {

    }

    public void deleteById(Integer id) {

    }

    public Department findById(Integer id) {
        return null;
    }

    public List<Department> findAll() {
        return List.of();
    }
}
