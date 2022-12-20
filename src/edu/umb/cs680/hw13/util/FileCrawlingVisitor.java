package edu.umb.cs680.hw13;
import java.util.LinkedList;


public class FileCrawlingVisitor implements FSVisitor{
    private LinkedList<File> files = new LinkedList<>();
    
    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }

    @Override
    public void visit(Link link) {
        return;
    }

    public LinkedList<File> getFiles() {
        return this.files;
    }
    
}
