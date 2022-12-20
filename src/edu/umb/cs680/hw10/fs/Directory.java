package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement{

    private LinkedList<FSElement> children = new LinkedList<>();
	
	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if (parent != null) {
			parent.appendChild(this);
		}
	}
	
	public boolean isDirectory() {
		return true;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}

	public LinkedList<FSElement> getChildren(){
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> dirList = new LinkedList<>();
		for (FSElement fsElement : this.children) {
			if (fsElement.isDirectory()) {
				dirList.add((Directory)fsElement);
			}
		}
		return dirList;
	}
	
	public LinkedList<File> getFiles(){
		LinkedList<File> files = new LinkedList<>();
		for (FSElement fsElement : this.children) {
			if (!fsElement.isDirectory()) {
				files.add((File)fsElement);
			}
		}
		return files;
	}
	
	public int getTotalSize() {
		int totalSize = 0;

		for (FSElement fsElement : this.children) {
			if (fsElement.isDirectory()) {
				totalSize += ((Directory) fsElement).getTotalSize();
			}
			else {
				totalSize += fsElement.getSize();
			}
		}
        
		return totalSize;
	}

	public void accept(FSVisitor v, SecurityContext ctx) {
		if (ctx.isActive()) {
			v.visit(this);
			for (FSElement e : this.children) {
				e.accept(v, ctx);
			}
		}
		else {
			System.out.println("User not logged in.");
		}
	}
}