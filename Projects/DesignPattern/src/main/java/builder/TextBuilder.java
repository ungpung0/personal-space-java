/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : 텍스트를 출력하기 위해서 Builder를 구현한다.
 **/

package builder;

public class TextBuilder extends Builder {
    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * 텍스트의 틀을 짜는 메서드.
     * @param title
     *          텍스트 제목
     **/
    @Override
    public void makeTitle(String title) {
        stringBuilder.append("==============================\n");
        stringBuilder.append("[");
        stringBuilder.append(title);
        stringBuilder.append("]\n\n");
    }

    /**
     * 텍스트에 단락을 추가하는 메서드.
     * @param string
     *          추가할 단락
     **/
    @Override
    public void makeString(String string) {
        stringBuilder.append("■");
        stringBuilder.append(string);
        stringBuilder.append("\n\n");
    }

    /**
     * 텍스트에 요소를 추가하는 메서드.
     * @param items
     *          추가할 요소
     **/
    @Override
    public void makeItems(String[] items) {
        for(String string : items) {
            stringBuilder.append(" .");
            stringBuilder.append(string);
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
    }

    /**
     * 텍스트를 마무리하는 메서드.
     **/
    @Override
    public void close() {
        stringBuilder.append("==============================\n");
    }

    /**
     * 완성된 텍스트를 출력하는 메서드.
     **/
    public String getTextResult() {
        return stringBuilder.toString();
    }
}

/*
    이 클래스는 '구체적인 건축가(Builder)' 역할을 수행한다.
    실제 인스턴스를 생성할 때 호출되는 메서드를 구현하여 결과를 얻는다.
*/