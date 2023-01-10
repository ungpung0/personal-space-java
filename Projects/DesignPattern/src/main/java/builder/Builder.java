/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : Builder 인스턴스를 생성하기 위한 인터페이스를 결정한다.
 **/

package builder;

public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String string);

    public abstract void makeItems(String[] items);

    public abstract void close();
}

/*
    이 클래스는 '건축가(Builder)' 역할을 수행한다.
    건축가가 결정한 메서드들은 '구체적인 건축가(Concrete Builder)'가 구현한다.
*/