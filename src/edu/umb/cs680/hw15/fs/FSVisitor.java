package edu.umb.cs680.hw15;

public interface FSVisitor {
    public abstract void visit(Directory dir);
    public abstract void visit(File file);
    public abstract void visit(Link link);
}