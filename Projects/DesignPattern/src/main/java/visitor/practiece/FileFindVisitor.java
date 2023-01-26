/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 연습 문제 풀이, 확장자로 파일을 얻는 Visitor 하위 클래스.
 **/

package visitor.practiece;

import visitor.Directory;
import visitor.Entry;
import visitor.File;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FileFindVisitor extends Visitor {
    private List<File> files = new ArrayList<>();
    private String extension;

    public FileFindVisitor(String extension) {
        this.extension = extension;
    }


    public Iterable<File> getFiles() {
        return files;
    }

    /**
     * File 클래스의 accept()에서 호출하는 클래스.
     * file의 끝이 extension으로 끝나는 요소를 files에 추가한다.
     * @param file
     *          File 인스턴스
     **/
    @Override
    public void visit(File file) {
        if(file.getName().endsWith(extension)) {
            files.add(file);
        }
    }

    /**
     * Directory 클래스의 accept()에서 호출하는 클래스.
     * @param directory
     *          Directory 인스턴스
     **/
    @Override
    public void visit(Directory directory) {
        for(Entry entry : directory) {
            entry.accept(this);
        }
    }

    // 연습 문제 더미 클래스.
    @Override
    public void visit(_Directory directory) {}
}

/*
    이 클래스는 Concrete Visitor(구체적인 방문자) 역할을 수행한다.
    Concrete Visitor는 Vistor의 API를 Concrete Element에 대응하여 구현한다.
 */