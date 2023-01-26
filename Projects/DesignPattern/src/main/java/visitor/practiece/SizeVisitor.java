/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 연습 문제 풀이, 파일의 사이즈를 반환하는 Visitor 하위 클래스.
 **/

package visitor.practiece;

import visitor.Directory;
import visitor.Entry;
import visitor.File;
import visitor.Visitor;

public class SizeVisitor extends Visitor {
    private int size = 0;

    /**
     * 파일의 크기를 반환하는 메서드. 
     **/
    public int getSize() {
        return size;
    }

    /**
     * 순회한 파일의 크기를 더하는 메서드.
     * @param file
     *          File 인스턴스
     **/
    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    /**
     * _Directory 클래스의 accept()에서 호출하는 클래스.
     * @param directory
     *          _Directory 인스턴스
     **/
    @Override
    public void visit(_Directory directory) {
        for(Entry entry : directory) {
            entry.accept(this);
        }
    }

    // 연습 문제 더미 클래스.
    @Override
    public void visit(Directory directory) {}
}

/*
    이 클래스는 Concrete Visitor(구체적인 방문자) 역할을 수행한다.
    Concrete Visitor는 Vistor의 API를 Concrete Element에 대응하여 구현한다.
 */