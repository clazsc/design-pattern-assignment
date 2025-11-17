package com.demo.combination.dirsystem;

/**
 * 文件系统演示
 * 模拟Linux/Windows的tree命令效果
 */
public class FileSystemDemo {

    public static void main(String[] args) {
        System.out.println("=== 组合模式演示：文件目录结构 ===\n");

        // 创建根目录
        Directory root = new Directory("/", 0);

        // 创建一级目录
        Directory home = new Directory("home", 1);
        Directory usr = new Directory("usr", 1);
        Directory var = new Directory("var", 1);

        // 创建home目录下的内容
        Directory user1 = new Directory("user1", 2);
        user1.add(new File("document.txt", 3, 1024));
        user1.add(new File("photo.jpg", 3, 2048));
        user1.add(new File("video.mp4", 3, 51200));

        Directory user2 = new Directory("user2", 2);
        Directory documents = new Directory("documents", 3);
        documents.add(new File("report.pdf", 4, 3072));
        documents.add(new File("presentation.pptx", 4, 8192));
        user2.add(documents);
        user2.add(new File("readme.txt", 3, 512));

        home.add(user1);
        home.add(user2);

        // 创建usr目录下的内容
        Directory bin = new Directory("bin", 2);
        bin.add(new File("ls", 3, 65536));
        bin.add(new File("cp", 3, 49152));
        bin.add(new File("mv", 3, 57344));

        Directory lib = new Directory("lib", 2);
        lib.add(new File("libc.so", 3, 196608));
        lib.add(new File("libssl.so", 3, 131072));

        usr.add(bin);
        usr.add(lib);

        // 创建var目录下的内容
        Directory log = new Directory("log", 2);
        log.add(new File("system.log", 3, 25600));
        log.add(new File("access.log", 3, 18432));
        log.add(new File("error.log", 3, 8192));

        var.add(log);
        var.add(new File("cache.db", 2, 16384));

        // 构建完整的目录树
        root.add(home);
        root.add(usr);
        root.add(var);
        root.add(new File("boot.ini", 1, 1024));

        System.out.println("文件目录树结构：");
        System.out.println("=================");
        root.print();

        System.out.println("\n统计信息：");
        System.out.println("=========");
        System.out.println("根目录下直接子项数量: " + root.getChildCount());
        System.out.println("home目录大小: " + home.getTotalSize() + " bytes");
        System.out.println("usr目录大小: " + usr.getTotalSize() + " bytes");
        System.out.println("var目录大小: " + var.getTotalSize() + " bytes");
        System.out.println("总文件系统大小: " + root.getTotalSize() + " bytes");

        System.out.println("\n组合模式说明：");
        System.out.println("=============");
        System.out.println("✓ Directory(目录)是容器节点，可以包含File和Directory");
        System.out.println("✓ File(文件)是叶子节点，不能包含子节点");
        System.out.println("✓ 两者都继承FileComponent，可以使用统一的print()方法");
        System.out.println("✓ Directory.print()通过递归调用实现树形结构显示");
    }
}