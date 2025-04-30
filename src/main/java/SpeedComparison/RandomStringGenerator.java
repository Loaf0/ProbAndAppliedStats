package SpeedComparison;

/*
 * @description Class that generates a random string of characters from a given range
 * @author Tyler Snyder
 */

import java.util.ArrayList;

public class RandomStringGenerator {

    ArrayList<Character> validCharacters;

    public RandomStringGenerator(){
        validCharacters = new ArrayList<>();
    }

    /*
     * set possible random characters to be used in random string generation
     * @param ranges an infinite number of character pairs to be used as ranges in string randomization
     */
    public void setRange(char[]... ranges){
        validCharacters = new ArrayList<>();
        for (char[] c : ranges){
            if(c.length != 2)
                continue;
            for (int i = c[0]; i <= c[1]; i++) {
                validCharacters.add((char) i);
            }
        }
    }

    /*
     * add possible random characters to be used in random string generation
     * @param ranges an infinite number of character pairs to be used as ranges in string randomization
     */
    public void addToRange(char[]... ranges){
        for (char[] c : ranges){
            if(c.length != 2)
                continue;
            for (int i = c[0]; i <= c[1]; i++) {
                validCharacters.add((char) i);
            }
        }
    }

    /*
     * get a random string from random characters
     * @param length the amount of characters in the string
     * @return a random string using the bounds range of characters
     */
    public String getRandomString(int length){
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < length; i++){
            int randomIndex = (int) (Math.random() * validCharacters.size());
            output.append(validCharacters.get(randomIndex));
        }

        return output.toString();
    }

    /*
     * set possible characters the ranges [A-Za-z0-9]
     */
    public void setRangeAlphaNumeric(){
        setRange(new char[]{'A', 'Z'}, new char[]{'a', 'z'}, new char[]{'0', '9'});
    }

    /*
     * set possible characters the ranges [0-9]
     */
    public void setRangeNumeric(){
        setRange(new char[]{'0', '9'});
    }

    /*
     * set possible characters the ranges [A-Za-z]
     */
    public void setRangeAlphabetical(){
        setRange(new char[]{'A', 'Z'}, new char[]{'a', 'z'});
    }

    /*
     * return an arraylist containing all valid characters
     */
    public ArrayList<Character> getValidCharacters(){
        return validCharacters;
    }

}
