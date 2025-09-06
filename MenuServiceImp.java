package com.example.FoodDelivery.Service;



import com.example.FoodDelivery.Entity.Menu;
import com.example.FoodDelivery.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu updateMenu(Long id, Menu updatedMenu) {
        return menuRepository.findById(id)
                .map(menu -> {
                    menu.setItemName(updatedMenu.getItemName());
                    menu.setDescription(updatedMenu.getDescription());
                    menu.setPrice(updatedMenu.getPrice());
                    return menuRepository.save(menu);
                }).orElseThrow(() -> new RuntimeException("Menu not found with id " + id));
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
