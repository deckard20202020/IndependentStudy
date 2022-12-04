package Ebay;

public class docString {
    public static void main(String[] args) {

        String docString = "Function 'some_function' has two arguments 'short_arg very_long_arg'. The 'very_long_argument' has a default value of 'CONSTANT_VALUE'. 'to_be_changed TO_NOT_CHANGED'";
        String answer = change(docString);
        System.out.println(answer);
    }

    private static String change(String docString) {

        String answer = " ";
        //split everything by " "
        String[] splitBySpace = docString.split(" ");

        for (int i = 0; i < splitBySpace.length; i++) {
            String edited = "";
            if (splitBySpace[i].contains("_")) {
                edited = editWord(splitBySpace[i]);
//                answer = answer + " " + edited;
            } else {
                edited = splitBySpace[i];
            }

            if (i == 0) {
                answer = answer + splitBySpace[0];
            } else {
                answer = answer + " " + edited;
            }


        }
        return answer;
    }

    private static String editWord(String s) {

        String answer = "";

        //check to see if all letters are capitalized
        boolean isCap = true;
        String cap = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != cap.charAt(i)) {
                isCap = false;
            }
        }

        if (isCap) {
            return s;
        }

        String[] splitBy_ = s.split("_");
        for (int i = 0; i < splitBy_.length; i++) {
            if (i == 0) {
                answer = answer + splitBy_[i];
            } else {
                String lower = splitBy_[i];
                lower = lower.substring(0,1).toUpperCase() + lower.substring(1);
                answer = answer + lower;
            }
        }

        return answer;
    }
}
