/**
 * @Author : ungpung0
 * @Date    : 23/01/06
 * @Feature : 파일 입출력을 위한 메서드를 결정한다.
 **/

package adapter.practiece;

import java.io.IOException;

public interface FileIO {
    public void readFromFile(String filename) throws IOException;

    public void writeToFile(String filename) throws IOException;

    public void setValue(String key, String value);

    public String getValue(String key);
}
