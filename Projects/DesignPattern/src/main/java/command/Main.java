/**
 * @Author : ungpung0
 * @Date    : 23/02/01
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package command;

import command.commands.Command;
import command.commands.MacroCommand;
import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력
    private MacroCommand history = new MacroCommand();
    // 그림 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton = new JButton("Clear");

    public Main(String title) {
        super(title);

        // 리스너 설정
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        // 버튼 및 캔버스 레이아웃 배치
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        // 프로그램 보이기
        pack();
        setVisible(true);
    }

    /**
     * 마우스를 드래그할 때 발생하는 이벤트를 표현하는 메서드.
     * @param e
     *          마우스 이벤트
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Command command = new DrawCommand(canvas, e.getPoint());
        history.append(command);
        command.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * 우측 상단 종료 버튼의 이벤트를 표현하는 메서드.
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowClosed(WindowEvent e) {

    }

    @Override public void windowIconified(WindowEvent e) {

    }

    @Override public void windowDeiconified(WindowEvent e) {

    }

    @Override public void windowActivated(WindowEvent e) {

    }

    @Override public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}

/*
    이 클래스는 Client(의뢰자) 역할을 수행한다.
    Client는 Concrete Command를 생성하고, Receiver를 할당한다.
    
    또한 Invoker(호출자) 역할도 수행한다.
    Invoker는 Command의 API를 호출하여 명령을 실행한다.
 */
