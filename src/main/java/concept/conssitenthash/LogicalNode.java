package concept.conssitenthash;

/**
 * 
 * @author Mahesh
 *
 */
public class LogicalNode {

	private Node node;
	private int range;

	public LogicalNode(int range, Node node) {

		if (null == node)
			throw new RuntimeException("Cannot initialize node");

		this.range= range;
		this.node = node;
	}

	public Node getUnderlying() {
		return node;
	}

	public int getRange() {
		return range;
	}
}
