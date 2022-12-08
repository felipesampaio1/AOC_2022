import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day7WithoutTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day7.txt"));

        String input =
                """
                        $ cd /
                        $ ls
                        dir a
                        14848514 b.txt
                        8504156 c.dat
                        dir d
                        $ cd a
                        $ ls
                        dir e
                        29116 f
                        2557 g
                        62596 h.lst
                        $ cd e
                        $ ls
                        584 i
                        $ cd ..
                        $ cd ..
                        $ cd d
                        $ ls
                        4060174 j
                        8033020 d.log
                        5626152 d.ext
                        7214296 k
                        """;
        DirectoryEntry rootDir = new DirectoryEntry(null, "/");
        DirectoryEntry currDir = rootDir;

        List<DirectoryEntry> allDirs = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
//        for (String line : input.split("\n")){
            String[] simbols = line.split(" ");
            if ("$".equals(simbols[0])) {
                if ("cd".equals(simbols[1])) {
                    if ("/".equals(simbols[2])) {
                        currDir = rootDir;
                    } else if ("..".equals(simbols[2])) {
                        currDir = currDir.getParent();
                    } else {
                        currDir = currDir.getDir(simbols[2]);
                    }
                }
            } else if ("dir".equals(simbols[0])) {
                DirectoryEntry fe = new DirectoryEntry(currDir, simbols[1]);
                currDir.addFile(fe);
                allDirs.add(fe);
            } else {
                currDir.addFile(new FileEntry(simbols[1], Long.parseLong(simbols[0])));
            }
        }

//        Long total = allDirs.stream()
//                .mapToLong(DirectoryEntry::size)
//                .sum();

        long total = rootDir.size();
        long free = 70000000 - total;
        long spaceToRemove = 30000000 - free;

        List<DirectoryEntry> candidates = new ArrayList<>();

        allDirs.stream()
                .filter(dir -> dir.size() > spaceToRemove)
                .forEach(candidates::add);

        candidates.sort((a, b) -> (int) (a.size() - b.size()));

        System.out.println(candidates.get(0).size());
    }
}
