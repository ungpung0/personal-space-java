/**
 * @Author : ungpung0
 * @Date    : 23/01/30
 * @Feature : Context를 구현하여 버튼, 화면 등의 UI를 나타낸다.
 **/

package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("Use");
    private Button buttonAlarm = new Button("Alarm");
    private Button buttonPhone = new Button("Phone");
    private Button buttonExit = new Button("Exit");
    private State state = DayState.getInstance();

    public SafeFrame(String title) {
        // 레이아웃 생성.
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        // textClock(현재시간) 배치.
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        // textScreen(경비센터) 배치.
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        // 패널 생성 및 버튼 배치.
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        // UI 표시.
        pack();
        setVisible(true);

        // 리스너 설정.
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    /**
     * 이벤트가 발생할경우 버튼과 대응하는 메서드를 호출하는 메서드.
     * @param e
     *          발생한 이벤트
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if(e.getSource() == buttonUse)
            state.doUse(this);
        else if(e.getSource() == buttonAlarm)
            state.doAlarm(this);
        else if(e.getSource() == buttonPhone)
            state.doPhone(this);
        else if(e.getSource() == buttonExit)
            System.exit(0);
        else
            System.out.println("?");
    }

    /**
     * 현재 시간을 설정하는 메서드.
     * @param hour
     *          시간
     **/
    @Override
    public void setClock(int hour) {
        String clockString = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
    }

    /**
     * 주간|야간 상태를 전환하는 메서드.
     * @param state
     *          상태
     **/
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서" + state + "으로 상태가 변화했습니다.");
        this.state = state;
    }

    /**
     * 경비 센터 메시지 출력하는 메서드.
     * @param message
     *          메시지
     **/
    @Override
    public void callSecurityCenter(String message) {
        textScreen.append("call! " + message + "\n");
    }

    /**
     * 경비 센터 기록을 출력하는 메서드.
     * @param message
     *          메시지.
     **/
    @Override
    public void recordLog(String message) {
        textScreen.append("record..." + message + "\n");
    }
}

/*
    이 클래스는 Context(문맥) 역할을 수행한다.
    Context 클래스는 Context 인터페이스를 상속하여 구체화한다.
 */