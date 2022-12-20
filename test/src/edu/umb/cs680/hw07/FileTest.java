package edu.umb.cs680.hw07;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileTest {
    static FileSystem fs;
    static Directory root, apps, lib, home, code;
    static File x, y, z, a, b, c, d;

    @BeforeAll
    public static void setUp() {
        fs = FileSystem.getFileSystem();
        root = new Directory(null, "root", 0, LocalDateTime.now());
        fs.appendRootDirectory(root);   
        apps = new Directory(root, "apps", 0, LocalDateTime.now());
        x = new File(apps, "x", 10, LocalDateTime.now());
        y = new File(apps, "y", 20, LocalDateTime.now());

        lib = new Directory(root, "lib", 0, LocalDateTime.now());
        z = new File(lib, "z", 30, LocalDateTime.now());

        home = new Directory(root, "home", 0, LocalDateTime.now());
        d = new File(home, "d", 50, LocalDateTime.now());
        code = new Directory(home, "code", 0, LocalDateTime.now());
        a = new File(code, "a", 10, LocalDateTime.now());
        b = new File(code, "b", 20, LocalDateTime.now());
        c = new File(code, "c", 20, LocalDateTime.now());
    }

    @Test
    public void isFileTest() {
        assertTrue(a.isFile());
        assertFalse(root.isFile());
    }

}
