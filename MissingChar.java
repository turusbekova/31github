package ghlChallenge;


    public class MissingChar {
        public static void main(String[] args) {
            System.out.println(missingChar("kitten", 1));  // "ktten"
            System.out.println(missingChar("kitten", 0));  // "itten"
            System.out.println(missingChar("kitten", 4));  // "kittn"
        }

        public static String missingChar(String str, int n) {
            if (n >= 0 && n < str.length()) {
                return str.substring(0, n) + str.substring(n + 1);
            } else {

                System.out.println("Invalid index!");
                return str;
            }
    }

}
