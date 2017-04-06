/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tray;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import layouts.Dashboard;

/**
 *
 * @author ninoslav.jaric
 */
public class TrayInitiator {

    final private static String imgSrc = "src/resources/images/photo.jpg";
    private BufferedImage img = null;
    final PopupMenu popup = new PopupMenu();
    final SystemTray tray = SystemTray.getSystemTray();
    private TrayIcon trayIcon = null;
    HashMap<String, MenuItem> menuItems = new HashMap<>();
    private Dashboard dBoard = new Dashboard();
    
    private TrayInitiator() {
        try {
            this.img = ImageIO.read(
                    new File(imgSrc)
            );
        } catch (IOException ex) {
            Logger.getLogger(TrayInitiator.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.trayIcon = new TrayIcon(this.img, "Tooltip jbg");
        
        MenuItem settingsItem = new MenuItem("Settings");
        this.menuItems.put("settings", settingsItem);
        MenuItem exitItem = new MenuItem("Exit");
        this.menuItems.put("exit", exitItem);
        
        this.popup.add(settingsItem);
        this.popup.add(exitItem);
        
        this.trayIcon.setPopupMenu(popup);
        try {
            this.tray.add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(TrayInitiator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static TrayInitiator init(){
        TrayInitiator self = new TrayInitiator();
        self.bindListeners();
        return self;
    }
    
    private void bindListeners(){
        this.menuItems.get("settings").addActionListener(e->dBoard.setVisible(true));
        this.menuItems.get("exit").addActionListener(e->System.exit(0));
    }
}
