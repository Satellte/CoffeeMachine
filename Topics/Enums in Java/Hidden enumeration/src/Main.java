public class Main {

    public static void main(String[] args) {
        int counter = 0;
        for (Secret status : Secret.values()) {
            if (status.toString().startsWith("STAR")){
                counter++;
            }
        }// write your code here
        System.out.println(counter);
    }
}

/*sample enum for inspiration
enum Secret {
    STAR, CRASH, START, // ...
}*/
