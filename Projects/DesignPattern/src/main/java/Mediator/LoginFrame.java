/**
 * @Author : ungpung0
 * @Date    : 23/01/28
 * @Feature : Mediator를 구현하여 로그인 대화상자를 나타내는 클래스.
 **/

package Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);

        // 배경색을 옅은 회색으로 설정한다.
        setBackground(Color.LIGHT_GRAY);

        // 레이아웃 매니저를 사용하여 4 * 2 그리드를 생성한다.
        setLayout(new GridLayout(4, 2));

        // Colleague를 생성한다.
        createColleague();

        // 프레임에 Colleague를 배치한다.
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged();

        // 프레임을 표시한다.
        pack();
        setVisible(true);
    }

    /**
     * Colleague를 생성하는 메서드.
     **/
    @Override
    public void createColleague() {
        // CheckBox를 설정한다.
        CheckboxGroup group = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", group, true);
        checkLogin = new ColleagueCheckbox("Login", group, false);

        // TextField를 설정한다.
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        // Button을 설정한다.
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다.
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener를 설정한다.
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    /**
     * Colleague의 상태가 바뀔 경우 호출하는 메서드.
     */
    @Override
    public void colleagueChanged() {
        if(checkGuest.getState()) {
            // 게스트 로그인의 경우.
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        }else {
            // 사용자 로그인의 경우.
            textUser.setColleagueEnabled(true);
            userPassChanged();
        }
    }

    /**
     * 유저 텍스트와 패스워드 텍스트에 변경이 있을 경우 검증하는 메서드.
     */
    private void userPassChanged() {
        if(textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);

            if(textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            }else {
                buttonOk.setColleagueEnabled(false);
            }
        }else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    /**
     * 액션 이벤트를 콘솔창에 출력하고 종료하는 메서드.
     * @param e
     *          액션 이벤트
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}

/*
    이 클래스는 Concrete Mediator(구체적인 중재자) 역할을 수행한다.
    Concrete Mediator는 Mediator의 API를 구현한다.
 */