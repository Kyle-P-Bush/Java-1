//
import java.util.Scanner;

public class SimBurger{

    //adjust variables to your personal game
    //threshold variables gauge the state of the resturant
    public static final int SERVICE_HIGH_THRESHOLD = 10;
    public static final int SERVICE_MID_THRESHOLD = 6;
    public static final int SERVICE_LOW_THRESHOLD = 3;

    public static final int CLEAN_HIGH_THRESHOLD = 10;
    public static final int CLEAN_MID_THRESHOLD = 6;
    public static final int CLEAN_LOW_THRESHOLD = 3;

    public static final int GAME_OVER_THRESHOLD = 12;

    private static Scanner input = new Scanner(System.in);

    /*Need to add these variables to the game*/
    //Initialize a global int variable to track the how clean the kitchen is 
    public static int cleanliness = 0;
    //Initialize a global int variable to track the customer's annoyance level
    public static int annoyance = 0;
    //Initialize a global int variable to track how much food is in the kitchen
    public static int food = 5;
    //Initialize a global int variable to track how many customers are served
    public static int served = 0;

    //These variables are used to increase difficulty
    private static int shoppingTime = 1;
    private static int cleaningTime = 1;
    private static int dirtinessRate = 1;
    private static int annoyanceRate = 1;
    
    //hasOrder track if a order has been taken
    private static boolean hasOrder = false;
    //madeOrder tracks if an order has been cooked
    private static boolean madeOrder = false;


    //main method
    public static void main(String[] args){
        gameLoop();
    }

    //CoreGameLoop
    public static void gameLoop(){
        boolean isRunning = true;
        startGame();
        while(isRunning){
            isRunning = checkGameState();
            if(isRunning){
                String choice =  menu();
                isRunning = runChoice(choice);
            }
        }
        gameOver();
    }

    /*change to fit your game*/
    //breif intro to the game
    public static void startGame(){
        //insert starting game information here
    }

