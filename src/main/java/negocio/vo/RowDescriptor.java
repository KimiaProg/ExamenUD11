package negocio.vo;

public class RowDescriptor {

	private String rowName;
	private RowType rowType;
	
	public RowDescriptor(String rowName, RowType rowType) {
		this.rowName = rowName;
		this.rowType = rowType;
	}
	
	public String getRowName() {
		return rowName;
	}
	public void setRowName(String rowName) {
		this.rowName = rowName;
	}
	public RowType getRowType() {
		return rowType;
	}
	public void setRowType(RowType rowType) {
		this.rowType = rowType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RowDescriptor other = (RowDescriptor) obj;
		if (rowName == null) {
			if (other.rowName != null)
				return false;
		} else if (!rowName.equalsIgnoreCase(other.rowName))
			return false;
		if (rowType != other.rowType)
			return false;
		return true;
	}
	
	
	
	
}
