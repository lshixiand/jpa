package com.blog.controller;

import com.blog.domain.User;
import com.blog.repository.UserJPARepository;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidu on 2017/8/12.
 */
@RestController
@RequestMapping("/users")
public class UserController {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserJPARepository userJPARepository;


    private List<User> getUserlist(){
        List<User> users = new ArrayList<>();
        for (User user : userJPARepository.findAll()){
            users.add(user);

        }
        return users;
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
        User user = userJPARepository.findOne(id);
        model.addAttribute("title","查看用户");
        model.addAttribute("user",user);
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
//        userRepository.saveOrUpdateUser(user);
        userJPARepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id,Model model){
//        userRepository.deleteUser(id);
        userJPARepository.delete(id);
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
        User user = userJPARepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}