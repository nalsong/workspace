package edu.kh.game.dto;
import java.util.Objects;

public class Floor {
   private String name;
   private int floor;
   
   public Floor() {
      super();
   }

   public Floor(String name, int floor) {
      super();
      this.name = name;
      this.floor = floor;
   }

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getFloor() {
      return floor;
   }
   public void setFloor(int floor) {
      this.floor = floor;
   }
   
   
   

}