/*
This program creates a tree with the users input
This program has 5 methods - add, postOrder, preOrder, inOrder, search, delete and fndMaxReplace
This program uses objects from the class TreeTreeNode 
The object TreeTreeNode has a value, a right TreeTreeNode and a left TreeTreeNode
The object TreeTreeNode root is the starting point for the tree

add():
	the users input is passed as 'n'
	if the root is not defined, the root's value is set to 'n
	else if the node's value is 'n', the value is added to the right node
	else if the node's value is greater than 'n', the value is added to the left node

	if the left node is not null, add() is called passing the left node
	else if the node's value is lesser than 'n', thw value is added to the right node
	if the right node is not null, add() is called passing the right node

postOrder():
	if the node's left is not null, postOrder() is called passing the left node
	if the node's right is not null, postOrder() is called passing the right node
	prints the node's value

preOrder():
	prints the node's value
	if the node's left is not null, preOrder() is called passing the left node
	if the node's right is not null, preOrder() is called passing the right node

inOrder():
	if the node's left is not null, inOrder() is called passing the left node
	prints the node's value
	if the node's right is not null, inOrder() is called passing the right node

search():
	if the node is null, prints "item doesn't exist in tree"
	else
		if the node's value is the search, it prints "item exists in tree"
		if the node's value is greater than the search element, search() is caleld passing the left node
		if the node's value is lesser than the search element, search() is caleld passing the right node

delete():
	a number is passed to delete
	the specific node is found using recursions
	a replacement node is found using the fndMaxReplace() method
	if the previous node is equal to the delete node	
		the previous node's left is assigned to the replacement node's right
	else
		the previous node's right is assigned to the replacement node's left

fndMaxReplace():
	a node n is passed
	if n's right is not equal to null
	n is defined as n's right
	loops until n is equal to null
	the previous node is defined as n
	n is defined as n's left
	n is returned
	
Sample Input:
	8
	5
	10
	3
	6
	9
	13
	1
	4
	12
	14
Sample Output:
	Pre order: 8 5 3 1 4 6 10 9 13 12 14 
	Post order: 1 4 3 6 5 9 12 14 13 10 8 
	In order: 1 3 4 5 6 8 9 10 12 13 14 
	Enter number to search: 3
	Item exists in tree
	Enter number to delete: 8
	Pre order: 9 5 3 1 4 6 10 13 12 14 
	Post order: 1 4 3 6 5 12 14 13 10 9 
	In order: 1 3 4 5 6 9 10 12 13 14 
 */
public class Tree {
	TreeNode root = null;
	TreeNode prev = null;

	public void add(int n, TreeNode node) {
		if (root == null)
			root = new TreeNode(n);
		else if (node.value == n)
			add(n, node.right);
		else if (node.value > n)
			if (node.left == null)
				node.left = new TreeNode(n);
			else
				add(n, node.left);
		else if (node.value < n)
			if (node.right == null)
				node.right = new TreeNode(n);
			else
				add(n, node.right);
	}

	public void postOrder(TreeNode n) {
		if (n.left != null)
			postOrder(n.left);
		if (n.right != null)
			postOrder(n.right);
		System.out.print(n.value + " ");
	}

	public void preOrder(TreeNode n) {
		System.out.print(n.value + " ");
		if (n.left != null)
			preOrder(n.left);
		if (n.right != null)
			preOrder(n.right);
	}

	public void inOrder(TreeNode n) {
		if (n.left != null)
			inOrder(n.left);
		System.out.print(n.value + " ");
		if (n.right != null)
			inOrder(n.right);
	}

	public void search(TreeNode n, int num) {
		if (n != null)
			if (n.value == num) {
				System.out.println("Item exists in tree");
				return;
			} else if (n.value > num)
				search(n.left, num);
			else
				search(n.right, num);
		else
			System.out.println("Item doesn't exist in tree");
	}

	public void delete(TreeNode n, int num) {
		if (n != null) {
			if (n.value == num) {
				TreeNode temp = fndMaxReplace(n);
				n.value = temp.value;
				if (prev != n) {
					if (temp.right != null)
						prev.left = temp.right;
					else
						prev.left = null;
				} else if (temp.left != null)
					prev.right = temp.left;
				else
					prev.right = null;
			} else if (n.value > num)
				delete(n.left, num);
			else
				delete(n.right, num);
		} else
			System.out.println("Number not found");
	}

	public TreeNode fndMaxReplace(TreeNode n) {
		prev = n;
		if (n.right != null)
			n = n.right;
		while (n.left != null) {
			prev = n;
			n = n.left;
		}
		return n;
	}
}