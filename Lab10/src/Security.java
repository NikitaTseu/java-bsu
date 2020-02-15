
public class Security extends Worker {
	private String obj;

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Security other = (Security) obj;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		return true;
	}

	public Security(String name, String position, int salary, String obj) {
		super(name, position, salary);
		this.obj = obj;
	}

	public String getObj() {
		return obj;
	}

	public String toString() {
		return "Security [name=" + name + ", position=" + position + ", salary=" + salary + ", obj=" + obj + "]";
	}
}
