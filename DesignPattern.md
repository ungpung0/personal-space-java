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

## 1. 어댑터(Adapter)

## 2. 브리지(Bridge)

## 3. 복합체(Composite)

## 4. 데코레이터(Decorator)

## 5. 퍼사드(Facade)

## 6. 플라이웨이트(FlyWeight)

## 7. 프록시(Proxy)

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

