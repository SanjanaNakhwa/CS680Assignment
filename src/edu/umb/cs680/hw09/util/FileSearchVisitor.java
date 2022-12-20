package edu.umb.cs680.hw09.util;
import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.*;

public class FileSearchVisitor implements FSVisitor {
    private LinkedList<File> foundFiles;
    private String fileName;

    public FileSearchVisitor(String name) {
        this.fileName = name;
        foundFiles = new LinkedList<>();
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(this.fileName)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Link link) {
        return;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String name) {
        this.fileName = name;
    }

    public LinkedList<File> getFoundFiles() {
        return this.foundFiles;
    }
    
}
