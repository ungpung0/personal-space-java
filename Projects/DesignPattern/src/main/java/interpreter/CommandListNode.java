/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : <command list>에 대응하는 클래스.
 **/

package interpreter;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends Node {
    private List<Node> list = new ArrayList<>();

    /**
     * 남은 토큰이 없으면 end 메시지를 붙여 예외를 던지는 메서드.
     * @param context
     *          Context
     */
    @Override
    public void parse(Context context) throws ParseException {
        while(true) {
            if(context.currentToken() == null) {
                throw new ParseException("Error: Missing 'end'");
            }else if(context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            }else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
