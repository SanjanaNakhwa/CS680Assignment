package edu.umb.cs680.hw09.fs;
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