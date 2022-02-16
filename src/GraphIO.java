import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {

    static public void readFile(Graph g, String filename) throws IOException {
        int nodeAmount;
        String fileRow;

        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            fileRow = sc.nextLine();
            nodeAmount = Integer.parseInt(fileRow);
            while (nodeAmount > 0) {
                fileRow = (sc.nextLine());
                String[] s = fileRow.split(" ");
                g.addNode(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodeAmount--;
            }
            while (sc.hasNextLine()) {
                fileRow = (sc.nextLine());
                String[] s = fileRow.split(" ");
                g.addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }
}