    /*change to fit your game; you do not have to use these options*/
    //displayes all of the options that the player can do and returns their choice
    public static String menu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Take Order\n2. Make Order\n3. Serve Food");
        System.out.println("4. Buy Food\n5. Clean Kitchen\n[q|Q] to Quit Game.");
        return input.nextLine();
    }

    /*Change to fit your game: you do not have to use these methods*/
    //runs the choice that the user enters
    public static boolean runChoice(String choice){
        if(choice.equals("1")){
            takeOrder();
        } else if(choice.equals("2")){
            makeFood();
        } else if(choice.equals("3")){
            serveFood();
        } else if(choice.equals("4")){
            buyFood();
        } else if(choice.equals("5")){
            cleanKitchen();
        } else if(choice.equals("q") || choice.equals("Q")){
            return false;
        } else { 
            wasteTime();
        }
        /*after running the chosen method you might want to update the state of the game*/
        updateState();
        return true;
    }

    public static boolean takeOrder(){
        //if an order has not been taken or hasOrder equals false
        if(hasOrder == false){
            //print out that the order has been taken to the console
            System.out.println("The order has been taken!");
            //set hasOrder variable to true
            hasOrder = true;
            //set MadeOrder variable to false
            madeOrder = false;
            //increment annoyance level
            annoyance ++;
            return true;
        }
        //else if hasOrder is true
        else if(hasOrder == true){
            //print message stating that the player must finish the order first
            System.out.println("You must finish the other order first!");
            //call waste time method
            wasteTime();
        
        }
        return false;
    }
 
    
    public static void makeFood(){
        //if an order has been taken and the food stock is greater than 0
        if(hasOrder == true && food > 0){
            //print message to user about cooking food
            System.out.println("Food's cooking!");
            //set hasOrder to false;
            hasOrder = false;
            //set madeOrder to true;
            madeOrder = true;
            //add the dirtinessRate value to the kitchen cleanliness variable
            dirtinessRate ++;
            cleanliness++;
            //increment the annoyanceLevel variable
            annoyance ++;
            //decrement the food stock tracking variable
            food --;
        }
        else{
            //print to user that they can't do this
            System.out.println("You can't do this right now!");
            wasteTime();
        }
    }


    //insert serve food
    public static void serveFood(){
        //if the order has been made or madeOrder equals true
        if(madeOrder == true){
            //print serving message to player
            System.out.println("Food is served!");
            //call the customer satisfaction method
            customerSatisfaction();
            //set hasOrder to false
            hasOrder = false;
            //set madeOrder to false
            madeOrder = false;
            //increment the customers servered tracking variable
            served++;
            //set annoyance level to the annoyance rate (you could also subtract by the rate if you rather do it that way)
            annoyance = annoyanceRate;
        }
        else if(madeOrder == false){
            System.out.println("There is no order! You're wasting time!");
            wasteTime();
        }
    }
    

    public static void buyFood(){
        //print food purchasing message to player
        System.out.println("You bought some food!");
        //add food stock to the food stock variable
        food = food + 2;
        //increment the annoyanceLevel variable
        annoyance ++;
        //add shoppingTime variable to the annoyance rate (customers get annoyed waiting you you to shop)
        annoyanceRate = annoyanceRate + shoppingTime;


    }
    

    public static void cleanKitchen(){
        System.out.println("You've cleaned the kitchen!");
        //change cleanliness level by value (your choice) from cleaning
        cleanliness--;
        //increment the annoyanceLevel variable
        annoyance ++;
        //add cleaningTime variable to clean kitchen tracking variable (customers are annoyed waiting for you to clean)
        annoyanceRate = annoyanceRate + cleaningTime;
    }

    //wasteTime method
    public static void wasteTime(){
        //print time wasting message to player
        System.out.println("You're just wasiting time!");
        //increment annoyance level variable
        annoyance++;
    }

    public static void customerSatisfaction(){
        if(annoyance == SERVICE_HIGH_THRESHOLD){
            //display a very bad customer service message if the annoyance level is at the service high threshold
            System.out.println("Your customer service skills are the worst!");
        }
        else if(annoyance == SERVICE_MID_THRESHOLD){
            //display a not so great customer service message if the annoyance level is at the service mid threshold
            System.out.println("You could work on your customer service skills.");
        }
        else{
            //display a so so customer service message if the annoyance level is at the service mid threshold
            System.out.println("Your customer are very happy!");
        }
        
        //display a good customer service message if the annoyance level is at the service mid threshold
    }      

    public static void gameOver(){
        //print out any messages that you want to tell the player
        System.out.println("Game Over!");
        //let the player know how they did (customers served can be a good indicator)
        System.out.printf("You served %d customers!\n", served);
    }

    //checkGameState
    public static boolean checkGameState(){
        System.out.println("############################# State of the Restaurant ##############################");

        boolean continuePlaying = checkTurns();
        //both checkTurns method and checkCleanliness method must return true for continuePlaying variable to be true
        continuePlaying = continuePlaying && checkCleanliness();

        /*print food stock availability*/
        System.out.printf("\tYou can cook %d meal with your food stock.\n",food);
        System.out.println("###################################################################################\n");
        return continuePlaying;
    }


    /*Finish filling in this method*/
    public static boolean checkTurns(){
        //if annouance leve is at the game over threshold 
        if(annoyance == GAME_OVER_THRESHOLD){
            //message the user about thier angry customers
            System.out.print("\tYour customers are furious!");
            //return false (because we want to end the game loop)
            return false;
        }
        //else if the annoyance leve is at the service high threshold
        else if (annoyance == SERVICE_HIGH_THRESHOLD){
            //message the user about how they are not doing well 
            System.out.println("\tYour customers are getting frustrated!");
        }
        //else if the annoyance level is at the service mid threshold 
        else if(annoyance == SERVICE_MID_THRESHOLD){
            //message the user letting them know how they are doing
            System.out.println("\tIt seems the customers have been aren't too happy");
        }
        //else if the annoyance level is at the service low threshold 
        else if(annoyance == SERVICE_LOW_THRESHOLD){
            //message the user letting them know how they are doing
            System.out.println("\tThe customers need some attention.");
        }
        //else 
        else{
            //let the user know they are doing great
            System.out.println("\tYour customers are great!");
        }
           
        //return true to stay in the game    
        return true;
    }


    /*messages to the user should range on how clean the kitchen is based on the kitchen cleanliness level to the threshold*/
    public static boolean checkCleanliness(){
        //if kitchen cleanliness level is at the game over threshold 
        if(cleanliness == GAME_OVER_THRESHOLD){
            //message the user about how deisgusting the kitchen is
            System.out.print("\tThe kitchen got shut down by sanitation comitee!");
            //return false (because we want to end the game loop)
            return false;
        }
        //else if the kitchen cleanliness level is at the service high threshold
        else if(cleanliness == SERVICE_HIGH_THRESHOLD){
            //message the user about how they need to clean the kitchen 
            System.out.println("\tThe kitch is filthy! Clean it now!");
        }
        //else if the kitchen cleanliness level is at the service mid threshold 
        else if(cleanliness == SERVICE_MID_THRESHOLD){
            //message the user letting them know about the kitchen
            System.out.println("\tThe kitchen is pretty dirty!");
        }
        //else if the kitchen cleanliness level is at the service low threshold 
        else if(cleanliness == SERVICE_LOW_THRESHOLD){
            //message the user letting them know about the kitchen
            System.out.println("\tYour kitchen is starting to get dirty.");
        }
        else{
            //let the user know they are doing great
            System.out.println("\tYour kitchen looks great! Keep it up!");
        }
           
        //return true to stay in the game    
        return true;
    }

    //updateState method
    public static void updateState(){
        shoppingTime++;
        dirtinessRate++;
        annoyanceRate++;

        /*    
            this is the method that you alter the difficult of the game:
            you can change the difficulty by increasing the shoppingTime,
            dirtinessRate, annoyanceRate, and/or cleaningTime.
            
            You can also do things like decrease the amount of food you get
            from shopping and decrease the effect of cleaning the kitchen
        
            this is your game so change the state how you see fit

            (The modulus operator can come in handy here too)
        */
    }   

}//end class
