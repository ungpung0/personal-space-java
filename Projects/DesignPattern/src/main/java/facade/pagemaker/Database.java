/**
 * @Author : ungpung0
 * @Date    : 23/01/27
 * @Feature : 이메일 주소에서 사용자 이름을 얻는 클래스.
 **/

package facade.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {}

    /**
     *  DB 이름을 통해서 Properties 인스턴스를 가져오는 메서드.
     * @param dbname
     *          DB 이름
     **/
    public static Properties getProperties(String dbname) throws IOException {
        String filename = dbname + ".txt";
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        return properties;
    }
}

/*
    이 클래스는 각자 맡은 배역을 수행하는 클래스이다.
 */