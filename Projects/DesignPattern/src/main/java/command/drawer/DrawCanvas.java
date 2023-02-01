/**
 * @Author : ungpung0
 * @Date    : 23/02/01
 * @Feature : 그리는 대상을 구현하는 클래스.
 **/

package command.drawer;

import command.commands.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    // 색상
    private Color color;
    // 반지름
    private int radius = 6;
    // 명령 이력
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.WHITE);
        this.history = history;
    }

    /**
     * 이력의 명령을 재실행하는 메서드.
     * @param g
     *      Graphics
     */
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    /**
     * Graphics 요소를 사용하여 그림을 그리는 메서드.
     * @param x
     *          x 좌표
     * @param y
     *          y 좌표
     */
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}

/*
    이 클래스는 Receiver(수신자) 역할을 수행한다.
    Receiver는 Command의 실행 대상으로 명령의 수신자이다.
 */
