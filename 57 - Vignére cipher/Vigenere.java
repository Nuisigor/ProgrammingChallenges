/**
 * Vigenere
 */
public class Vigenere {

    public static void main(String[] args) {
        String word = "WORD";
        String key = "KE";
        String cipher = vigenereEncrypt(word, key);
        vigenereDecrypt(cipher, key);
    }

    public static String vigenereEncrypt(String word, String key){
        StringBuilder cipher = new StringBuilder();
        for(int i = 0; i < word.length() ; i++){
            int letterNumber = (int)word.charAt(i) - 65; 
            int keyNumber = (int)(key.charAt(i%key.length())) - 65;
            int cipheredLetter = ((letterNumber+keyNumber)%26) + 65;
            cipher.append((char)cipheredLetter);
        }
        System.out.println(cipher.toString());
        return cipher.toString();
    }

    public static String vigenereDecrypt(String cryptedWord, String key){
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < cryptedWord.length(); i++){
            int cryptedLetter = (int)cryptedWord.charAt(i) - 65;
            int keyNumber = (int)key.charAt(i%key.length()) - 65;
            int wordLetter = cryptedLetter - keyNumber < 0 ? (cryptedLetter - keyNumber) + 26 + 65 : (cryptedLetter - keyNumber)%26 + 65;
            word.append((char)wordLetter);
        } 
        System.out.println(word.toString());
        return "";
    }
}