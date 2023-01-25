/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 연습 문제 풀이, 여러 행으로 구성된 문자열 표시용 클래스.
 **/

package decorator.practiece;

import decorator.Display;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    private List<String> strings = new ArrayList<>();
    private int columns = 0;

    /**
     * 문자열을 리스트에 추가하는 메서드.
     * @param string
     *          추가할 문자열
     **/
    public void add(String string) {
        strings.add(string);
        if(columns < string.length()) {
            columns = string.length();
        }
        addPaddings();
    }

    /**
     * 문자열의 최대 가로 길이를 반환하는 메서드.
     **/
    @Override
    public int getColumns() {
        return columns;
    }

    /**
     * 문자열의 세로 길이를 반환하는 메서드.
     **/
    @Override
    public int getRows() {
        return strings.size();
    }

    /**
     * 특정 행째 문자열을 반환하는 메서드.
     * @param row
     *          조회할 행
     **/
    @Override
    public String getRowText(int row) {
        return strings.get(row);
    }

    /**
     * spaces()를 호출하여 기존 문자열에 공백을 추가하는 메서드.
     **/
    private void addPaddings() {
        for(int i = 0; i < strings.size(); i++) {
            String line = strings.get(i);
            int padding = columns - line.length();
            if(padding > 0) {
                strings.set(i, line + spaces(padding));
            }
        }
    }

    /**
     * 주어진 길이 만큼의 공백 문자열을 반환하는 메서드.
     * @param count
     *          주어진 길이
     **/
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for(int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}

/*
    이 클래스는 Concrete Component(구체적인 컴포넌트) 역할을 수행한다.
    Concrete Component는 Component의 인터페이스를 실제로 구현한다.
 */