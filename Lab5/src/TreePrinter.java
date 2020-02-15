
public class TreePrinter implements NodeVisitor{
	
	public void visit(Node<?> node) {
		System.out.println(node);
	}
}
