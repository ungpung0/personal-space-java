/**
 * @Author : ungpung0
 * @Date    : 23/02/02
 * @Feature : <primitive command>에 대응하는 클래스.
 **/

package interpreter;

import java.text.ParseException;

public class PrimitiveCommandNode extends Node {
    private String name;

    /**
     * 특정 command를 수행하는 메서드.
     * @param context
     */
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        if(name == null) {
            throw new ParseException("Error: Missing <primitive command>");
        }else if(!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
        }
        context.skipToken();
    }

    @Override
    public String toString() {
        return name;
    }
}
