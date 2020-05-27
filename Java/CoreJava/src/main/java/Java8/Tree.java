package Java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class Node<T> {
	
	Node<T> left;
	Node<T> right;
	T data;
}

public class Tree {
	private Node<Integer> root;
	
	public static void main(String args[]) {
		
		Tree tree = new Tree();
		int dataRead = 0;
		
		tree.root = new Node<>();
		
		tree.root.data = 50;
		tree.root.left = null;
		tree.root.right = null;
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			
			System.out.println("Enter next node. Enter integer data. 0 to exit and print");
			
			dataRead = scanner.nextInt();
			
			if(dataRead == 0) {
				System.out.println("What order of tree to be printed. Enter the choice: " + 
						                 "  1. Inorder Traversal  " +  
						                 "  2. Preorder Traversal " +
						                 "  3. PostOrder Traversal" );
				dataRead = scanner.nextInt();
				if(dataRead != 1 && dataRead != 2 && dataRead != 3)
				{
					System.out.println("Wrong choice entered. Printing default inorder tree");
					printInorder(tree.root);
					break;
				}
				else if (dataRead == 1) {
					printInorder(tree.root);
				}
				else if(dataRead == 2) {
					printPreorder(tree.root);
				}
				else {
					printPostorder(tree.root);
				}
				//scanner.close();
				break;
			}
			
			createTree(tree.root,dataRead);
			
		}
		
		while(true) {
			System.out.println("Enter 2 numbers to find LCA in the tree");
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			if( null == tree.root )
			{
				System.out.println("No entry in the tree");
				scanner.close();
				System.exit(0);
			}
			
			Map<Boolean, Integer> bothExists = findElements(tree.root,n1,n2);
			
			for(Boolean key :  bothExists.keySet())
			{
				if(!key)
					System.out.println("Element : " + bothExists.get(key)+ " does not exist in the tree");
				scanner.close();
				System.exit(0);
			}
			
		}
		
	}

	private static Map<Boolean, Integer> findElements(Node<Integer> root, int n1, int n2) {
		// TODO Auto-generated method stub
		
		Map<Boolean, Integer> returnMap = new HashMap<>();
		int count = 0;
		
		/*if( (n1 > root.data && n2 < root.data) || (n1 < root.data && n2 > root.data)) {
			//searchElementFromCurrentRoot(root, n1, n2);
		}
		
		else if(n1 > root.data && n2 > root.data) {
			
		}
		
		else if(n1 < root.data && n2 < root.data) {
			
		}*/
		if(returnMap.size() > 0) {
			return returnMap;
		}
		
		if(root != null) {
			if(root.data == n1 || root.data == n2) {
				returnMap.put(true, root.data);
				count++;
			}
		}
		
		if(root != null) {
			Map<Boolean, Integer> resultMap1 = findElements(root.left,n1,n2);
			Map<Boolean, Integer> resultMap2 = findElements(root.right,n1,n2);
		}

		return returnMap;

	}

	private static void createTree(Node<Integer> root2, int dataRead) {
		
		if( null == root2.left && root2.data > dataRead) {
			root2.left = new Node<>();
			root2.left.data = dataRead;
			return;
		}
		
		else if(null == root2.right  && root2.data < dataRead) {
			root2.right = new Node<>();
			root2.right.data = dataRead;
			return;
		}
		
		else {
			if(dataRead < root2.data) {
				createTree(root2.left, dataRead);
			}
			else if(dataRead > root2.data) {
				createTree(root2.right, dataRead);
			}
		}
	}

	private static void printPostorder(Node<Integer> root2) {
		
		if(root2 == null ) {
			return;
		}
		printInorder(root2.right);
		System.out.print(root2.data + " " );
		printInorder(root2.left);
	}

	private static void printInorder(Node<Integer> root2) {
		
		if(root2 == null) {
			return;
		}
		printInorder(root2.left);
		System.out.print(root2.data + " " );
		printInorder(root2.right);
	}

	private static void printPreorder(Node<Integer> root2) {
		
		System.out.print(root2.data + " " );
		if(root2.left != null) {
			printInorder(root2.left);
		}
		if(root2.right != null ) {
			printInorder(root2.right);
		}
	}
	
}