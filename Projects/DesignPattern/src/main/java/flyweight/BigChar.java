/**
 * @Author : ungpung0
 * @Date    : 23/01/31
 * @Feature : 큰 문자를 나타내는 클래스.
 **/

package flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    private char charname;
    private String fontdata;

    /*
        1) big(숫자).txt를 불러와서 fontdata에 추가한다.
        2) 예외가 발생할 경우 fondata 내용을 charname?으로 한다.
     */
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for(String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        }catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    /**
     * 텍스트를 콘솔 출력하는 메서드.
     **/
    public void print() {
        System.out.print(fontdata);
    }
}

/*
    이 클래스는 FlyWeight(플라이급) 역할을 수행한다.
    FlyWeight는 일반적으로 사용할 경우 무거워지기 때문에, 공유가 권장된다.
 */
