/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : <repeat command>에 대응하는 클래스.
 **/

package interpreter;

import java.text.ParseException;

public class RepeatCommandNode extends Node {
    private int number;
    private Node commandListNode;

    /**
     * 반복적으로 command를 수행하는 메서드.
     * @param context
     *          Context
     */
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
