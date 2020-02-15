
public class Node<T extends Comparable<T>> {
	private T val;
	public Node<T> left, right, parent;
	
	public Node(T val) {
		this.val = val;
		left = null;
		right = null;
		parent = null;
	}
	
	public Node() {
		this.val = null;
		left = null;
		right = null;
		parent = null;
	}
	
	public void add(T newVal) {
		add(new Node<T>(val));
	}
	
	public void add(Node<T> newNode) {
		if(newNode.val.compareTo(val) < 0) {
			if(left == null) {
				newNode.parent = this;
				left = newNode;
			}
			else {
				left.add(newNode);
			}
		}
		else {
			if(right == null) {
				newNode.parent = this;
				right = newNode;
			}
			else {
				right.add(newNode);
			}
		}
	}
	
	public Node<T> find(T obj) {
		if(obj.compareTo(val) < 0) {
			if(left == null) {
				return null;
			}
			else {
				return left.find(obj);
			}
		}
		else {
			if(obj.compareTo(val) > 0) {
				if(right == null) {
					return null;
				}
				else {
					return right.find(obj);
				}
			}
			else {
				return this;
			}
		}
	}
	
	public T getValue(){
		return this.val;
	}
	
	public String toString() {
		return this.val.toString();
	}
	
	public <P extends NodeVisitor> void goThroughRootLeftRight(P visitor){
		visitor.visit(this);
		if(this.left != null) {
			this.left.goThroughRootLeftRight(visitor);
		}
		if(this.right != null) {
			this.right.goThroughRootLeftRight(visitor);
		}
	};
	
	public <P extends NodeVisitor> void goThroughLeftRightRoot(P visitor){
		if(this.left != null) {
			this.left.goThroughLeftRightRoot(visitor);
		}
		if(this.right != null) {
			this.right.goThroughLeftRightRoot(visitor);
		}
		visitor.visit(this);
	};
	
	public <P extends NodeVisitor> void goThroughLeftRootRight(P visitor){
		if(this.left != null) {
			this.left.goThroughLeftRootRight(visitor);
		}
		visitor.visit(this);
		if(this.right != null) {
			this.right.goThroughLeftRootRight(visitor);
		}
	};
	
	public Integer relationDegree(Node<T> ancestorNode) {
		if(ancestorNode == null || this == ancestorNode) {
			throw new IllegalArgumentException();
		}
		if(this.parent == ancestorNode) {
			return 1;
		}
		if(this.parent == null) {
			return -1;
		}
		
		int parentDegree = this.parent.relationDegree(ancestorNode);
		if( parentDegree == -1) {
			return -1;
		} else {
			return parentDegree + 1;
		}
	}
}