/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeshop;

/**
 *
 * @author akbermettoktobekova
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class CakeShop {
    
    private List<Cake> cakes;
    private int sold;
    
    public CakeShop(){
        this.cakes = new ArrayList<Cake>();
        sold = 0;
    }
    
    public void registerCake(Cake c){
        cakes.add(c);
    }
    
    public boolean sellCake(Cake c){
        if (cakes.remove(c)){
            sold++;
            return true;
        }
        return false;
    }
    
    public Cake findFirstCakeWithColor(String color){
        return cakes.stream()
                .filter(cake -> cake.color.equals(color))
                .findFirst()
                .orElse(null);
    }
    
    public Cake findLargestCake(){
        return cakes.stream()
                .max(Comparator.comparingDouble(a -> a.weight))
                .orElse(null);
    }

    public Cake findCheapestCake(){
        return cakes.stream()
                .max(Comparator.comparingDouble(a -> a.cost))
                .orElse(null);
    }
   
    public int countCakes(String color){
        return (int)  cakes.stream()
                .filter( cake -> cake.color.equals(color))
                .count();
    }
    
    public double calculateTotalWorth(){
        return (double) cakes.stream()
                .mapToDouble(cake -> cake.cost).sum();
    }
    
    public int totalSoldCakes(){
        return sold;
    }
}
