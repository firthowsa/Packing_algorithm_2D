import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class JavaBin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Packer packer = new Packer(1, 600, 1300);// 2 available packets to fill, 600X800 each
        ArrayList<Node> blocks = new ArrayList();

        blocks.add(new Node("Figure1", 300, 400));
        blocks.add(new Node("Figure2", 300, 400));
        blocks.add(new Node("Figure3", 300, 400));
        blocks.add(new Node("Figure4", 300, 400));
        blocks.add(new Node("Figure6", 300, 400));
        blocks.add(new Node("Figure7", 300, 400));
        blocks.add(new Node("Figure8", 300, 400));
        blocks.add(new Node("Figure9", 300, 400));

        Collections.sort(blocks, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {

                return (Double.compare(b.w, a.w)); //doing the sort based on the width, you can change it accordingly to your needs.
            }
        });

        packer.fit(blocks);
        Iterator<Node> blocksItr = blocks.iterator();
        while (blocksItr.hasNext()) {
            Node block = blocksItr.next();
            if (block.fit != null) {
                if (block.fit.isroot) {
                    System.out.format("%32s", "Pack Starts Here");
                    System.out.println("");
                    System.out.format("%32s%24s%16s%16s%16s", "Display name", "x", "y", "w", "h");
                    System.out.println("");
                }
                System.out.format("%32s%24s%16s%16s%16s", block.name, block.fit.x, block.fit.y, block.w, block.h);
                System.out.println("");
            }
        }

        System.out.println("");
    }
}
