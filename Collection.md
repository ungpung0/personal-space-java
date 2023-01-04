<h2>Collection</h2>

<p>Java에서 컬렉션(Collection)은 다양한 목록형 데이터를 처리할 때 사용하는 상위 프레임워크이다. 검색, 정렬, 삽입, 수정, 삭제 등의 기능을 아래 표의 메서드를 통해 간편하게 제공한다.</p>

<table>
    <th>메서드명</th>
    <th>설명</th>
    <tr>
        <td>boolean add(Element)</td>
        <td>요소를 추가한다.</td>
    </tr>
    <tr>
        <td>boolean addAll(Collection)</td>
        <td>컬렉션의 모든 요소를 추가한다.</td>
    </tr>
    <tr>
        <td>boolean contains(Object)</td>
        <td>컬렉션의 객체 포함 여부를 반환한다.</td>
    </tr>
    <tr>
        <td>boolean containsAll(Collection)</td>
        <td>매개변수 컬렉션의 모든 요소들의 포함 여부를 반환한다.</td>
    </tr>
    <tr>
        <td>boolean equals(Object)</td>
        <td>객체와 매개변수 객체의 동일 여부를 반환한다.</td>
    </tr>
    <tr>
        <td>boolean isEmpty()</td>
        <td>빈 컬렉션인지 여부를 반환한다.</td>
    </tr>
    <tr>
        <td>Iterator iterator()</td>
        <td>컬렉션의 반복자를 반환한다.</td>
    </tr>
    <tr>
        <td>void clear()</td>
        <td>컬렉션의 모든 요소를 비운다.</td>
    </tr>
    <tr>
        <td>boolean remove(Object)</td>
        <td>매개변수 객체와 동일한 객체를 삭제한다.</td>
    </tr>
    <tr>
        <td>boolean removeAll(Collection)</td>
        <td>매개변수 컬렉션과 동일한 객체를 삭제한다.</td>
    </tr>
    <tr>
        <td>boolean retainAll(Collection)</td>
        <td>매개변수 컬렉션과 다른 객체를 삭제한다.</td>
    </tr>
    <tr>
        <td>int size()</td>
        <td>컬렉션의 요소 개수를 반환한다.</td>
    </tr>
    <tr>
        <td>Object[] toArray()</td>
        <td>컬렉션의 데이터를 배열로 복사한다.</td>
    </tr>
</table>

<h2>Iterator</h2>

<p>반복자(Iterator)는 순방향으로 요소를 액세스하기 위하여 사용한다. 연관된 메서드는 아래 표와 같다.</p>

<table>
    <th>메서드명</th>
    <th>설명</th>
    <tr>
        <td>boolean hasNext()</td>
        <td>반복자에 다음 요소의 존재 여부를 반환한다.</td>
    </tr>
    <tr>
        <td>Object next()</td>
        <td>요소를 반환하고 다음 요소를 가리킨다.</td>
    </tr>
    <tr>
        <td>void remove()</td>
        <td>반복자가 반환한 마지막 요소를 제거한다.</td>
    </tr>
</table>

<p>사용 예시는 다음과 같다.</p>

```java
Iterator itr = list.iterator();

while(itr.hasNext()) {
    System.out.println(itr.next());
}
```

<h2>List</h2>

<p>List는 순서가 존재하며 중복 데이터를 허용하는 자료구조 인터페이스이다. ArrayList, LinkedList, Vector, Stack 클래스로 구현할 수 있다.</p>

> <h4>ArrayList</h4>
> <p>ArrayList는 배열처럼 인덱스로 객체를 관리하지만 크기를 동적으로 늘릴 수 있다. 객체의 조회가 잦을 경우 유리하다. </p>

> <h4>Vector</h4>
> <p>Vector는 ArrayList와 구조적으로 동일하나 동기화된 메서드로 구성되어 있다. 멀티 스레드 환경에서 유리하다.</p>

