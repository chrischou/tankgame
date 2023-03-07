package com.trader99;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TankTest {

    @Test
    void getImage() {
        for (Direction direction : Direction.values()) {
            Tank tank = new Tank(0, 0, false, direction);
//            assertNotNull(tank.getImage());
//            try {
//                assertTrue(tank.getImage().getWidth(null) > 0);
//            } catch (AssertionFailedError e) {
//                System.out.println(direction);
//            }
            assertTrue(tank.getImage().getWidth(null) > 0,direction+" have error");
            Tank enemyTank = new Tank(0, 0, true, direction);
            assertTrue(enemyTank.getImage().getWidth(null) > 0);
//            assertNotNull(enemyTank.getImage());
        }

    }
}