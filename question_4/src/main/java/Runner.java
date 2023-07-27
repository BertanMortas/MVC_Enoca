public class Runner {
    /**
     * @author Bertan Mortas
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("*");
        for (int i = 0; i <= 8; i++) {
            if (i %2 == 0) {
                String str = "*";
                String repeatedString = str.repeat(i);
                System.out.println(repeatedString);
            }
        }
    }
}
