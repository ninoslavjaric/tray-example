/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tray;

import java.awt.Color;
import java.util.Date;

/**
 *
 * @author ninoslav.jaric
 */
public class ConfigDashboardHolder {
    static Date date = null;
    static Integer timeout = null;
    static Integer speed = null;
    static Color bgColor = null;
    static boolean canSwitchColor = false;

    public static void setDate(Date date) {
        ConfigDashboardHolder.date = date;
    }

    public static void setTimeout(Integer timeout) {
        ConfigDashboardHolder.timeout = timeout;
    }

    public static void setSpeed(Integer speed) {
        ConfigDashboardHolder.speed = speed;
    }

    public static void setBgColor(Color bgColor) {
        ConfigDashboardHolder.bgColor = bgColor;
    }

    public static Date getDate() {
        return date;
    }

    public static Integer getTimeout() {
        return timeout;
    }

    public static Integer getSpeed() {
        return speed;
    }

    public static Color getBgColor() {
        return bgColor;
    }

    public static boolean isCanSwitchColor() {
        return canSwitchColor;
    }

    public static void setCanSwitchColor(boolean canSwitchColor) {
        ConfigDashboardHolder.canSwitchColor = canSwitchColor;
    }
    public static boolean availableStart(){
        try{
            if((date != null || timeout != null) && 
                    speed != null && 
                    bgColor != null){
                return true;
            }
            return false;
        }catch(NullPointerException e){
            System.out.println("test exc");
            return false;
        }
    }
    public static void print() {
        System.out.println(bgColor);
    }
    
}
