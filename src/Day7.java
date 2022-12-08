import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class Day7 {

    static Tree<String> treeAOC = new Tree<>("/");

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day7.txt"));
        String read;

        bufferedReader.readLine();
        Node<String> currentNode = treeAOC.getRoot();

        read = bufferedReader.readLine();
        while (read != null) {
            String[] simbols = read.split(" ");

            if (simbols[0].equals("$")) {
                switch (simbols[1]) {
                    case "cd":
                        System.out.println(simbols[0] + " " + simbols[1] + " " + simbols[2]);
                        currentNode = changeDir(simbols[2], currentNode);
                        read = bufferedReader.readLine();
                        break;
                    case "ls":
                        System.out.println(simbols[0] + " " + simbols[1]);
                        read = listFiles(bufferedReader, currentNode);
                        break;
                }
            }
        }

        System.out.println("Sum: " + calculate());
    }

    private static String listFiles(BufferedReader bufferedReader, Node<String> currentNode) throws IOException {
        String read;
        while ((read = bufferedReader.readLine()) != null && !read.startsWith("$")) {
            String[] simbols = read.split(" ");

            System.out.println(simbols[0] + " " + simbols[1]);
            if (simbols[0].equals("dir")) {
                Node<String> dir = findDir(simbols[1]);
                if (dir == null)
                    currentNode.addChild(simbols[1]);
                else currentNode = dir;
            }

            else if (simbols[0].matches("^\\d+")) {
                Arquivo arquivo = new Arquivo(simbols[1], Long.parseLong(simbols[0]));
                currentNode.addFile(arquivo);

                Node<String> parent = currentNode.getParent();
                while (parent != null) {
                    parent.setSumSizeFiles(parent.getSumSizeFiles() + arquivo.size);
                    parent = parent.getParent();
                }
            }
        }
        return read;
    }

    private static Node<String> changeDir(String simbol, Node<String> currentNode) {

        if (simbol.equals(".."))
            return currentNode.getParent();
//            return currentNode.parent == null ? treeAOC.getRoot() : currentNode.parent;

        Node<String> node = findDir(simbol);

        if (node == null) {
            return currentNode.addChild(simbol);
        }

        return node;
    }

    private static Node<String> findDir(String find){
        Deque<Node<String>> nodes = new ArrayDeque<>();

        nodes.push(treeAOC.getRoot());

        while (!nodes.isEmpty()){

            Node<String> curr = nodes.pop();

            if (curr.name.equalsIgnoreCase(find)){
                return curr;
            }

            curr.getChildren().forEach(nodes::push);

        }

        return null;
    }

    private static Long calculate(){
        Deque<Node<String>> nodes = new ArrayDeque<>();

        nodes.push(treeAOC.getRoot());
        Long sum = 0L;
        while (!nodes.isEmpty()){

            Node<String> curr = nodes.pop();

            System.out.println("Dir Name: " + curr.name + " Parent: " + (curr.parent == null ? "/" : curr.parent.name) + " Size: " + curr.sumSizeFiles);

//            if (curr.getSumSizeFiles() < 100000L) {
//                sum += curr.getSumSizeFiles();
//                System.out.println("Dir " + curr.getSumSizeFiles() + " -> sum: " + sum);
//            }

            curr.getChildren().forEach(nodes::push);

        }

        return sum;
    }


    public static Long soma(Node<String> node){
        return node.getNodes()
                .mapToLong(Node::getSumSizeFiles)
                .sum();
    }


    public static class Tree<T> {
        private Node<T> root;

        public Tree(T rootData) {
            root = new Node<>();
            root.name = rootData;
            root.children = new ArrayList<>();
            root.files = new ArrayList<>();
        }

        public Node<T> getRoot() {
            return root;
        }

    }

    public static class Node<T> {
        private T name;
        private Node<T> parent;
        private List<Node<T>> children;
        private List<Arquivo> files;
        private Long sumSizeFiles = 0L;

        public Node<T> addChild(T value) {
            Node<T> childNode = new Node<>();
            childNode.name = value;
            childNode.parent = this;
            childNode.files = new ArrayList<>();
            childNode.children = new ArrayList<>();

            this.children.add(childNode);
            return childNode;
        }

        public Stream<Node<T>> getNodes() {
            if (children == null || children.isEmpty()) {
                return Stream.of(this);
            }
            return children.stream()
                    .flatMap(Node::getNodes);
        }

        public List<Node<T>> getChildren() {
            return children;
        }

        public void addFile(Arquivo arquivo){
            this.files.add(arquivo);
            this.sumSizeFiles += arquivo.getSize();
        }

        public Long getSumSizeFiles() {
            return sumSizeFiles;
        }

        public void setSumSizeFiles(Long sumSizeFiles) {
            this.sumSizeFiles = sumSizeFiles;
        }

        public Node<T> getParent() {
            return parent;
        }
    }

    public static class Arquivo {

        String name;
        Long size;

        public Arquivo(String name, Long size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }
    }
}
