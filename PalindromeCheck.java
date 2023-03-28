public class PalindromeCheck {

    public boolean isPalindrome(String word){
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end)
        {
            if(charArray[start] != charArray[end])
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeCheck palindromeCheck = new PalindromeCheck();
//       boolean check = palindromeCheck.isPalindrome(new String("that"));
//        System.out.println(check);

        if(palindromeCheck.isPalindrome("that")){
            System.out.println("This String is Palindrome!!");
        }else
            System.out.println("This string is not palindrome:>");
    }
}
