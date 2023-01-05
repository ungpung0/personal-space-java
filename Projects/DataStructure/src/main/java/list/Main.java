 /**
  * @Author : ungpung0
  * @Date    : 23/01/04
  * @Feature : 클래스를 테스트한다.
  **/

package list;

 import java.util.ArrayList;
 import java.util.List;

 public class Main {
    public static void main(String[] args) {
        // 리스트에 추가할 요소, 컬렉션
        String _string = "사과";
        List<String> _list = new ArrayList<>(List.of("포도", "딸기", "배"));

        // PractieceArrayList 객체 생성 및 테스트
        PractieceArrayList arrayList = new PractieceArrayList();
        arrayList.addElement(_string);
        arrayList.addAllElement(_list);
        arrayList.delElement(_string);
        arrayList.getAllElement();
    }
}
