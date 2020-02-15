
public class Worker implements Comparable<Worker>{
	protected String name, position;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Worker other = (Worker) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	protected int salary;
	
	public Worker(String name, String position, int salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getSalary() {
		return salary;
	}

	
	public String toString() {
		return "Worker [name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}
	
	public int compareTo(Worker w) {
		if(this.position.compareTo(w.position) > 0) {
			return 1;
		}
		else {
			if(this.position.compareTo(w.position) < 0) {
				return -1;
			}
			else {
				if(this.name.compareTo(w.name) > 0) {
					return 1;
				}
				else {
					if(this.name.compareTo(w.name) < 0) {
						return -1;
					}
					else {
						if(this.salary < w.salary) {
							return 1;
						}
						else {
							if(this.salary > w.salary) {
								return -1;
							}
							else {
								return 0;
							}
						}
					}
				}
			}
		}
	}
}
