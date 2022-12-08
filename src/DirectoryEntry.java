import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DirectoryEntry extends FileEntry {

    private final DirectoryEntry parent;
    private Map<String, FileEntry> files = new HashMap<>();

    public DirectoryEntry(DirectoryEntry parent, String name) {
        super(name, 0);
        this.parent = parent;
    }

    public Collection<FileEntry> getFiles() {
        return files.values();
    }

    public void addFile(FileEntry fe){
        files.put(fe.getName(), fe);
    }

    public long size(){
        long count = 0;
        for  (FileEntry file : files.values()) {
            count += file.size();
        }
        return count;
    }

    public DirectoryEntry getParent() {
        return parent;
    }

    public DirectoryEntry getDir(String simbol) {
        return (DirectoryEntry) files.get(simbol);
    }
}
