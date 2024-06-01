import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**

 * Project: Lab 2
 * Purpose Details: Adding MySQL and MongoDB to the space game
 * Course: IST 242
 * Author: Matthias Fischer
 * Date Developed: 5/31/2024
 * Last Date Changed: 5/31/2024
 * Rev: 1

 */



public class Main {


    public static void main(String[] args) {


/**
 * The player will choose the Shiptype before anything, which governs the parameters Health, Ammo, and Speed
 * The game will execute a different method according to which Shiptype the player chose
 */

        Game myGameScout = new Game(Shiptype.SCOUT,20,10,5,5,50,10,"Gray");

        Game myGameDestroyer= new Game(Shiptype.DESTROYER,20,10,5,20,100,3,"Blue");

        Game myGameFighter= new Game(Shiptype.FIGHTER,20,10,5,10,75,6,"Orange");

        System.out.println("Ship type: " + myGameScout.getShiptype());
        System.out.println("Invader count: " + myGameScout.getInvaders());
        System.out.println("Obstacle count: " + myGameScout.getObstacles());
        System.out.println("Powerup count: " + myGameScout.getPowerups());
        System.out.println("Health: " + myGameScout.getHealth());
        System.out.println("Ammo: " + myGameScout.getAmmo());
        System.out.println("Speed: " + myGameScout.getSpeed());
        System.out.println("Ship color: " + myGameScout.getColor());
        myGameScout.start();
        myGameScout.stop();

        System.out.println("Ship type: " + myGameDestroyer.getInvaders());
        System.out.println("Invader count: " + myGameDestroyer.getInvaders());
        System.out.println("Obstacle count: " + myGameDestroyer.getObstacles());
        System.out.println("Powerup count: " + myGameDestroyer.getPowerups());
        System.out.println("Health: " + myGameDestroyer.getHealth());
        System.out.println("Ammo: " + myGameDestroyer.getAmmo());
        System.out.println("Speed: " + myGameDestroyer.getSpeed());
        System.out.println("Ship color: " + myGameDestroyer.getColor());
        myGameDestroyer.start();
        myGameDestroyer.stop();

        System.out.println("Ship type: " + myGameFighter.getShiptype());
        System.out.println("Invader count: " + myGameFighter.getInvaders());
        System.out.println("Obstacle count: " + myGameFighter.getObstacles());
        System.out.println("Powerup count: " + myGameFighter.getPowerups());
        System.out.println("Health: " + myGameFighter.getHealth());
        System.out.println("Ammo: " + myGameFighter.getAmmo());
        System.out.println("Speed: " + myGameFighter.getSpeed());
        System.out.println("Ship color: " + myGameFighter.getColor());
        myGameFighter.start();
        myGameFighter.stop();
    }
}