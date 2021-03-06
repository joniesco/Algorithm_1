

/**
 * node for gameNumbers tree
 * at [left,right]
 * diff = optimal difference for the player that start the game
 * path = string represents the optimal path for both players
 */
public class node {
    int left,right;
    int diff;
    String path;

    public node(int left,int right) {
        this.left = left;
        this.right = right;
        this.diff = 0;
        this.path = "";
    }

    @Override
    public String toString() {
        return "{[" + left + "," + right + "]" + " (diff = " + diff + ") " + path + "}";
    }
}
