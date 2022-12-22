
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;// used to search through a text for multiple occurrences of a regular expression
import java.util.regex.Pattern;// used to defining String patterns that can be used for searching

public class singleWordCounter {
    public static void main(String[] args) {
        String sentence = "Happy hour hour class class classs "
                + "Do you you go go go go to the the gym "
                + "Okey okey bro Bro";

        modified_sentence(sentence);
    }
    public static void modified_sentence(String s) {

        // special character check
        Pattern p = Pattern.compile("[^A-Za-z]");//created a regex pattern and defined the String pattern
        Matcher m = p.matcher(s);// Searching and matching the String within the pattern we defined using matcher.
        s= m.replaceAll(" ");// Expressions not included in the pattern were found with the matcher and replaced with " ".

        // counting unique words
        s = s.toLowerCase();// changed all letters to lowercase so that only the same words with a capital letter count as unique.
        String words[] = s.split(" ");// Using the "split" method to count the words in the sentence, all the words were split from the phrase " ".
        List<String> uniqueWords = new ArrayList<>();// created a list for unique words
	    /*
	     created two for loops, initialized as counter = 1.
	     The first for loop was started from the first word, the second for loop was started from the second word,
	     and passed forward one at a time. So it worked as long as the length of the 'word' string. Each time the words were compared.
	     If the same word is found more than once, the 'counter' value is increased by one and the second of the same words is changed to '-'.
	    */
        for (int i = 0; i < words.length; i++) {
            int counter = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    counter++;
                    words[j] = "-";
                }
            }

	      /*
	       if 'counter' is greater than 0 and the word is not equal to "-" and the word is not empty (matched as a special character and not deleted)
	      */
            if (counter > 0 && (!words[i].equals("-"))&&(!words[i].equals(""))) {
                System.out.println(words[i] + " " + counter);

                //  creating new sentences with unique words
                uniqueWords.add(words[i]); // unique words are added to the uniqueWords list
            }
        }
	    /*
	     A new string named new_sentence was created and using the join method, unique words were combined with the character " " and output to the screen.
	    */
        String new_sentence = String.join(" ",uniqueWords);
        System.out.println("\nNew Sentence : "+new_sentence);

    }}
