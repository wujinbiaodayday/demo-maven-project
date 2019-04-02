package com.ddc.common.demo.common.util;

/**
 * Created by LongBing on 2018/3/13.
 */
public class ComboOption<V, T> {
	private V value;
	private T text;
	private Boolean selected;

	public ComboOption() {
	}

	public ComboOption(V value, T text) {
		this.value = value;
		this.text = text;
	}

	public ComboOption(V value, T text, Boolean selected) {
		this.value = value;
		this.text = text;
		this.selected = selected;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public T getText() {
		return text;
	}

	public void setText(T text) {
		this.text = text;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
