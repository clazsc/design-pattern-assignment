package com.demo.combination.dirsystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件系统组件抽象类
 * 组合模式中的抽象组件角色，定义文件和目录的共同接口
 */
@Data
public abstract class FileComponent {

    /**
     * 文件名
     */
    protected String name;

    /**
     * 层级深度
     */
    protected int depth;

    public FileComponent(String name, int depth) {
        this.name = name;
        this.depth = depth;
    }


    public void add(FileComponent component) {
        throw new UnsupportedOperationException("文件不支持添加操作");
    }

    public void remove(FileComponent component) {
        throw new UnsupportedOperationException("文件不支持移除操作");
    }

    public FileComponent getChild(int index) {
        throw new UnsupportedOperationException("文件不支持获取子项操作");
    }

    public List<FileComponent> getChildren() {
        return new ArrayList<>();
    }

    public void print() {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(name);
    }
}