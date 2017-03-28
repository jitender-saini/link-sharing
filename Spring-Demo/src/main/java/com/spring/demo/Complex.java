package com.spring.demo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Complex {
    List list;
    Set set;
    Map map;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
