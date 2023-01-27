/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : HTML 파일을 작성하는 클래스.
 **/

package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    /**
     *  HTML 파일의 상단부와 타이틀을 작성하는 메서드.
     *  @param title
     *          타이틀 이름
     **/
    public void title(String title) throws IOException {
        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("\n");
        writer.write("<h1>" + title + "</h1>");
        writer.write("\n");
    }

    /**
     *  HTML 단락을 작성하는 메서드.
     *  @param message
     *          단락 내용
     **/
    public void paragraph(String message) throws IOException {
        writer.write("<p>" + message + "</p>");
        writer.write("\n");
    }

    /**
     *  HTML 링크를 작성하는 메서드.
     *  @param href
     *          링크 위치
     * @param caption 
     *          링크 캡션
     **/
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    /**
     * 이메일 주소를 작성하는 메서드.
     * @param mailaddress
     *          메일 주소
     * @param username
     *          유저 이름
     **/
    public void mailto(String mailaddress, String username) throws IOException {
        link("mailto:" + mailaddress, username);
    }

    /**
     * HTML 파일의 하단부를 작성하는 메서드.
     **/
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
        writer.write("\n");
        writer.close();
    }
}

/*
    이 클래스는 각자 맡은 배역을 수행하는 클래스이다.
 */
