/**
 * @Author : ungpung0
 * @Date    : 23/02/01
 * @Feature : 복수의 명령을 모은 명령을 표현하는 인터페이스.
 **/

package command.commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // 명령어를 저장하는 목록 배열
    private Deque<Command> commands = new ArrayDeque<>();

    /**
     * 저장하고 있는 명령을 실행하는 메서드.
     */
    @Override
    public void execute() {
        for(Command command : commands)
            command.execute();
    }

    /**
     * 새로운 명령을 목록에 추가하는 메서드.
     * @param command
     *          추가할 명령
     */
    public void append(Command command) {
        if(command == this)
            throw new IllegalArgumentException("Infinite loop caused by append()");
        commands.push(command);
    }

    /**
     * 직전의 명령을 목록에서 삭제하는 메서드.
     */
    public void undo() {
        if(!commands.isEmpty())
            commands.pop();
    }

    /**
     * 목록의 모든 명령들을 삭제하는 메서드.
     */
    public void clear() {
        commands.clear();
    }
}

/*
    이 클래스는 Concrete Command(구체적인 명령) 역할을 수행한다.
    Concrete Command는 Command의 인터페이스를 구현한다.
 */
