/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : 구문 해석 중에 발생하는 예외 클래스.
 **/

package interpreter;

public class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
    }
}
