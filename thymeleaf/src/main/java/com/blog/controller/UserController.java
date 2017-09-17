package com.blog.controller;

import com.blog.domain.User;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by lidu on 2017/8/12.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    private List<User> getUserlist(){
        return userRepository.listUser();
    }

    /**
     * 获取用户列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",getUserlist());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据用户id获取用户列表
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取form表单用户列表
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView(" :/users");
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id,Model model){
        userRepository.deleteUser(id);
        model.addAttribute("userList",getUserlist());
        model.addAttribute("title","删除用户");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 修改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}