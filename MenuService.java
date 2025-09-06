package com.example.FoodDelivery.Service;


import com.example.FoodDelivery.Entity.Menu;
import java.util.List;
import java.util.Optional;

public interface MenuService {
    Menu addMenu(Menu menu);
    List<Menu> getAllMenus();
    Optional<Menu> getMenuById(Long id);
    Menu updateMenu(Long id, Menu menu);
    void deleteMenu(Long id);
}
