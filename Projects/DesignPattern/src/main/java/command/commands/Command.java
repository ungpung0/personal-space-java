/**
 * @Author : ungpung0
 * @Date    : 23/02/01
 * @Feature : 명령을 표현하는 인터페이스.
 **/

package command.commands;

public interface Command {
    public abstract void execute();
}

/*
    이 인터페이스는 Command(명령) 역할을 맡는다.
    Command는 명령의 인터페이스를 정의한다.
 */