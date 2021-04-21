public class CaesarCypher{
    public static String encrypt(String message, int key){
        char[] characters = message.toCharArray();
        String encryptString = "";
        for (char character:characters){
            encryptString += (char)(character+key);
        }
        return encryptString;
    }

    public static String decrypt(String message, int key){
        char[] characters = message.toCharArray();
        String decryptString = "";
        for (char character: characters){
            decryptString += (char)(character-key);
        }
        return decryptString;
    }
}