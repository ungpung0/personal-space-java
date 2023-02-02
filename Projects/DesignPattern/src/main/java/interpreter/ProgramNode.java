/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : <program>에 대응하는 클래스.
 **/


package interpreter;

public class ProgramNode extends Node {
    private Node commandListNode;

    /**
     * program 단어를 건너띄는 메서드.
     * @param context
     *          Context
     */
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
