package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FileCrawlingVisitorTest {
    private static FileSystem fs;
    private static Directory root, apps, bin, home, pictures;
    private static File x, y, a, b, c;
    private static Link d, e;
    private static FileCrawlingVisitor visitor;

    @BeforeAll
    public static void setUp() {
        fs = FileSystem.getFileSystem();
        root = new Directory(null, "root", 0, LocalDateTime.now());
        fs.appendRootDirectory(root);   
        apps = new Directory(root, "apps", 0, LocalDateTime.now());
        x = new File(apps, "x", 10, LocalDateTime.now());

        bin = new Directory(root, "bin", 0, LocalDateTime.now());
        y = new File(bin, "y", 20, LocalDateTime.now());

        home = new Directory(root, "home", 0, LocalDateTime.now());
        c = new File(home, "c", 50, LocalDateTime.now());
        pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
        a = new File(pictures, "a", 10, LocalDateTime.now());
        b = new File(pictures, "b", 20, LocalDateTime.now());

        d = new Link(root, "d", 0, LocalDateTime.now(), pictures);
        e = new Link(root, "e", 0, LocalDateTime.now(), x);

        visitor = new FileCrawlingVisitor();
        root.accept(visitor);
    }

    @Test
    public void getFilesTest() {
        LinkedList<File> expected = new LinkedList<>();
        expected.add(x);
        expected.add(y);
        expected.add(c);
        expected.add(a);
        expected.add(b);
        assertArrayEquals(visitor.getFiles().toArray(), expected.toArray());

    }
}
