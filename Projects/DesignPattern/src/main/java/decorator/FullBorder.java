/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 상하좌우에 장식틀을 붙이는 클래스.
 **/

package decorator;

public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    /**
     * 문자열의 가로 길이에 좌우의 2를 더하여 반환하는 메서드.
     **/
    @Override
    public int getColumns() {
        return display.getColumns() + 2;
    }

    /**
     *  문자열의 세로 길이에 상하의 2를 더하여 반환하는 메서드.
     **/
    @Override
    public int getRows() {
        return display.getRows() + 2;
    }

    /**
     * 특정 행째 문자열의 상하좌우를 특정 문자로 감싸고 반환하는 메서드.
     * 상하의 경우, makeLine()을 호출하여 문자열의 길이 만큼의 문자열을 생성하여 감싼다.
     * @param row 
     *          조회할 행
     **/
    @Override
    public String getRowText(int row) {
        if(row == 0) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        }else if(row == display.getRows() + 1) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        }else {
            return "|" + display.getRowText(row - 1) + "|";
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
