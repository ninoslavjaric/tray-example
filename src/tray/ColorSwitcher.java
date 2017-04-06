/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tray;

import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import layouts.LightBox;

/**
 *
 * @author ninoslav.jaric
 */
public class ColorSwitcher extends Thread {
    Color c;
    LightBox panel;

    public ColorSwitcher(Color c, LightBox panel) {
        this.c = c;
        this.panel = panel;
    }
    
    
    
    @Override
    public void run() {
        super.run(); 
        Long sleepTime = null;
        if(ConfigDashboardHolder.getDate() != null){
            if(new Date().before(ConfigDashboardHolder.getDate()))
                sleepTime = ConfigDashboardHolder.getDate().getTime() - new Date().getTime();
        }else{
            sleepTime = new Long(""+(ConfigDashboardHolder.getTimeout()*1000));
        }
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(ColorSwitcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel.setVisible(true);
        while(ConfigDashboardHolder.isCanSwitchColor()){
            panel.colorPanel.setBackground(c);
            try {
                Thread.sleep(ConfigDashboardHolder.getSpeed());
            } catch (InterruptedException ex) {
                Logger.getLogger(ColorSwitcher.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.c = new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
        }
        this.panel.dispose();
    }
    
}
