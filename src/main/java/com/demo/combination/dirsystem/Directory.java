package com.demo.combination.dirsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录类
 * 组合模式中的容器节点，表示可以包含文件和子目录的目录
 */
public class Directory extends FileComponent {

    private List<FileComponent> children = new ArrayList<>();

    public Directory(String name, int depth) {
        super(name, depth);
    }

    @Override
    public void add(FileComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileComponent component) {
        children.remove(component);
    }

    @Override
    public FileComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public List<FileComponent> getChildren() {
        return new ArrayList<>(children);
    }

    public int getChildCount() {
        return children.size();
    }

    @Override
    public void print() {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        if (name.equals("/")) {
            // 根目录
            System.out.println(name);
        } else {
            System.out.println(name.isEmpty() ? name : name + "/");
        }

        for (FileComponent child : children) {
            child.print();
        }
    }

    public long getTotalSize() {
        long total = 0;
        for (FileComponent child : children) {
            if (child instanceof File) {
                total += ((File) child).getSize();
            } else if (child instanceof Directory) {
                total += ((Directory) child).getTotalSize();
            }
        }
        return total;
    }
}