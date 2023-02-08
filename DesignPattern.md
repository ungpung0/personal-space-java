# 디자인 패턴(Design Pattern)

# 목차
- [디자인 패턴(Design Pattern)](#디자인-패턴design-pattern)
- [목차](#목차)
- [생성 패턴(Creational Pattern)](#생성-패턴creational-pattern)
  - [1. 팩토리 메서드(Factory Method)](#1-팩토리-메서드factory-method)
  - [2. 추상 팩토리(Abstract Factory)](#2-추상-팩토리abstract-factory)
  - [3. 빌더(Builder)](#3-빌더builder)
  - [4. 프로토타입(Prototype)](#4-프로토타입prototype)
  - [5. 싱글턴(Singleton)](#5-싱글턴singleton)
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

## 3. 빌더(Builder)

## 4. 프로토타입(Prototype)

## 5. 싱글턴(Singleton)

---

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

