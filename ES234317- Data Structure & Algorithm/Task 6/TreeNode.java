import javax.sql.rowset.Joinable;
import java.util.LinkedList;
import java.util.StringJoiner;

public class TreeNode {
    String name;
    Breed breed;
    TreeNode parent;
    private LinkedList<TreeNode> childNodes;
    private LinkedList<TreeNode> similar;

    TreeNode(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
        this.parent = null;
        this.childNodes = new LinkedList<>();
        this.similar = new LinkedList<>();
    }

    public void addChild(TreeNode child) {
        child.parent = this;
        this.childNodes.add(child);
    }
    public void addChild(TreeNode[] childs){
        for(TreeNode child: childs){
            child.parent = this;
            this.childNodes.add(child);
        }
    }

    // similar is defined as child and parent
    // that is of a similar breed
    public void findSimilar(){
        // crawling and find similar from parent child(s)
        if(this.parent != null) {
            if(parent.breed == this.breed) { similar.add(parent); }
            for(TreeNode child: this.parent.cloneChildes()){
                if(child.breed == this.breed && child != this) { similar.add(child); }
            }
        }

        // crawling and find similar from child(s)
        if(!this.childNodes.isEmpty()) {
            for(TreeNode child: this.childNodes){
                if(child.breed == this.breed) { similar.add(child); }
            }
        }

        // print result
        if(!similar.isEmpty()) {
            StringJoiner joiner = new StringJoiner(", ");
            for(TreeNode s: similar){
                joiner.add(s.name);
            }
            System.out.println(this.name + " [" + joiner + "]");
        } else {
            System.out.println(this.name + " Has no Similarity");
        }
    }

    private LinkedList<TreeNode> cloneChildes() {
        return (LinkedList) this.childNodes.clone();
    }
}

