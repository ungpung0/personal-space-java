/**
 * @Author : ungpung0
 * @Date    : 23/02/01
 * @Feature : 점 그리기 명령을 표현하는 클래스.
 **/

package command.drawer;

import command.commands.Command;

import java.awt.*;

public class DrawCommand implements Command {
    protected Drawable drawable;

    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    /**
     * 그리는 명령을 실행하는 메서드.
     */
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}

/*
    이 클래스는 Concrete Command(구체적인 명령) 역할을 수행한다.
    Concrete Command는 Command의 인터페이스를 구현한다.
 */
