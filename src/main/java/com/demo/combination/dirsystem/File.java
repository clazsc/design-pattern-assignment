package com.demo.combination.dirsystem;

import lombok.Getter;

/**
 * 文件类
 * 组合模式中的叶子节点，表示具体的文件
 */
@Getter
public class File extends FileComponent {

    private long size;

    public File(String name, int depth, long size) {
        super(name, depth);
        this.size = size;
    }

    public File(String name, int depth) {
        super(name, depth);
        this.size = 0;
    }

    @Override
    public void print() {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        if (size > 0) {
            System.out.println(name + " (" + size + " bytes)");
        } else {
            System.out.println(name);
        }
    }
}