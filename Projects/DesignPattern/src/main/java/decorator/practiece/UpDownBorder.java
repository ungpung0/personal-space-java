/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 연습 문제 풀이, 상하에만 장식틀을 붙이는 클래스.
 **/

package decorator.practiece;

import decorator.Border;
import decorator.Display;

public class UpDownBorder extends Border {
    public UpDownBorder(Display display) {
        super(display);
    }

    /**
     * 문자열의 가로 길이를 반환하는 메서드.
     **/
    @Override
    public int getColumns() {
        return display.getColumns();
    }

    /**
     *  문자열의 세로 길이에 상하의 2를 더하여 반환하는 메서드.
     **/
    @Override
    public int getRows() {
        return display.getRows() + 2;
    }

    /**
     * 특정 행째 문자열의 좌우를 특정 문자로 감싸고 반환하는 메서드.
     * @param row
     *      조회할 행
     **/
    @Override
    public String getRowText(int row) {
        if(row == 0 || row == (display.getRows()+ 1)) {
            return makeLine('-', display.getColumns());
        }else {
            return display.getRowText(row - 1);
        }
    }

    /**
     * 문자열의 길이에 맞추어 상하 장식틀을 생성하는 메서드.
     * @param ch
     *          특정한 문자
     * @param count
     *          반복 횟수
     **/
    private String makeLine(char ch, int count) {
        StringBuilder line = new StringBuilder();
        for(int i = 0; i < count; i++) {
            line.append(ch);
        }
        return line.toString();
    }
}

/*
    이 클래스는 Concrete Decorator(구체적인 장식자) 역할을 수행한다.
    Concrete Decorator는 Decorator의 인터페이스를 실제로 구현한다.
 */