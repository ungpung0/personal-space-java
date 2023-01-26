/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 완성한 프로그램을 테스트하는 클래스.
 **/

package visitor;

import visitor.practiece.FileFindVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tempDir = new Directory("temp");
        Directory userDir = new Directory("user");
        rootDir.add(binDir);
        rootDir.add(tempDir);
        rootDir.add(userDir);
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));
        rootDir.accept(new ListVisitor());
        System.out.println();

        System.out.println("Making user entries...");
        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");
        userDir.add(youngjin);
        userDir.add(gildong);
        userDir.add(dojun);
        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("Composite.java", 200));
        gildong.add(new File("memo.txt", 300));
        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));
        rootDir.accept(new ListVisitor());

        FileFindVisitor practiece1 = new FileFindVisitor(".html");
        rootDir.accept(practiece1);
        System.out.println("HTML files are:");
        for(File file : practiece1.getFiles()) {
            System.out.println(file);
        }
    }
}
