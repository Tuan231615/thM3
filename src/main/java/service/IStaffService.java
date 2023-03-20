package service;

import model.Staff;

import java.util.List;

public interface IStaffService {
    List<Staff> findAll();

    void save(Staff staff);

    Staff findById(int id);

    boolean update(int id, Staff staff);

    boolean remove(int id);
}
