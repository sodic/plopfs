package plopfilesystem;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

public class PlopFileSystem extends FileSystem {

    static private Set<String> FILE_ATTRIBUTE_VIEWS = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(PlopFileAttributeView.NAME)));

    // properties taken from DxPath and UnixPath (Unix has final, Dx not)
    // TODO properly
    private final PlopPath rootDirectory = null;
    private final PlopFileSystemProvider fileSystemProvider = null;
    private final PlopPath defaultDirectory = null;


    @Override
    public FileSystemProvider provider() {
        return fileSystemProvider;
    }

    public PlopPath rootDirectory() {
        return rootDirectory;
    }

    public PlopPath defaultDirectory() {
        return defaultDirectory;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getSeparator() {
        return "/";
    }

    @Override
    public Iterable<Path> getRootDirectories() {
        return Collections.<Path>singleton(new PlopPath(this, this.getSeparator()));
    }

    @Override
    public Iterable<FileStore> getFileStores() {
        return Collections.singleton(new PlopFileStore(this));
    }

    @Override
    public Set<String> supportedFileAttributeViews() {
        return FILE_ATTRIBUTE_VIEWS;
    }

    @Override
    public Path getPath(String first, String... more) {
        String path;
        if (more.length == 0) {
            path = first;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(first);
            for (String segment : more) {
                if (segment.length() > 0) {
                    if (sb.length() > 0)
                        sb.append('/');
                    sb.append(segment);
                }
            }
            path = sb.toString();
        }
        return new PlopPath(this, path);
    }

    @Override
    public PathMatcher getPathMatcher(String syntaxAndPattern) {
        return null;
    }

    @Override
    public UserPrincipalLookupService getUserPrincipalLookupService() {
        throw new UnsupportedOperationException();
    }

    @Override
    public WatchService newWatchService() throws IOException {
        throw new UnsupportedOperationException();
    }
}
