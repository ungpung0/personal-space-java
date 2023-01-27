/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 연습 문제 풀이, 이메일 주소로 사용자의 웹 페이지를 작성하는 클래스.
 **/

package facade.practiece;

import facade.pagemaker.Database;
import facade.pagemaker.HtmlWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class _PageMaker {
    private _PageMaker() {}

    /**
     * 클래스 Database, HtmlWriter를 활용하여 웹 페이지를 생성하는 메서드.
     * @param mailaddress 
     *          메일 주소
     * @param filename
     *          파일 이름
     **/
    public static void makeWelcomePage(String mailaddress, String filename) {
        try {
            Properties mailProperties = Database.getProperties("maildata");
            String username = mailProperties.getProperty(mailaddress);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            writer.title(username + "'s Web Page");
            writer.paragraph("Welcome to " + username + "'s Web Page!");
            writer.paragraph("Nice to meet You!");
            writer.close();

            System.out.println(filename + " is created for " + mailaddress + " (" + username + ")");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 클래스 Database, HtmlWriter를 활용하여 이메일 링크 페이지를 생성하는 메서드.
     * @param filename
     *          파일 이름
     **/
    public static void makeLinkPage(String filename) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link Page");

            Properties mailProperties = Database.getProperties("maildata");
            for(String mailaddress : mailProperties.stringPropertyNames()) {
                String username = mailProperties.getProperty(mailaddress, "(unknown)");
                writer.mailto(mailaddress, username);
            }

            writer.close();
            System.out.println(filename + " is created.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
    이 클래스는 Facade(정면) 역할을 수행한다.
    Facade는 Client에게 외부에서 실행할 수 있는 창구를 제공한다.
 */
