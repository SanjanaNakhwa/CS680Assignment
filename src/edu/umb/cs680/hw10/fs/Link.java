package edu.umb.cs680.hw10.fs;
import edu.umb.cs680.hw10.state;
import edu.umb.cs680.hw10.util;
import java.time.LocalDateTime;

import edu.umb.cs680.hw10.state.SecurityContext;

public class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
        parent.appendChild(this);
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return this.target;
    }

    public void setTarget(FSElement target) {
        this.target = target;
    }

    public void accept(FSVisitor v, SecurityContext ctx) {
        if (ctx.isActive()) {
            v.visit(this);
        }
        else {
            System.out.println("User not logged in.");
        }
	}
}