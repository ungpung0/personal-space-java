/**
 * @Author : ungpung0
 * @Date    : 23/01/07
 * @Feature : IDCardFactory에서 필요한 메서드를 결정한다.
 **/

package factory.framework;

public abstract class Factory {
    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);

    /**
     * 인스턴스의 생성에 필요한 메서드를 호출한다.
     * @param owner
     *          카드에 들어갈 사용자명
     **/
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
}

/*
    이 클래스는 '작성자(Creator)' 역할을 수행한다.
    작성자는 제품(Product)역을 생성한다. 실제 인스턴스를 생성하는 게 아닌 생성하는 메서드를 호출한다.
*/
