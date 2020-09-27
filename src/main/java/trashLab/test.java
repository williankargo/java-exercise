package trashLab;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class SimplePrintTree extends SimpleFileVisitor<Path> {
}

class PrintTree implements FileVisitor<Path> {
    private int i;

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(++i + ". preVisitDirectory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(++i + ". visitFile: " + file);
        if (attrs.isSymbolicLink()) {
            System.out.println("\t --> " + file.getFileName() + " is SymbolicLink");
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println(++i + ". visitFileFailed: " + file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(++i + ". postVisitDirectory: " + dir);
        return FileVisitResult.CONTINUE;
    }
}

public class test {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/pinkuan/Downloads/MP21916/src/course/c09/demo");
        try {
            Files.walkFileTree(path, new PrintTree()); // new SimplePrintTree()
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}


