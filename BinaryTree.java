/*
 * Implementing a binary tree with insertion, search and deletion operations as well as some traversals.
 * 
 * */
package binaryTree;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
	Node root;
	
	public Node insert(Node current, int val) {
		if(current == null) {
			return new Node(val);
		}

			if(val < current.data) {
				current.left = insert(current.left, val);
			}
			if(val > current.data) {
				current.right = insert(current.right, val);
			}
			else {
				return current;
			}
		
		return current;
	}
	
	public boolean contains(Node current, int val) {
		if(current == null) return false;
		if(current.data == val) return true;
			if(val < current.data) {
				return contains(current.left, val);
			}else {
				return contains(current.right, val);
			}
			}
	
	public int smallestVal(Node current) {
		while(current.left!=null) {
			current = current.left;
		}
		return current.data;
	}
	
	public Node delete(Node current, int val) {
		if(current == null) return null;
		if(val == current.data) {
		if(current.left==null && current.right==null) return null;
		if(current.left == null) return current.right;
		if(current.right == null) return current.left;
		int smallVal = smallestVal(current.right);
		current.data = smallVal;
		current.right= delete(current.right, smallVal);
		return current;
		}
		
		if(val < current.data) {
			current.left = delete(current.left, val);
			return current;
		}
		current.right = delete(current.right, val);
		return current;
	}
	//DFS
	public void inOrder(Node current) {
		if(current!=null) {
			inOrder(current.left);
			System.out.print(current.data+" ");
			inOrder(current.right);
		}
	}
	
	public void preOrder(Node current) {
		if(current!=null) {
			System.out.print(current.data+" ");
			preOrder(current.left);
			preOrder(current.right);
		}
	}
	
	public void postOrder(Node current) {
		if(current!=null) {
			postOrder(current.left);
			postOrder(current.right);
			System.out.print(current.data+" ");
		}
		
	}
	
	//BFS aka Level-order traversal
	public void BFS(Node current) {
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(current);
		while(!qu.isEmpty()) {
			Node el = (Node)qu.poll();
			System.out.print(el.data+" ");
			if(el.left!=null)qu.add(el.left);
			if(el.right!=null)qu.add(el.right);
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = bt.insert(bt.root,6);
		bt.root = bt.insert(bt.root, 4);
		bt.root = bt.insert(bt.root, 12);
		bt.root = bt.insert(bt.root, 8);
		bt.root = bt.insert(bt.root, 2);
		bt.root = bt.insert(bt.root, 17);
		bt.root = bt.insert(bt.root, 7);
		bt.root = bt.insert(bt.root, 9);
		bt.root = bt.insert(bt.root, 15);
		bt.root = bt.insert(bt.root, 19);
		System.out.println(bt.contains(bt.root, 12));
		System.out.println(bt.contains(bt.root, 14));	
		System.out.println(bt.smallestVal(bt.root));
		System.out.print("Inorder: ");
		bt.inOrder(bt.root);
		
		System.out.print("Preorder: ");
		bt.preOrder(bt.root);
		
		System.out.print("Postorder: ");
		bt.postOrder(bt.root);
		
		System.out.println();
		System.out.print("BFS: ");
		bt.BFS(bt.root);
		bt.delete(bt.root, 12);
		System.out.println(bt.contains(bt.root,8));
		
	}
	
	
	

}