> <h4>LinkedList</h4>
> <p>LinkedList는 인덱스가 아닌 인접 참조를 통해 객체를 관리한다. 객체의 제거와 수정이 잦을 경우 유리하다.</p>

> <h4>Stack</h4>
> <p>Stack은 데이터의 이동이 후입선출(LIFO) 방식으로 이루어진다.</p>

```java
List<Integer> listArray = new ArrayList<>();
List<Integer> listLinked = new LinkedList<>();
List<Integer> listVector = new Vector();
List<Integer> listStack = new Stack<>();
```

<h2>Set</h2>

<p>Set은 순서가 존재하지 않으며 중복 데이터를 허용하지 않는 자료구조 인터페이스이다. HashSet, LinkedHashSet, TreeSet 클래스로 구현할 수 있다.</p>

> <h4>HashSet</h4>
> <p>HashSet은 데이터를 중복저장하지 않고, 순서를 보장하지 않는다. 인스턴스를 합칠 때 중복 저장을 막을 수 있다.</p>

> <h4>LinkedHashSet</h4>
> <p>LinkedHashSet은 HashSet에 참조 기반의 LinkedList의 특징을 더한 것이다.데이터는 삽입 순서대로 정렬된다.</p>

> <h4>TreeSet</h4>
> <p>TreeSet은 이진탐색트리(BinarySearchTree)의 형태로 데이터를 저장한다. 데이터의 수정, 삭제 시간은 늘어나지만 뛰어난 조회, 정렬 시간을 얻을 수 있다.</p>

```java
Set<Integer> setHash = new HashSet<>();
Set<Integer> setLinkedHash = new LinkedHashSet<>();
Set<Integer> setTree = new TreeSet<>();
```

<h2>Queue</h2>

<p>Queue는 Stack과 반대로 선입선출(FIFO) 방식으로 데이터 처리가 이루어진다. PriorityQueue, Deque, ArrayDeque 클래스로 구현할 수 있다.</p>

> <h4>PriorityQueue</h4>
> <p>PriorityQueue는 일반적인 큐의 구조를 가지는 동시에, 우선순위를 비교하여 높은 순서대로 데이터를 처리한다. 우선 순위를 매겨서 처리할 때 사용한다.</p>

> <h4>Deque</h4>
> <p>Deque는 'Double-Ended Queue'의 약자로서, 큐의 양끝에서 데이터의 처리를 할 수 있다.</p>

> <h4>ArrayDeque</h4>
> <p>ArrayDeque는 Deque에 ArrayList처럼 동적 확장 기능을 더했다. Stack, Queue보다 속도는 빠를 수 있으나 선형적인 연산의 경우 비효율적이다.</p>

```java
Queue<String> queuePriority = new PriorityQueue();
Queue<String> dequeArray = new ArrayDeque();
```

<h2>Map</h2>

<p>Map은 ArrayList의 인덱스 역할을 Key가 담당하는 자료구조 인터페이스이다. 일반적으로 중복, 정렬이 불가능하고, 순서를 보장하지 않는다. HashMap, LinkedHashMap, TreeMap 클래스로 구현할 수 있다.</p>

> <h4>HashMap</h4>
> <p>HashMap은 일반적인 형태의 Map으로 삽입, 삭제, 조회 등의 연산은 매우 효율적이나, 정렬이 불가능하다.</p>

> <h4>LinkedHashMap</h4>
> <p>LinkedHashMap은 HashMap에서 속도를 희생하여 삽입 순서를 보장한다.</p>

> <h4>TreeMap</h4>
> <p>TreeMap은 Map의 속도를 상당히 희생한 대신, 삽입 순서를 보장하고 정렬이 가능하다.</p>

```java
Map<Integer, String> mapHash = new HashMap<>();
Map<Integer, String> mapLinkedHash = new LinkedHashMap<>();
Map<Integer, String> mapTree = new TreeMap<>();
```