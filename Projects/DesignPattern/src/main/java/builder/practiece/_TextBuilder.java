/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : 연습문제 풀이, 텍스트 파일을 출력하기 위해서 인터페이스 Builder를 구현한다.
 **/

package builder.practiece;

public class _TextBuilder implements Builder {
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
