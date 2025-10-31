package com.example.demo.DAO;

import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CarDAO {

    @PersistenceContext
    private EntityManager em;

    public List<CarDTO> findAll() {

        List<Car> list = em.createQuery("SELECT c FROM Car c", Car.class).getResultList();

        return list.stream().map(this::toDto).collect(Collectors.toList());

    }

    public void save(CarDTO dto) {

        Car e= new Car();
        e.setName(dto.getName());
        e.setColor(dto.getColor());

        em.persist(e);
        // após o persist, o id gerado está disponível
        dto.setId(e.getId() != null ? String.valueOf(e.getId()) : null);

    }

    public void deleteById(String id) {

        Long pk = Long.valueOf(id);
        Car e = em.find(Car.class, pk);

        if (e != null) {
            em.remove(e);
        }

    }

    public void update(String id, CarDTO dto) {

        Long pk = Long.valueOf(id);
        Car e = em.find(Car.class, pk);

        if (e != null) {
            e.setName(dto.getName());
            e.setColor(dto.getColor());
            em.merge(e);
        }

    }

    private CarDTO toDto(Car e) {

        CarDTO d = new CarDTO();
        d.setId(e.getId() != null ? String.valueOf(e.getId()) : null);
        d.setName(e.getName());
        d.setColor(e.getColor());

        return d;

    }


    public CarDTO findById(String id) {
        Long pk = Long.valueOf(id);
        Car car = em.find(Car.class, pk);

        if (car != null) {
            return toDto(car);
        }

        return null; // ou lançar uma exceção, dependendo da sua lógica
    }


}
