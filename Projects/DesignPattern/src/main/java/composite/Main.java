/**
 * @Author : ungpung0
 * @Date    : 23/01/25
 * @Feature : 완성한 프로그램을 테스트 한다.
 **/

package composite;

public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory rootDirectory = new Directory("root");
        Directory binDirectory = new Directory("bin");
        Directory tempDirectory = new Directory("temp");
        Directory userDirectory = new Directory("user");

        rootDirectory.add(binDirectory);
        rootDirectory.add(tempDirectory);
        rootDirectory.add(userDirectory);

        binDirectory.add(new File("vi", 1000));
        binDirectory.add(new File("latex", 20000));

        rootDirectory.printList();
        System.out.println();

        System.out.println("Making user entries...");
        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");

        userDirectory.add(youngjin);
        userDirectory.add(gildong);
        userDirectory.add(dojun);

        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("Composite.java", 200));
        gildong.add(new File("memo.txt", 300));
        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));
        rootDirectory.printList();
    }
}

/*
    이 클래스는 '의뢰자(Client)' 역할을 수행한다.
    '의뢰자(Client)'는 '컴포넌트(Component)'를 사용하여 프로그램을 실행한다.
*/
