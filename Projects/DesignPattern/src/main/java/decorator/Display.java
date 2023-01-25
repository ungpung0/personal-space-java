/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 문자열을 표시하는 추상 클래스.
 **/

package decorator;

public abstract class Display {
    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    /**
     * 모든 행을 표시하는 메서드.
     **/
    public void show() {
        for(int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}

/*
    이 추상 클래스는 Component(컴포넌트) 역할을 수행한다.
    Component는 프로그램 틀의 인터페이스를 결정한다.
 */
