package softuni.coffeeshop.service;

import softuni.coffeeshop.model.entity.User;
import softuni.coffeeshop.model.service.UserServiceModel;
import softuni.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUser(String username, String password);

    void loginUser(Long id);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrderDesc();

}
