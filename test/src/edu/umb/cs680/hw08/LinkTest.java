package edu.umb.cs680.hw08;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LinkTest {
    static FileSystem fs;
    static Directory root, apps, bin, home, pictures;
    static File x, y, a, b, c;
    static Link d, e;

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
    }

    @Test
	public void isDirectory() {
		assertFalse(d.isDirectory());
	}
	
	@Test
	public void isFile() {
		assertFalse(d.isFile());
	}
	
	@Test
	public void isLink() {
		assertTrue(d.isLink());
	}
	
	@Test
	public void getTargetTest() {
		assertEquals(pictures, d.getTarget());
	}
	
	@Test
	public void setTargetTest() {
		d.setTarget(apps);
		assertEquals(apps, d.getTarget());
	}
}
