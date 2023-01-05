 /**
  * @Author : ungpung0
  * @Date    : 23/01/04
  * @Feature : ArrayList 메서드를 학습한다.
  **/

package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PractieceArrayList {
    private List<String> list = new ArrayList<>();

    /**
     * 리스트에 요소를 삽입하는 메소드
     *
     * @param element
     *          리스트에 넣을 요소
     **/
    public void addElement(String element) {
        list.add(element);
    }

    /**
     * 리스트에 컬렉션을 삽입하는 메소드
     *
     * @param list
     *          리스트에 넣을 컬렉션(리스트)
     **/
    public void addAllElement(List<String> list) {
        this.list.addAll(list);
    }

    /**
     * 리스트의 요소를 삭제하는 메소드
     *
     * @param element
     *          리스트에서 삭제할 요소
     **/
    public void delElement(String element) {
        if(list.contains(element))
            list.remove(element);
        else
            System.out.println("삭제할 요소가 존재하지 않습니다.");
    }

    /**
     * 리스트의 모든 요소를 출력하는 메소드
     **/
    public void getAllElement() {
        if(list.isEmpty()) {
            System.out.println("조회할 요소가 존재하지 않습니다.");
        }else {
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }


}
