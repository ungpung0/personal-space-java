/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : 인터페이스를 사용하여 인스턴스를 생성한다.
 **/

package builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 인터페이스의 형식에 맞추어 건축하는 메서드.
     **/
    public void construct() {
        builder.makeTitle("Greetings");
        builder.makeString("기본적인 인사법");
        builder.makeItems(new String[] {
                "How are you?",
                "Hello.",
                "Hi.",
        });
        builder.makeString("시간대별 인사법");
        builder.makeItems(new String[] {
                "Good Mornings",
                "Good Afternoon",
                "Good Evening",
        });
        builder.close();
    }
}

/*
    이 클래스는 '감독관(Director)' 역할을 수행한다.
    감독관은 인스턴스를 생성하며, 건축가의 메서드만을 사용하여 의존성을 제거해야만 한다.
*/
