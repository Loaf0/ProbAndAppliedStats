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

    public void addToRange(char[]... ranges){
        for (char[] c : ranges){
            if(c.length != 2)
                continue;
            for (int i = c[0]; i <= c[1]; i++) {
                validCharacters.add((char) i);
            }
        }
    }

    public String getRandomString(int length){
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < length; i++){
            int randomIndex = (int) (Math.random() * validCharacters.size());
            output.append(validCharacters.get(randomIndex));
        }

        return output.toString();
    }

    public void setRangeAlphaNumeric(){
        setRange(new char[]{'A', 'Z'}, new char[]{'a', 'z'}, new char[]{'0', '9'});
    }

    public void setRangeNumeric(){
        setRange(new char[]{'0', '9'});
    }

    public void setRangeAlphabetical(){
        setRange(new char[]{'A', 'Z'}, new char[]{'a', 'z'});
    }

    public ArrayList<Character> getValidCharacters(){
        return validCharacters;
    }

}
