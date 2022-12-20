package edu.umb.cs680.hw13;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;

public class DirectoryTest {
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
        z = new File(lib, "z", 40, LocalDateTime.now());

        home = new Directory(root, "home", 0, LocalDateTime.now());
        d = new File(home, "d", 50, LocalDateTime.now());
        code = new Directory(home, "code", 0, LocalDateTime.now());
        a = new File(code, "a", 10, LocalDateTime.now());
        c = new File(code, "c", 20, LocalDateTime.now());
        b = new File(code, "b", 30, LocalDateTime.now());

    }

    @Test
    public void isDirectoryTest() {
        assertTrue(root.isDirectory());
        assertFalse(x.isDirectory());
    }

    @Test
    public void isFileTest() {
        assertTrue(a.isFile());
        assertFalse(home.isFile());
    }

    @Test
    public void getChildrenTest() {
        assertEquals(2, apps.getChildren().size());
    }

    @Test
    public void appendChildTest() {
        // File constructor calls appendChild
        new File(lib, "m", 50, LocalDateTime.now());
        assertEquals(2, lib.getChildren().size());
    }

    @Test
    public void countChildrenTest() {
        assertEquals(2, apps.countChildren());
    }

    @Test
    public void getSubDirectoriesTest() {
        assertEquals(3, root.getSubDirectories().size());
    }

    @Test
    public void getFilesTest() {
        assertEquals(1, home.getFiles().size());
    }

    @Test
    public void getTotalSize() {
        assertEquals(180, root.getTotalSize());
    }

    @Test
    public void getChildrenAlphabeticallySortedTest() {
        List<FSElement> names = List.of(apps, home, lib);
        assertEquals(names, root.getChildren(new AlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesAlphabeticallySortedTest() {
        List<FSElement> names = List.of(apps, home, lib);
        assertEquals(names, root.getSubDirectories(new AlphabeticalComparator()));
    }

    @Test
    public void getFilesAlphabeticallySortedTest() {
        List<FSElement> names = List.of(a, b, c);
        assertEquals(names, code.getFiles(new AlphabeticalComparator()));
    }

    @Test
    public void getChildrenReverseAlphabeticallySortedTest() {
        List<FSElement> names = List.of(lib, home, apps);
        assertEquals(names, root.getChildren(new ReverseAlphabeticalComparator()));
    }

    @Test
    public void getSubDirectoriesReverseAlphabeticallySortedTest() {
        List<FSElement> names = List.of(lib, home, apps);
        assertEquals(names, root.getSubDirectories(new ReverseAlphabeticalComparator()));
    }

    @Test
    public void getFilesReverseAlphabeticallySortedTest() {
        List<FSElement> names = List.of(c, b, a);
        assertEquals(names, code.getFiles(new ReverseAlphabeticalComparator()));
    }

    @Test
    public void getChildrenSizeSortedTest() {
        List<FSElement> names = List.of(apps, lib, home);
        assertEquals(names, root.getChildren(new SizeComparator()));
    }

    @Test
    public void getSubDirectoriesSizeSortedTest() {
        List<FSElement> names = List.of(apps, lib, home);
        assertEquals(names.size(), root.getSubDirectories(new SizeComparator()).size());
    }

    @Test
    public void getFilesSizeSortedTest() {
        List<FSElement> names = List.of(a, c, b);
        assertEquals(names, code.getFiles(new SizeComparator()));
    }

    @Test
    public void getChildrenTimeSortedTest() {
        List<FSElement> names = List.of(apps, lib, home);
        assertEquals(names, root.getChildren(new TimeStampComparator()));
    }

    @Test
    public void getSubDirectoriesTimeSortedTest() {
        List<FSElement> names = List.of(apps, lib, home);
        assertEquals(names, root.getSubDirectories(new TimeStampComparator()));
    }

    @Test
    public void getFilesTimeSortedTest() {
        List<FSElement> names = List.of(a, c, b);
        assertEquals(names, code.getFiles(new TimeStampComparator()));
    }


}
