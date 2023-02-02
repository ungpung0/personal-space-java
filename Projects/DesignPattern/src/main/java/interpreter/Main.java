/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package interpreter;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            for (String text : Files.readAllLines(Path.of("program.txt"))) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
