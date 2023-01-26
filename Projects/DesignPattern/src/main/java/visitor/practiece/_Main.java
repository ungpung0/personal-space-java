/**
 * @Author : ungpung0
 * @Date    : 23/01/26
 * @Feature : 연습 문제 풀이, java.nio.file 패키지의 클래스를 재정의하여 디렉터리와 파일을 순회하는 프로그램.
 **/

package visitor.practiece;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class _Main {
    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        /**
         * 디렉터리 dir을 방문하기 전에 호출되는 메서드.
         * @param dir
         *          디렉터리에 대한 참조
         * @param attrs
         *          디렉터리의 기본 속성
         **/
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("dir: " + dir);
            return FileVisitResult.CONTINUE;
        }

        /**
         * 파일 file을 방문할 때 호출되는 메서드.
         * @param file
         *          파일에 대한 참조
         * @param attrs
         *          파일의 기본 속성
         **/
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("file: " + file);
            return FileVisitResult.CONTINUE;
        }
    }
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java Main dirname");
            System.out.println("Example: java Main .");
            System.exit(0);
        }

        String dirName = args[0];

        try {
            MyFileVisitor visitor = new MyFileVisitor();
            Path root = Path.of(dirName);
            Files.walkFileTree(root, visitor);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
