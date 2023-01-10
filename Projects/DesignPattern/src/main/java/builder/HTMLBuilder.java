/**
 * @Author : ungpung0
 * @Date    : 23/01/10
 * @Feature : HTML 파일을 생성하기 위해서 Builder를 구현한다.
 **/

package builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HTMLBuilder extends Builder {
    private String filename = "untitled.html";
    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * html 문서의 틀을 짜는 메서드.
     * @param title
     *          문서의 제목
     **/
    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        stringBuilder.append("<!DOCTYPE html>\n");
        stringBuilder.append("<html>\n");
        stringBuilder.append("<head><title>");
        stringBuilder.append(title);
        stringBuilder.append("</title></head>\n");
        stringBuilder.append("<body>\n");
        stringBuilder.append("<h1>");
        stringBuilder.append(title);
        stringBuilder.append("</h1>\n\n");
    }

    /**
     * html 문서에 단락을 추가하는 메서드.
     * @param string
     *          추가할 단락
     **/
    @Override
    public void makeString(String string) {
        stringBuilder.append("<p>");
        stringBuilder.append(string);
        stringBuilder.append("</p>\n\n");
    }

    /**
     * html 문서에 리스트를 추가하는 메서드.
     * @param items
     *          추가할 요소
     **/
    @Override
    public void makeItems(String[] items) {
        stringBuilder.append("<ul>\n");
        for(String string : items) {
            stringBuilder.append("<li>");
            stringBuilder.append(string);
            stringBuilder.append("</li>\n");
        }
        stringBuilder.append("</ul>\n\n");
    }

    /**
     * html 문서를 마무리하는 메서드.
     **/
    @Override
    public void close() {
        stringBuilder.append("</body>");
        stringBuilder.append("</html>\n");
        try {
            Writer writer = new FileWriter(filename);
            writer.write(stringBuilder.toString());
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 파일명을 반환하는 메서드.
     **/
    public String getHTMLResult() {
        return filename;
    }
}

/*
    이 클래스는 '구체적인 건축가(Builder)' 역할을 수행한다.
    실제 인스턴스를 생성할 때 호출되는 메서드를 구현하여 결과를 얻는다.
*/