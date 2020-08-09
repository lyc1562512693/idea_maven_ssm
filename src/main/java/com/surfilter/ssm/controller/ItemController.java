package com.surfilter.ssm.controller;

import com.surfilter.ssm.model.SmItem;
import com.surfilter.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    protected ItemService itemService;

    @RequestMapping(value = "/getItemById.action",method= RequestMethod.GET)
    public String getItemById(int itemId, Model model){
        //List lst = new ArrayList<>();
        //lst.add(itemService.getItemById(itemId));
        model.addAttribute("item", itemService.getItemById(itemId));
        System.out.println("localhost:8080/idea_maven_ssm/item/getItemById.action接口执行了");
        return "item";
    }
}
