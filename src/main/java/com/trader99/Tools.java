package com.trader99;

import javax.swing.*;
import java.awt.*;

public class Tools {

    public static Image getImage(String imageName){
        return new ImageIcon("asserts/images/"+imageName).getImage();
    }
}
