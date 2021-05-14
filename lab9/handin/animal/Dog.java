public class Dog extends Animal{
   public Dog(){
       super("Dog");
   }

   @Override
   public void move(){
       System.out.println(this.getType()+" runs");
   }

   @Override
   public String call(){
       return "roof roof";
   }
}
