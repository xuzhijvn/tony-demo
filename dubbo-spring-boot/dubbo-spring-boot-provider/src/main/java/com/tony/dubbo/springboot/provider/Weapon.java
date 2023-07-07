package com.tony.dubbo.springboot.provider;

/**
 * @author 徐植君
 * @date 2023/7/7 0:06
 */
public class Weapon {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                '}';
    }
}
