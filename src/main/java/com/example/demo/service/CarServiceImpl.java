package com.example.demo.service;


import com.example.demo.DAO.CarDAO;
import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarDAO carJpaDao;

    public CarServiceImpl(CarDAO carDao) {
        this.carJpaDao = carDao;
    }

    @Override
    public List<CarDTO> findAll() {
        return carJpaDao.findAll();
    }

    @Override
    public void save(CarDTO carDTO) {
        carJpaDao.save(carDTO);
    }

    @Override
    public void deleteById(String id) {
        carJpaDao.deleteById(id);
    }

    @Override
    public void update(String id, CarDTO carDTO) {
        carJpaDao.update(id, carDTO);
    }


    public CarDTO findById(String id) {
        return carJpaDao.findById(id);
    }
}
