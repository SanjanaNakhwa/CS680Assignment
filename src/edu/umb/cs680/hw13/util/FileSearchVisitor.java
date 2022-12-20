package edu.umb.cs680.hw13;
import java.util.LinkedList;

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
