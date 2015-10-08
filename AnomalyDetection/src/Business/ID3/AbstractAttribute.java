package Business.ID3;

abstract public class AbstractAttribute {
	private String name;
	private int value;
	private boolean isUnknown;
	
	public AbstractAttribute(String name, int value) {
		this.name = name;
		this.value = value;
		isUnknown = false;
	}
	
	public AbstractAttribute(String name, String value) {
		this.name = name;
		try {
			this.value = Integer.valueOf(value);
			this.isUnknown = false;

		}
		catch(NumberFormatException nfe) {
			this.value = -1;
			this.isUnknown = true;
		}
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setUnknown(boolean isUnknown) {
		this.isUnknown = isUnknown;
	}

	public boolean isUnknown() {
		return isUnknown;
	}
}
