# 디자인 패턴(Design Pattern)

# 목차
- [디자인 패턴(Design Pattern)](#디자인-패턴design-pattern)
- [목차](#목차)
- [생성 패턴(Creational Pattern)](#생성-패턴creational-pattern)
  - [1. 팩토리 메서드(Factory Method)](#1-팩토리-메서드factory-method)
  - [2. 추상 팩토리(Abstract Factory)](#2-추상-팩토리abstract-factory)
  - [3. 빌더(Builder)](#3-빌더builder)
  - [4. 프로토타입(Prototype)](#4-프로토타입prototype)
  - [5. 싱글톤(Singleton)](#5-싱글톤singleton)
- [구조 패턴(Structural Pattern)](#구조-패턴structural-pattern)
  - [1. 어댑터(Adapter)](#1-어댑터adapter)
  - [2. 브리지(Bridge)](#2-브리지bridge)
  - [3. 복합체(Composite)](#3-복합체composite)
  - [4. 데코레이터(Decorator)](#4-데코레이터decorator)
  - [5. 퍼사드(Facade)](#5-퍼사드facade)
  - [6. 플라이웨이트(FlyWeight)](#6-플라이웨이트flyweight)
  - [7. 프록시(Proxy)](#7-프록시proxy)
- [행동 패턴(Behavioral Pattern)](#행동-패턴behavioral-pattern)
  - [1. 책임 연쇄(Chain of Responsibility)](#1-책임-연쇄chain-of-responsibility)
  - [2. 커맨드(Command)](#2-커맨드command)
  - [3. 반복자(Iterator)](#3-반복자iterator)
  - [4. 중재자(Mediator)](#4-중재자mediator)
  - [5. 메멘토(Memento)](#5-메멘토memento)
  - [6. 옵서버(Observer)](#6-옵서버observer)
  - [7. 상태(State)](#7-상태state)
  - [8. 전략(Strategy)](#8-전략strategy)
  - [9. 템플릿 메서드(Template Method)](#9-템플릿-메서드template-method)
  - [10. 비지터(Visitor)](#10-비지터visitor)

---

# 생성 패턴(Creational Pattern)

생성 패턴은 인스턴스의 생성 절차를 추상화하는 패턴으로, 생성 및 합성 방법을 분리하기 위해서 인스턴스 간의 정보를 차단한다. 결과로서 코드의 <b>유연성</b>과 <b>재사용성</b>을 얻을 수 있다.

## 1. 팩토리 메서드(Factory Method)

<b>팩토리 메서드(Factory Method)</b>는 부모 클래스가 생성 인터페이스를 제공하고, 자식 클래스가 구현하여 객체의 유형을 변경할 수 있게 하는 생성 패턴이다.

<li>클래스 다이어그램</li>

![classdiagram_factory](https://user-images.githubusercontent.com/90200010/217437028-18e8f864-a10f-4e52-8592-e290c838e416.svg)

> <b>Product(제품)</b><br>
> 생성된 인스턴스가 가지고 있는 인터페이스를 결정하는 추상 클래스.

> <b>Creator(생산자)</b><br>
> Product 클래스를 생성하는 추상 클래스. Creator는 ConcreteCreator의 역할을 알 수 없다.

> <b>ConcreteProduct(구체적인 제품)</b><br>
> Product를 구현하여 구체적인 제품을 나타내는 클래스.

> <b>ConcreteCreator(구체적인 생산자)</b><br>
> Creator를 구현하여 구체적인 제품을 생산하는 클래스.

<li>코드 예제</li>

```java
public abstract class Milk {
    public abstract String getName();
}
```

<b>△ Product 역할을 수행하는 추상 클래스. 우유 이름을 반환하는 메서드를 결정한다.</b> 

```java
public class ChocolateMilk extends Milk {
    @Override
    public String getName() {
        return "초콜릿 우유";
    }
}
```

```java
public class StrawberryMilk extends Milk {
    @Override
    public String getName() {
        return "딸기 우유";
    }
}
```

```java
public class LowCalMilk extends Milk {
    @Override
    public String getName() {
        return "저지방 우유";
    }
}
```

<b>△ ConcreteProduct 역할을 수행하는 클래스들. Milk를 상속받고 메서드를 구현한다.</b> 

```java
public abstract class MilkCreator {
    public abstract Milk createMilk(String type);
}
```

<b>△ Creator 역할을 수행하는 추상 클래스. Milk 인스턴스를 반환하는 메서드를 결정한다.</b> 

```java
public class MilkCreatorViaType extends MilkCreator {
    @Override
    public Milk createMilk(String type) {
        Milk milk;

        if (type.equals("Chocolate"))
            milk = new ChocolateMilk();
        else if (type.equals("Strawberry"))
            milk = new StrawberryMilk();
        else
            milk = new LowCalMilk();

        return milk;
    }
}
```

<b>△ ConcreteCreator 역할을 수행하는 클래스. MilkCreator를 상속받아 파라미터에 따라서 다른 인스턴스를 반환하는 메서드를 구현한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        MilkCreator milkCreator = new MilkCreatorViaType();

        Milk chocolateMilk = milkCreator.createMilk("Chocolate");
        Milk strawberryMilk = milkCreator.createMilk("Strawberry");
        Milk lowcalMilk = milkCreator.createMilk("");

        System.out.println(chocolateMilk.getName());
        System.out.println(strawberryMilk.getName());
        System.out.println(lowcalMilk.getName());
    }
}
```
<b>△ 프로그램을 실행하는 Main 클래스.</b>


## 2. 추상 팩토리(Abstract Factory)

<b>추상 팩토리(Abstract Factory)</b>는 관련있는 객체들을 묶고, 조건에 따라서 객체를 생성하는 패턴이다. 팩토리 패턴은 연관된 객체들을 모으는 것에 집중한다.

<li>클래스 다이어그램</li>

![classdiagram_abstractfactory](https://user-images.githubusercontent.com/90200010/217687766-98ae0eda-c84c-4475-ae96-72750eba78a1.svg)

> <b>AbstractProduct(추상적인 제품)</b><br>
> 개별 생성한 인스턴스들이 가지고 있는 인터페이스를 결정하는 추상 클래스.

> <b>AbstractFactory(추상적인 공장)</b><br>
> AbstractProduct 클래스를 생성하는 메서드들을 결정하는 추상 클래스.

> <b>ConcreteProduct(구체적인 제품)</b><br>
> AbstractProduct를 구현하여 구체적인 제품을 나타낸다.

> <b>ConcreteFactory(구체적인 공장)</b><br>
> AbstractFactory의 생성 메서드를 ConcreteProduct에 대응하여 구현한다.

<li>코드 예제</li>

```java
public abstract class Shape {
    public abstract void draw();
}
```

<b>△ AbstractProduct 역할을 수행하는 추상 클래스. 모양을 설명하는 메서드를 결정한다.</b>

```java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle Shape");
    }
}
```

```java
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square Shape");
    }
}
```

<b>△ ConcreteProduct 역할을 수행하는 클래스. Shape를 상속받고 메서드를 구현한다.</b>

```java
public abstract AbstractFactory {
    public Shape getShape(String type);
}
```

<b>△ AbstractFactory 역할을 수행하는 클래스. Shape 인스턴스를 반환하는 메서드를 결정한다.</b>

```java
public class ShapeFactory implements AbstractFactory {
    @Override
    public Shape getShape(String type) {
        if(type.equals("Rectangle"))
            return new Rectangle();
        else if(type.equals("Square"))
            return new Square();
        return null;
    }
}
```

<b>△ ConcreteFactory 역할을 수행하는 클래스. Shape 인스턴스를 반환하는 메서드를 결정한다.</b>

```java
public class Provider {
    public static AbstractFactory getFactory(String type) {
        if(type.equals("Shape"))
            return new ShapeFactory();
        return null;
    }
}
```

<b>△ Client에 Factory를 제공하는 클래스. getFactory()는 파라미터로 주어진 String을 검사하여 인스턴스를 반환한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = Provider.getFactory("Shape");
        Shape rectangle = factory.getShape("Rectangle");
        Shape square = factory.getShape("Square");
        rectangle.draw();
        square.draw();
    }
}
```
<b>△ Client 역할을 수행하는 클래스.</b>

## 3. 빌더(Builder)

<b>빌더(Builder)</b> 패턴은 복잡한 객체를 생성하는 방법을 <b>정의</b>하는 클래스와 <b>표현</b>하는 클래스를 분리하여, 생성 절차를 규격화하는 패턴이다. 즉, Optional한 속성을 많이 갖는 객체들을 생성할 때 유리하다.

<li>클래스 다이어그램</li>

![classdiagram_builder](https://user-images.githubusercontent.com/90200010/218005487-bb8d4980-06b0-4c05-8296-5b49aba913fc.svg)

> <b>Builder(건축가)</b><br>
> Product를 구성하는 요소들을 생성할 때 필요한 메서드를 결정한다.

> <b>Director(감독관)</b><br>
> Builder 인터페이스를 사용하여 Product 인스턴스를 생성한다.

> <b>ConcreteBuilder(구체적인 건축가)</b><br>
> Builder의 메서드를 구현한다.

> <b>Product(제품)</b><br>
> Builder 패턴으로 완성된 결과물.

<li>코드 예제</li>

```java
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String string);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
```

<b>△ Builder 역할을 수행하는 클래스. 문서를 구성하기 위한 메서드를 결정한다.</b>

```java
public class TextBuilder extends Builder {
    private StringBuffer sb = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        sb.append("=========================\n");
        sb.append("'" + title + "'\n");
        sb.append("\n");
    }

    @Override
    public void makeString(String string) {
        sb.append("- " + string + "\n"); 
    }

    @Override
    public void makeItems(String[] items) {
        for(int i = 0; i < items.length; i++)
            sb.append("  - " + items[i] + "\n");
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("=========================\n");
    }

    public String getResult() {
        return sb.toString();
    }
}
```

```java
public class HtmlBuilder extends Builder {
    private String filename;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        }catch(IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title><head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String string) {
        writer.println("<p>" + string + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for(int i = 0; i < items.length; i++)
            writer.println("<li>" + items[i] + "</li>");
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult() {
        return filename;
    }
}
```

<b>△ ConcreteBuilder 역할을 수행하는 클래스. TextBuilder는 텍스트를, HtmlBuilder는 HTML 문서를 생성한다.</b>

```java
public class Guide {
    private Builder builder;

    public Guide(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("야유회에 대해서");
        builder.makeString("일시");
        builder.makeItems(new String[] {
            "2023/02/10", "11:00",
        });

        builder.makeString("장소");
        builder.makeItems(new String[] {
            "ooo 캠핑장",
        });
        
        builder.makeString("준비물");
        builder.makeItems(new String[] {
            "회비", "고기", "음료수",
        });

        builder.close();
    }
}
```

<b>△ Product 역할을 수행하는 클래스. 문서의 속성값을 설정한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.exit(0);
        }
        if(args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Guide guide = new Guide(textBuilder);
            guide.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        }else if(args[0].equals("html")) {
            HtmlBuilder htmlBuilder = new HtmlBuilder();
            Guide guide = new Guide(htmlBuilder);
            guide.construct();
            String filename = htmlBuilder.getResult();
            System.out.println(filename);
        }else {
            System.exit(0);
        }
    }
}
```

<b>△ 명령어에 따라서 프로그램을 실행한다.</b>

## 4. 프로토타입(Prototype)

<b>프로토타입(Prototype)</b> 패턴은 객체를 생성하는 자원을 절약하기 위해서 유사한 객체를 복사하고 수정하는 방법을 제공한다. 주로 Java에서는 clone()을 사용한다.

<li>클래스 다이어그램</li>

![classdiagram_prototype](https://user-images.githubusercontent.com/90200010/218251086-07867370-1d98-4fed-a45b-4fd0b063f416.svg)

> <b>Prototype(원형)</b><br>
> 인스턴스를 복사하여 새로운 인스턴스를 생성하는 메서드를 결정한다.

> <b>ConcretePrototype(구체적인 원형)</b><br>
> Prototype을 구현하여 새로운 인스턴스를 생성하는 메서드를 구현한다.

> <b>Client(사용자)</b><br>
> Prototype을 사용하여 새로운 인스턴스를 사용한다.

<li>코드 예제</li>

```java
public class Car implements Cloneable {
    private List<String> carList;

    public Car() {
        this.carList = new ArrayList<>();
    }

    public Car(List<String> carList) {
        this.carList = carList;
    }

    public List<String> getCarList {
        return carList;
    }

    public void addExample {
        this.carList.add("TRUCK");
        this.carList.add("SUV");
        this.carList.add("MUSCLE");
        this.carList.add("SPORTS");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Car(new ArrayList<>(this.carList));
    }
}
```

<b>△ Prototype 역할을 수행하는 클래스. 차량 목록을 다루는 클래스로 clone()을 오버라이드하여 인스턴스 복사 기능을 제공한다.</b>

```java
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car car1 =  new Car();
        car.addExample();

        Car car2 = (Car) car.clone();
        Car car3 = (Car) car.clone();

        List<String> car1List = car1.getCarList();
        List<String> car2List = car2.getCarList();
        List<String> car3List = car3.getCarList();

        car2List.add("TOY_CAR");
        car3List.remove("TRUCK");

        System.out.println(car1List);
        System.out.println(car2List);
        System.out.println(car3List);
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Car 인스턴스를 Clone()을 사용하여 여러 개 생성한다.</b>

## 5. 싱글톤(Singleton)

<li>클래스 다이어그램</li>

![classdiagram_singleton](https://user-images.githubusercontent.com/90200010/218276225-b53f78f9-e191-4390-bd59-46328cd09116.svg)

> <b>Singleton(싱글톤)</b><br>
> 자기 자신을 인스턴스로 생성하여 반환하는 메서드를 제공한다.

> <b>Client(사용자)</b><br>
> 싱글톤 인스턴스를 사용한다.

<li>코드 예제</li>

```java
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Instance Created...");
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```

<b>△ Singleton 역할을 수행하는 클래스. private static으로 스스로 인스턴스화하여 제공한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        Singleton object1 = Singleton.getInstance();
        Singleton object2 = Singleton.getInstance();

        if(object1 == object2)
            System.out.println("Object1 == Object2");
        else
            System.out.println("Object1 != Object2");
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Singleton 인스턴스를 제공받고 동일 여부를 출력한다.</b>

# 구조 패턴(Structural Pattern)

생성 패턴은 인스턴스의 생성 클래스와 객체를 조합하여 구조를 확장하는 패턴이다. 예를들어 독립적인 여러 인터페이스를 하나의 인터페이스로 묶어서 제공할 수 있다.

## 1. 어댑터(Adapter)

<b>어댑터(Adapter)</b> 패턴은 문제없이 동작하는 클래스를 단지 인터페이스 차이 때문에 사용할 수 없을 때, 사용하는 패턴이다.

<li>클래스 다이어그램</li>

![classdiagram_adapter](https://user-images.githubusercontent.com/90200010/218367031-576d7f16-2a6c-4661-9c79-b7996e23c11a.svg)

> <b>Adaptee(적응 대상자)</b><br>
> Adaptee는 변환이 필요한 대상 클래스이다.

> <b>Adapter(적응자)</b><br>
> Adapter는 Adaptee를 Target에 만족시키는 메서드를 제공한다.

> <b>Target(대상)</b><br>
> Target은 Client에서 필요로하는 메서드를 제공한다.

> <b>Client(사용자)</b><br>
> Target의 메서드를 사용한다.

<li>코드 예제</li>

```java
public class RGB {
    private byte[] images;

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }
}
```

<b>△ Adaptee 역할을 수행하는 클래스. 이미지를 설정 및 반환하는 메서드를 제공한다.</b>

```java
public class HDMI {
    private byte[] images;

    public HDMI(byte[] images) {
        this.images = images;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }
}
```

<b>△ Target 역할을 수행하는 클래스. 이미지를 설정 및 반환하는 메서드를 제공한다.</b>

```java
public interface Adapter {
    HDMI convertRGBtoHDMI(RGB rgb);
}
```

```java
public class HDMIConverter implements Adapter {
    @Override
    public HDMI ConvertRGBtoHDMI(RGB rgb) {
        return new HDMI(rgb.getImages());
    }
}
```

<b>△ Adapter 역할을 수행하는 클래스. RGB의 getImages를 사용하여 HDMI 인스턴스를 반환한다.</b>

```java
class Main {
    public static void main(String[] args) {
        byte[] images = "변환할 이미지 스트림".getBytes(StandardCharsets.UTF_8);
        RGB rgb = new RGB();
        rgb.setImages(images);

        HDMIConverter hdmiConverter = new HDMIConverter();
        HDMI result = hdmiConverter.convertRGBtoHDMI(rgb);
        
        assertEquals(result.getImages, images);
    }
}
```

<b>△ Client 역할을 수행하는 클래스. HDMIConverter를 사용하여 RGB 객체를 HDMI 객체로 변환한다.</b>

## 2. 브리지(Bridge)

<b>브리지(Bridge)</b> 패턴은 기능을 처리하는 클래스와 구현을 담당하는 클래스를 분리하여 독립적으로 사용할 수 있는 방법을 제시하는 패턴이다.

<li>클래스 다이어그램</li>

![classdiagram_bridge](https://user-images.githubusercontent.com/90200010/218489148-6ee5285b-ebf2-4467-8309-b3b808f71af3.svg)

> <b>Abstraction(추상화)</b><br>
> Abstraction은 기능 파트를 최상위 클래스.

> <b>RefinedAbstraction(개선된 추상화)</b><br>
> RefinedAbstraction은 Abstract에 기능을 추가하는 클래스.

> <b>Implementor(구현자)</b><br>
> Implementor는 구현 파트의 최상위 클래스.

> <b>ConcreteImplementor(구체적인 구현자)</b><br>
> ConcreteImplementor는 Implementor의 API를 구현하는 클래스.

<li>코드 예제</li>

```java
public abstract class Shape {
    private Drawing drawing;

    protected Shape(Drawing drawing) {
        this.drawing = drawing;
    }

    public abstract void draw();

    public void drawLine(int x, int y) {
        drawing.drawLine(x, y);
    }

    public void fill() {
        drawing.fill();
    }
}
```

<b>△ Abstraction 역할을 수행하는 추상 클래스. Drawing 인스턴스를 사용하여 구현 파트의 메서드를 호출한다.</b>

```java
public class Rectangle extends Shape {
    protected Rectangle(Drawing drawing) {
        super(drawing);
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle!");
    }
}

public class Circle extends Shape {
    protected Circle(Drawing drawing) {
        super(drawing);
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle!");
    }
}
```

<b>△ RefinedAbstraction 역할을 수행하는 클래스. Shape를 구현하여 사각형과 원의 기능을 분리하여 구현한다.</b>

```java
public interface Drawing {
    public void drawLine(int x, int y);

    public void fill();
}
```

<b>△ Implementor 역할을 수행하는 인터페이스. 구현 클래스를 위한 API를 정의한다.</b>

```java
public class DrawingRectangle implements Drawing {
    @Override
    public void drawLine(int x, int y) {
        System.out.println("Draw Rectangle Line from (" + x + "," + y + ")");
    }

    @Override
    public void fill() {
        System.out.println("Fill Rectangle!");
    }
}

public class DrawingCircle implements Drawing {
    @Override
    public void drawLine(int x, int y) {
        System.out.println("Draw Circle Line from (" + x + "," + y + ")");
    }

    @Override
    public void fill() {
        System.out.println("Fill Circle!");
    }
}
```

<b>△ ConcreteImplementor 역할을 수행하는 클래스. Drawing을 구현하여 사각형과 원을 그린다. (콘솔 출력)</b>

```java
public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(new DrawingRectangle());
        Shape circle = new Circle(new DrawingCircle());

        rectangle.drawLine(1, 2);
        rectangle.fill();
        rectangle.draw();

        System.out.println();

        circle.drawLine(3, 4);
        circle.fill();
        circle.draw();
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Rectangle과 Circle 객체를 생성한다.</b>

## 3. 복합체(Composite)

<b>복합체(Composite)</b> 패턴은 단일 객체와 복합 객체를 동일하게 취급할 수 있는 방법을 제시한다. 재귀적인 특성을 가지며, 트리 구조와 비슷한 형태를 가진다.

<li>클래스 다이어그램</li>

![classdiagram_composite](https://user-images.githubusercontent.com/90200010/218661720-b557e248-58e8-4207-8d26-c9b6c00c7dba.svg)

> <b>Leaf(잎)</b><br>
> Leaf는 다른 객체를 포함할 수 없는 단일 객체를 뜻한다.

> <b>Composite(복합체)</b><br>
> Composite는 Leaf, Composite를 포함할 수 있는 복합 객체를 뜻한다.

> <b>Component(컴포넌트)</b><br>
> Leaf과 Composite의 부모 클래스로, 둘을 동일하게 취급하기 위한 API를 제공한다.

> <b>Client(사용자)</b><br>
> Component를 활용하여 Composite 패턴의 프로그램을 실행한다.

<li>코드 예제</li>

```java
public abstract class Unit {
    private String name;

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(" + getSize() + ")";
    }

    public abstract int getSize();
}
```

<b>△ Component 역할을 수행하는 클래스. File과 Folder의 부모 역할을 맡은 추상 클래스이다.</b>

```java
public class File extends Unit {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
```

<b>△ Leaf 역할을 수행하는 클래스. 디렉토리에서 하나의 파일을 의미한다.</b>

```java
public class Folder extends Unit {
    private LinkedList<Unit> unitList = new LinkedList<Unit>();

    public Folder(String name) {
        super(name);
    }

    @Override 
    public int getSize {
        int size = 0;
        Iterator<Unit> iterator = unitList.iterator();

        while(iterator.hasNext()) {
            Unit unit = iterator.next();
            size += unit.getSize();
        }

        return size;
    }

    public boolean add(Unit unit) {
        unitList.add(unit);
        return true;
    }

    private void list(String indent, Unit unit) {
        if(unit instanceof File) {
            System.out.println(indent + unit);
        }else {
            Folder directory = (Folder)unit;
            Iterator<Unit> iterator = directory.unitList.iterator();
            System.out.println(indent + "+ " + unit);

            while(iterator.hasNext()) {
                list(indent + "    " + iterator.next());
            } 
        }
    }

    public void list() {
        list("", this);
    }
}
```

<b>△ Composite 역할을 수행하는 클래스. 디렉토리에서 하나 이상의 파일과 폴더를 포함할 수 있는 폴더를 의미한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.add(new File("a.txt", 1000));
        root.add(new File("b.txt", 2000));

        Folder sub1 = new Folder("sub1");
        root.add(sub1);
        sub1.add(new File("sa.txt", 100));
        sub1.add(new File("sb.txt", 4000));

        Folder sub2 = new Folder("sub2");
        root.add(sub2);
        sub1.add(new File("SA.txt", 250));
        sub1.add(new File("SB.txt", 340));

        root.list();

    }
}
```

<b>△ Client 역할을 수행하는 클래스. 디렉토리 구조를 생성하고 목록을 출력한다.</b>

## 4. 데코레이터(Decorator)

<b>데코레이터(Decorator)</b> 패턴은 객체의 결합을 통해서 기능을 동적으로 확장할 수 있는 방법을 제시하는 패턴이다.

<li>클래스 다이어그램</li>

![classdiagram_decorator](https://user-images.githubusercontent.com/90200010/219281805-e122d86f-70f5-42d1-9095-b9f929e46d12.svg)

> <b>Component(컴포넌트)</b><br>
> Component는 기능을 추가할 때의 기반 역할을 맡는다.

> <b>ConcreteComponent(구체적인 컴포넌트)</b><br>
> ConcreteComponent는 Component의 API를 구현한다.

> <b>Decorator(장식자)</b><br>
> Decorator는 Component와 ConcreteDecorator를 동일하게 처리하는 역할을 맡는다. 

> <b>ConcreteDecorator(구체적인 장식자)</b><br>
> ConcreteDecorator는 Decorator를 구체적으로 구현한다.

<li>코드 예제</li>

```java
public interface Noodle {
    public void addIngredient();
}
```

<b>△ Component 역할을 수행하는 인터페이스. 재료 추가 메서드를 선언한다.</b>

```java
public class Ramen implements Noodle {
    @Override
    public void addIngredient() {
        System.out.print("Add Ingredients: Noodles.");
    }
}
```

<b>△ ConcreteComponent 역할을 수행하는 클래스. Noodle의 메서드를 구현한다.</b>

```java
public class RamenDecorator implements Noodle {
    private Noodle noodle;

    public RamenDecorator(final Noodle noodle) {
        this.noodle = noodle;
    }

    @Override
    public void addIngredient() {
        noodle.addIngredient();
    }
}
```

<b>△ Decorator 역할을 수행하는 클래스. Noodle을 인스턴스로 가지며, 생성자를 통해 받아들인다.</b>

```java
public class ShinRamenDecorator extends Ramen {
    public ShinRamenDecorator(final Noodle noodle) {
        super(noodle);
    }

    @Override
    public void addIngredient() {
        super.addIngredient();
        System.out.print("Add Ingredients: Spicy Condiment.");
    }
}

public class NeoguriDecorator extends Ramen {
    public NeoguriDecorator(final Noodle noodle) {
        super(noodle);
    }

    @Override
    public void addIngredient() {
        super.addIngredient();
        System.out.print("Add Ingredients: Kelp.");
    }
} 
```

<b>△ ConcreteDecorator 역할을 수행하는 클래스. RamenDecorator의 Noodle 인스턴스와 메서드에 더하여, 새로운 재료를 출력한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        final Noodle ramen = new Ramen();
        ramen.addIngredient();
        System.out.println();

        final Noodle shinRamen = new ShinRamenDecorator(new Ramen());
        shinRamen.addIngredient();
        System.out.println();

        final Noodle neoguriRamen = new NeoguriDecorator(new Ramen());
        neoguriRamen.addIngredient();
        System.out.println();

        final Noodle shinNeoguriRamen = new NeoguriDecorator(ShinRamenDecorator(new Ramen()));
        shinNeoguriRamen.addIngredient();
        System.out.println();
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Decorator 패턴을 적용하여 라면 조합에 따라서 재료를 출력한다.</b>

## 5. 퍼사드(Facade)

<b>퍼사드(Facade)</b> 패턴은 복잡한 하위 시스템을 정리 및 종합하고, 사용자에게 API로서 제공하는 방식의 패턴이다.

<li>클래스 다이어그램</li>

![classdiagram_facade](https://user-images.githubusercontent.com/90200010/219294357-d2db4ce5-0881-4866-aa6a-a6669d893ded.svg)

> <b>Facade(정면)</b><br>
> Facade는 시스템을 구성하는 많은 역할을 위한 기타 클래스들을 정리 및 종합하여 API를 제공한다.

> <b>ETC(기타 클래스)</b><br>
> 기타 클래스들은 각자의 배역을 수행하며, Facade를 신경쓰지 않는다.

> <b>Client(사용자)</b><br>
> Client는 Facade 패턴의 프로그램을 실행한다.

<li>코드 예제</li>

```java
public class Computer {
    private boolean toggle = false;

    public void turnOn() {
        toggle = true;
        System.out.println("Computer On.");
    }

    public void turnOff() {
        toggle = false;
        System.out.println("Computer Off.");
    }

    public boolean isTurnedOn() {
        return toggle;
    }
}

public class Lights {
    private boolean toggle = false;

    public void turnOn() {
        toggle = true;
        System.out.println("Lights On.");
    }

    public void turnOff() {
        toggle = false;
        System.out.println("Lights Off.");
    }

    public boolean isTurnedOn() {
        return toggle;
    }
}

public class Radio {
    private boolean toggle = false;

    public void turnOn() {
        toggle = true;
        System.out.println("Radio On.");
    }

    public void turnOff() {
        toggle = false;
        System.out.println("Radio Off.");
    }

    public boolean isTurnedOn() {
        return toggle;
    }
}
```

<b>△ 기타 메서드 역할을 수행하는 클래스. Computer, Lights, Radio는 각자 독립적으로 작동한다.</b>

```java
public class Home {
    private Computer computer;
    private Lights lights;
    private Radio radio;

    public Home(Computer computer, Lights lights, Radio radio) {
        this.computer = computer;
        this.lights = lights;
        this.radio = radio;
    }

    public void arrive() {
        System.out.println("Arrive to Home!");
        if(!computer.isTurnedOn())
            computer.trunOn();
        if(!lights.isTurnedOn())
            lights.turnOn();
        if(!radio.isTurnedOn())
            radio.turnOn();
    }

    public void leave() {
        System.out.println("Leave from Home!");
        if(computer.isTurnedOn())
            computer.turnOff();
        if(lights.isTurnedOn())
            lights.turnOff();
        if(radio.isTurnedOn())
            radio.turnOff();
    }
}
```

<b>△ Facade 역할을 수행하는 클래스. Computer, Lights, Radio 클래스를 활용하여 API를 제공한다.</b>


```java
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Lights lights = new Lights();
        Radio radio = new Radio();
        
        Home home = new Home(computer, lights, radio);
        Home.arrive();
        System.out.println();
        Home.leave();
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Facade 패턴을 적용하여 집에 도착하고 떠났을 때 변경사항을 출력한다.</b>

## 6. 플라이웨이트(FlyWeight)

<li>클래스 다이어그램</li>

![classdiagram_flyweight](https://user-images.githubusercontent.com/90200010/219301130-c2df4d23-1f36-4172-a84e-65313c7993c1.svg)

> <b>Flyweight(플라이급)</b><br>
> Flyweight는 경량화를 위해서 공유할 클래스들의 API를 선언한다.

> <b>FlyweightFactory(플라이급 공장)</b><br>
> FlyweightFactory는 Flyweight 인스턴스를 생성하는 역할을 맡는다.

> <b>Client(사용자)</b><br>
> Client는 Flyweight 패턴의 프로그램을 실행한다.

<li>코드 예제</li>

```java
public interface Shape {
    public void draw();
}

public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle\n" + "Color: " + color + "X: " + x + "Y: " + y + "Radius: " + radius + "\n");
    }
}
```

<b>△ Flyweight, ConcreteFlyweight 역할을 수행하는 인터페이스, 클래스. 공유가 필요한 속성을 가지고 있다.</b>

```java
public class ShapeFactory {
    private static final HashMap<String, Circle> map = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)map.get(color);

        if(circle == null) {
            circle = new Circle(color);
            map.put(color, circle);
            System.out.println("Create New Circle.");
        }

        return circle;
    }

}
```

<b>△ FlyweightFactory 역할을 수행하는 클래스. Cicle 인스턴스를 생성하여 Map에 저장하고 반환한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        String[] colors = {"RED", "GREEN", "BLUE", "YELLOW"};

        for(int i = 0; i < 10; i++) {
            Circle circle = (Circle)ShapeFactory.getCircle(colors[(int)(Math.random() * 4)]);
            circle.setX((int)(Math.random() * 100));
            circle.setX((int)(Math.random() * 4));
            circle.setX((int)(Math.random() * 10));
            circle.draw();
        }
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Flyweight 패턴을 적용하여 Circle 객체를 10개 무작위 생성한다.</b>

## 7. 프록시(Proxy)

<li>클래스 다이어그램</li>

![classdiagram_proxy](https://user-images.githubusercontent.com/90200010/219504632-ad37308b-300d-4aa0-b06e-9a99cb509ee1.svg)

> <b>Subject(본인)</b><br>
> Subject는 Proxy와 RealSubject를 동일시하기 위한 API를 정의한다.

> <b>Proxy(대리인)</b><br>
> Proxy는 Client의 요청을 처리하되, 불가능하면 RealSubject에 위임한다.

> <b>RealSubject(실제 본인)</b><br>
> RealSubject는 Proxy가 처리가 불가능할 때, 위임받아 요청을 처리한다.

> <b>Client(사용자)</b><br>
> Client는 Proxy 패턴의 프로그램을 실행한다.

<li>코드 예제</li>

```java
public interface Image {
    public void displayImage();
}
```

<b>△ Subject 역할을 수행하는 인터페이스. ProxyImage와 RealImage에서 사용할 메서드를 정의한다.</b>

```java
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    private void loadFromDisk(String filename) {
        System.out.println(filename + " Loaded.");
    }

    @Override
    public void displayImage() {
        System.out.println(filename + " Displayed.");
    } 
}
```

<b>△ RealSubject 역할을 수행하는 클래스. ProxyImage로부터 호출되어 이미지명을 출력한다.</b>

```java
public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayImage() {
        if(realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.displayImage();
    }
}
```

<b>△ Proxy 역할을 수행하는 클래스. displayImage()에서 Realmage 인스턴스를 통해 RealImage.displayImage() 메서드를 호출한다.</b>

```java
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test1.png");
        Image image2 = new ProxyImage("test2.png");

        image1.displayImage();
        image2.displayImage();
    }
}
```

<b>△ Client 역할을 수행하는 클래스. Proxy 패턴을 적용하여 이미지명을 표시한다.</b>

---

# 행동 패턴(Behavioral Pattern)

## 1. 책임 연쇄(Chain of Responsibility)

## 2. 커맨드(Command)

## 3. 반복자(Iterator)

## 4. 중재자(Mediator)

## 5. 메멘토(Memento)

## 6. 옵서버(Observer)

## 7. 상태(State)

## 8. 전략(Strategy)

## 9. 템플릿 메서드(Template Method)

## 10. 비지터(Visitor)

---

