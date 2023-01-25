/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 좌우에만 장식틀을 붙이는 클래스.
 **/

package decorator;

public class SideBorder extends Border {
    private char borderChar;

    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    /**
     * 문자열의 가로 길이에 좌우의 2를 더하여 반환하는 메서드.
     **/
    @Override
    public int getColumns() {
        return display.getColumns() + 2;
    }

    /**
     *  문자열의 세로 길이를 반환하는 메서드.
     **/
    @Override
    public int getRows() {
        return display.getRows();
    }

    /**
     * 특정 행째 문자열의 좌우를 특정 문자로 감싸고 반환하는 메서드.
     * @param row
     *      조회할 행
     **/
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}

/*
    이 클래스는 Concrete Decorator(구체적인 장식자) 역할을 수행한다.
    Concrete Decorator는 Decorator의 인터페이스를 실제로 구현한다.
 */