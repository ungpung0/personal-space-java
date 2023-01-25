/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 한 행으로 구성된 문자열 표시용 클래스.
 **/

package decorator;

public class StringDisplay extends Display {
    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    /**
     * 문자열의 가로 길이를 반환하는 메서드.
     **/
    @Override
    public int getColumns() {
        return string.length();
    }

    /**
     * 문자열의 세로 길이를 반환하는 메서드. 한 줄로 가정하여 1을 반환한다.
     **/
    @Override
    public int getRows() {
        return 1;
    }

    /**
     * 특정 행째 문자열을 반환하는 메서드.
     * @param row
     *          조회할 행
     **/
    @Override
    public String getRowText(int row) {
        if(row != 0) {
            throw new IndexOutOfBoundsException();
        }
        return string;
    }
}

/*
    이 클래스는 Concrete Component(구체적인 컴포넌트) 역할을 수행한다.
    Concrete Component는 Component의 인터페이스를 실제로 구현한다.
 */