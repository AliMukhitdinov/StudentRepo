package util;

import java.util.Scanner;

public interface Input {
    static String inputString(String msg){
        System.out.println(msg);
        return new Scanner(System.in).nextLine();
    }
    static Integer inputNum(String msg){
        System.out.println(msg);
        return new Scanner(System.in).nextInt();
    }
}
