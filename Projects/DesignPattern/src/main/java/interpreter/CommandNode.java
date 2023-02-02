/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : <command>에 대응하는 클래스.
 **/

package interpreter;

import java.text.ParseException;

public class CommandNode extends Node {
    private Node node;

    /**
     * "repeat command"는 RepeatCommandNode()를, "primitive command"는 PrimitiveCommandNode()를 생성하는 메서드.
     * @param context
     *          Context
     */
    @Override
    public void parse(Context context) throws ParseException {
        if(Context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        }else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
