/**
 * @Author : ungpung0
 * @Date    : 23/01/11
 * @Feature : Link, Tray, Page의 인스턴스를 생성한다.
 **/

package abstractfactory.factory;

public abstract class Factory {
    /**
     * 클래스명을 이용하여 구체적인 인스턴스를 생성하는 메서드.
     * @param classname
     *          클래스명
     **/
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class
                    .forName(classname)       // 클래스명 불러오기.
                    .getDeclaredConstructor() // 단일 매개변수를 갖는 모든 생성자에 접근.
                    .newInstance();           // 새로운 인스턴스 생성.
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }
    /**
     * Link를 생성하여 반환하는 메서드.
     * @param caption
     *          표제어
     * @param url
     *          링크 URL
     **/
    public abstract Link createLink(String caption, String url);

    /**
     * Tray를 생성하여 반환하는 메서드.
     * @param caption
     *          표제어
     **/
    public abstract Tray createTray(String caption);

    /**
     * Page를 생성하여 반환하는 메서드.
     * @param title
     *          페이지명
     * @param author
     *          작성자명
     **/
    public abstract Page createPage(String title, String author);
}
/*
    이 클래스 '추상적인 공장(Abstract Factory)' 역할을 수행한다.
    추상적인 제품(Abstract Product)의 인스턴스를 생성하기 위한 API를 결정한다.
 */
