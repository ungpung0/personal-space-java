/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : 연습문제 풀이, 추상화 클래스 Builder를 인터페이스로 변환한다.
 **/

package builder.practiece;

public interface Builder {
    public void makeTitle(String title);

    public void makeString(String string);

    public void makeItems(String[] items);

    public void close();
}
