import java.util.Iterator;
import java.util.LinkedList;

/*Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor is defined between two nodes 
v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a 
		descendant of itself).¡±

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of 
nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.*/
public class _235_LowestCommonAncestorofaBinarySearchTree {
	private static LinkedList<TreeNode> getLinkedList(TreeNode root, TreeNode p) {
		LinkedList<TreeNode> result = new LinkedList<>();
		TreeNode runner = root;
		while (runner != p) {
			if (runner.val > p.val) {
				result.add(runner);
				runner = runner.left;
			} else if (runner.val < p.val) {
				result.add(runner);
				runner = runner.right;
			}
		}
		result.add(p);
		Iterator<TreeNode> iterator = result.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().val);

		}
		System.out.println(result);

		return result;

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList<TreeNode> l1 = getLinkedList(root, p);
		LinkedList<TreeNode> l2 = getLinkedList(root, q);
		LinkedList<TreeNode> result = new LinkedList<>();
		while (!l1.isEmpty() && !l2.isEmpty()) {

			if (l1.getFirst().val == l2.getFirst().val) {
				result.add(l1.getFirst());
				l1.removeFirst();
				l2.removeFirst();
			} else {
				break;
			}

		}
		System.out.println(result);
		return result.getLast();
	}

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(6);
		// root.left = new TreeNode(2);
		// TreeNode r2 = root.left;
		//
		// root.right = new TreeNode(8);
		// TreeNode r3 = root.right;
		//
		// root.left.left = new TreeNode(0);
		// TreeNode r4 = root.left.left;
		//
		// root.left.right = new TreeNode(4);
		// TreeNode r5 = root.left.right;
		//
		// lowestCommonAncestor(root, r2, r3);

		// TreeNode root = new TreeNode(2);
		// root.left = new TreeNode(1);
		// TreeNode r2 = root.left;
		// lowestCommonAncestor(root, root, r2);

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		TreeNode r2 = root.left;
		root.right = new TreeNode(3);
		TreeNode r3 = root.right;
		lowestCommonAncestor(root, r2, r3);

	}
}
