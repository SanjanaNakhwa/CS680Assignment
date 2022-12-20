package edu.umb.cs680.hw10.fs;
import edu.umb.cs680.hw10.state;
import edu.umb.cs680.hw10.util;

import java.util.*;

public class FileSystem {
    private static FileSystem fs = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (fs == null) {
            fs = new FileSystem();
        }
        return fs;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void appendRootDirectory(Directory root) {
        this.rootDirs.add(root);
    }
}