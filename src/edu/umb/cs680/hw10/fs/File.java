package edu.umb.cs680.hw10;

import java.time.LocalDateTime;




public class File extends FSElement{
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		parent.appendChild(this);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLink() {
		return false;
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