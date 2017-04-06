/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tray;


/**
 *
 * @author ninoslav.jaric
 */
public class Tray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrayInitiator ti = TrayInitiator.init();
        System.out.println(ti.menuItems);
        System.out.println(new java.util.Date().getTime());
        
    }
    
}
