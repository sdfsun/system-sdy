package com.sdy.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.sdy.modular.system.dao.MenuMapper;
import com.sdy.base.BaseJunit;
import com.sdy.modular.system.model.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Stack;

/**
 * 菜单测试
 */
public class MenuTest extends BaseJunit {

    @Autowired
    MenuMapper menuMapper;

    /**
     * 初始化pcodes
     */
    @Test
    public void generatePcodes() {
        List<Menu> menus = menuMapper.selectList(null);
        for (Menu menu : menus) {
            if ("0".equals(menu.getPcode()) || null == menu.getPcode()) {
                menu.setPcodes("[0],");
            } else {
                StringBuffer sb = new StringBuffer();
                Menu parentMenu = getParentMenu(menu.getCode());
                sb.append("[0],");
                Stack<String> pcodes = new Stack<>();
                while (null != parentMenu.getPcode()) {
                    pcodes.push(parentMenu.getCode());
                    parentMenu = getParentMenu(parentMenu.getPcode());
                }
                int pcodeSize = pcodes.size();
                for (int i = 0; i < pcodeSize; i++) {
                    String code = pcodes.pop();
                    if (code.equals(menu.getCode())) {
                        continue;
                    }
                    sb.append("[" + code + "],");
                }

                menu.setPcodes(sb.toString());
            }
            menu.updateById();
        }
    }

    private Menu getParentMenu(String code) {
        Wrapper<Menu> wrapper = new EntityWrapper<Menu>();
        wrapper = wrapper.eq("code", code);
        List<Menu> menus = menuMapper.selectList(wrapper);
        if (menus == null || menus.size() == 0) {
            return new Menu();
        } else {
            return menus.get(0);
        }
    }
}