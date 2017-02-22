package concept.conssitenthash;

/**
 * 
 * @author Mahesh
 *
 */
public class Node {

	private String rack;
	private String ipAddress;
	private int port;
	private String name;

	public Node(String name, String rack, String ipAddress, int port) {
		this.setRack(rack);
		this.setIpAddress(ipAddress);
		this.setPort(port);
		this.setName(name);
	}

	public String getRack() {
		return rack;
	}

	private void setRack(String rack) {
		this.rack = rack;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	private void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	private void setPort(int port) {
		this.port = port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + port;
		result = prime * result + ((rack == null) ? 0 : rack.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (port != other.port)
			return false;
		if (rack == null) {
			if (other.rack != null)
				return false;
		} else if (!rack.equals(other.rack))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	
}
