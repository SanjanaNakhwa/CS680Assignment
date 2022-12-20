package edu.umb.cs680.hw09.util;
import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.*;

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
