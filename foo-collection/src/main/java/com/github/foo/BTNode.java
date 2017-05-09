package com.github.foo;

import java.util.Objects;

/**
 * Class representing the node of Tree
 * @author Gaurav Rai Mazra
 *
 * @param <T>
 */
public class BTNode<T> implements Node<T> {
	private T value;
	private BTNode<T> left;
	private BTNode<T> right;

	public BTNode(T value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see com.github.foo.Node#getValue()
	 */
	@Override
	public T getValue() {
		return this.value;
	}
	
	BTNode<T> left() {
		return this.left;
	}
	
	BTNode<T> right() {
		return this.right;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		add("\"left\"", left, builder);
		add("\"right\"", right, builder);
		builder.append("\"value\": ").append(value).append("}");
		return builder.toString();
	}

	private void add(String key, Node<T> tree, StringBuilder builder) {
		if (Objects.nonNull(tree)) {
			builder.append(key).append(":").append(tree).append(",");
		}
	}

	void right(BTNode<T> node) {
		this.right = node;
	}
	
	void left(BTNode<T> node) {
		this.left = node;
	}

	@Override
	public int height() {
		if (left != null) {
			return left.height() + 1;
		}
		return 1;
	}
}
