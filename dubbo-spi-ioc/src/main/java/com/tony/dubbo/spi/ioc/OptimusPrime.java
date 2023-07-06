package com.tony.dubbo.spi.ioc;

/**
 * @author 徐植君
 * @date 2023/7/7 0:01
 */
public class OptimusPrime implements Robot {

    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void sayHello() {

        System.out.println(weapon);

        System.out.println("Hello, I am Optimus Prime.");
    }
}