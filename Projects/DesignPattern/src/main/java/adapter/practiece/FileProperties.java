/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : FileIO의 메소드를 구현한다.
 **/

package adapter.practiece;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {
    Properties properties = new Properties();

    /**
     * filename에 해당하는 파일을 불러오는 메소드.
     * @param filename
     *          파일명
     **/
    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(new FileReader(filename));
    }

    /**
     * filename으로 파일을 저장하는 메서드.
     * @param filename
     *          파일명
     **/
    @Override
    public void writeToFile(String filename) throws IOException {
        properties.store(new FileWriter(filename), "written by FileProperties");
    }

    /**
     * properties에 key, value를 속성으로 추가하는 메서드.
     * @param key
     *          속성의 키
     * @param value
     *          속성의 값
     **/
    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    /**
     * properties의 key값에 해당하는 value를 반환하는 메서드.
     * @param key
     *          속성의 키
     **/
    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
