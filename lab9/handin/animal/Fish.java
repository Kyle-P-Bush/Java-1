public class Fish extends Animal{
   public Fish(){
       super("Fish");
   }

   @Override
   public void move(){
       System.out.println(this.getType()+" swims");
   }

   @Override
   public String call(){
       return "glub glub";
   }
}