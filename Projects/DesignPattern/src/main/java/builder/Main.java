/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : 완성한 프로그램을 테스트한다.
 **/

package builder;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            usage();
            System.exit(0);
        }
        if(args[0].equals("text")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            System.out.println(textBuilder.getTextResult());
        }else if(args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String filename = htmlBuilder.getHTMLResult();
            System.out.println("HTML파일 " + filename + "이(가) 작성되었습니다.");
        }else {
            usage();
            System.exit(0);
        }
    }

    private static void usage() {
        System.out.println("Usage: java Main text       텍스트 문서 작성");
        System.out.println("Usage: java Main html       HTML 문서 작성");
    }
}

/*
    이 클래스는 의뢰인(Client) 역할을 수행한다.
    의뢰인은 건축가 패턴을 사용한다.
 */