package RMIRegistryandJMX;

public interface StandardServiceMBean {
	public void setState(String state);
	public String getState();
	public int getNoOfChanges();
	public void reset();
}
