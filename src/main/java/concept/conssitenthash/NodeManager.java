package concept.conssitenthash;

import concept.conssitenthash.strategy.HashStrategy;
/**
 * just a sample - not multi-threaded
 */
public class NodeManager {

	private HashStrategy hashfunction = HashStrategy.getAlgorithm("MD5");

	private Topology topology = new Topology();

	public void addNode(Node node, int vnodeCount) {
		if(null == node)
			throw new RuntimeException("cannot add empty node");
		int existingReplicas = getReplicas(node.getName());
		for (int i = 0; i < vnodeCount; i++) {
			LogicalNode vNode = new LogicalNode( i + existingReplicas, node);
			topology.addNode(hashfunction.hash(vNode.toString()), vNode);
		}
	}

	public void removeNode(Node node) {
		topology.remove(node);
	}

	public Node getNode(String key) {
		if (topology.isEmpty()) {
			return null;
		}
		Long hashKey = hashfunction.hash(key);
		return topology.getNode(key, hashKey);
		
	}

	public int getReplicas(String nodeName) {
		int replicas = 0;
		for (LogicalNode node : topology.getNodes()) {
			if (node.getUnderlying().toString().equals(nodeName)) {
				replicas++;
			}
		}
		return replicas;
	};
}
