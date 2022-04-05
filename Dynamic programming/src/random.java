import java.util.Arrays;

public class random {
    public static void main(String[] args) {


        System.out.println(isLongPressedName("a",
                "b"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j =0;

        if(name.length()==1) {
            while (j < typed.length()) {
                if (name.charAt(i) == typed.charAt(j)) {
                    return true;
                }
                j++;
            }
            return false;
        }



        while(j<typed.length()&&i<name.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i=(i<name.length()-1)? i+1:i;
                j++;
                continue;
            }
            j++;
        }
        if(i!=name.length()-1)return false;
        return true;
    }
}
