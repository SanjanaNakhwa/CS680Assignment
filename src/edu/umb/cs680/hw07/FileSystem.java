package edu.umb.cs680.hw07;
import java.util.*;

class FileSystem {
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