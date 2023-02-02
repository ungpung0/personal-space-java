/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : 구문 트리의 '노드' 클래스.
 **/

package interpreter;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
