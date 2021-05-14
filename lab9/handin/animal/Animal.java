//Submitted by Kyle Bush

public abstract class Animal{
   private String type;
   public Animal(String type){
       this.type=type;
   }
   public String getType(){
       return type;
   }
   public abstract void move();
   public abstract String call();
}