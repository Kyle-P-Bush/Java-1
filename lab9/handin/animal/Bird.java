public class Bird extends Animal{
   public Bird(){
       super("Bird");
   }
   @Override
   public void move(){
       System.out.println(this.getType()+" flies");

   }
   @Override
   public String call(){
       return "chirp chirp";
   }
}
