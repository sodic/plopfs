package plopfilesystem;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;

public class PlopFileAttributeView implements BasicFileAttributeView {

    static final String NAME = "basic";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return null;
    }

    @Override
    public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {

    }
}
