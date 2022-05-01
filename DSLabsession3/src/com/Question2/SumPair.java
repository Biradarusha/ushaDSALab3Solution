package com.Question2;

import java.util.HashSet;

public class SumPair {
	static class Node{
		int data;
		Node leftNode, rightNode;
		
	};
	
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data=data;
		temp.leftNode = null;
		temp.rightNode = null;
		
		return temp;
		
	}
	
	public Node insert(Node root, int key) {
		if(root==null)
			return newNode(key);
		if(key < root.data)
			root.leftNode = insert(root.leftNode,key);
		else
			root.rightNode = insert(root.rightNode,key);
		
			
		return root;
		
	}
	
	public boolean findpairSum(Node root, int sum, HashSet<Integer> set) {
		if(root == null)
			return false;
		if(findpairSum(root.leftNode,sum,set))
			return true;
		
		if(set.contains(sum-root.data)) {
			System.out.println("Pair is Found (" + (sum-root.data) + "," + root.data + ")");
			return true;
		
			
		}
		else
			set.add(root.data);
		return findpairSum(root.rightNode,sum,set);
			
	}
	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findpairSum(root,sum,set))
			System.out.println("Pair nodes are not found" + "\n");
		
		
		
	}
	public static void main(String[] args) {
		Node root = null;
		SumPair sp = new SumPair();
		root = sp.insert(root, 40);
		root = sp.insert(root, 20);
		root = sp.insert(root, 60);
		root = sp.insert(root, 10);
		root = sp.insert(root, 30);
		root = sp.insert(root, 50);
		root = sp.insert(root, 70);
		int sum=130;
		sp.findPairWithGivenSum(root, sum);
		
		
	}
	

}

