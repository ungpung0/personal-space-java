/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 파일이나 디렉터리 목록을 표시하는 Visitor 하위 클래스.
 **/

package visitor;

import visitor.practiece._Directory;

public class ListVisitor extends Visitor {
    private String currentDir = "";

    /**
     * File 클래스의 accept()에서 호출하는 클래스.
     * @param file
     *          File 인스턴스
     **/
    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
    }

    /**
     * Directory 클래스의 accept()에서 호출하는 클래스.
     * @param directory
     *          Directory 인스턴스
     **/
    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        for(Entry entry : directory) {
            entry.accept(this);
        }
        currentDir = saveDir;
    }

    // 연습 문제 더미 클래스.
    @Override
    public void visit(_Directory directory) {}
}

/*
    이 클래스는 Concrete Visitor(구체적인 방문자) 역할을 수행한다.
    Concrete Visitor는 Vistor의 API를 Concrete Element에 대응하여 구현한다.
 */