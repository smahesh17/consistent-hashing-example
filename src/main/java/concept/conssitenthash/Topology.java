package concept.conssitenthash;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Topology {
	private SortedMap<Long, LogicalNode> ring = new TreeMap<Long, LogicalNode>();

	public void addNode(long hash, LogicalNode vNode) {
		ring.put(hash, vNode);
	}

	public void remove(Node node) {
		Iterator<Long> it = ring.keySet().iterator();
		while (it.hasNext()) {
			Long key = it.next();
			LogicalNode lNode = ring.get(key);
			if (lNode.getUnderlying().equals(node)) {
				it.remove();
			}
		}		
	}

	public boolean isEmpty() {
		return ring.isEmpty();
	}

	public Node getNode(String key, Long hashKey) {
		SortedMap<Long, LogicalNode> tailMap = ring.tailMap(hashKey);
		hashKey = tailMap != null && !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
		return ring.get(hashKey).getUnderlying();
	}

	public Collection<LogicalNode> getNodes() {
		return ring.values();
	}

}
