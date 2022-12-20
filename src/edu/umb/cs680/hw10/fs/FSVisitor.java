package edu.umb.cs680.hw10.fs;
import edu.umb.cs680.hw10.state;
import edu.umb.cs680.hw10.util;

public interface FSVisitor {
    public abstract void visit(Directory dir);
    public abstract void visit(File file);
    public abstract void visit(Link link);
}