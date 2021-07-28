package com.Charlotte.Minecraft.CharlotteUtils.Blocks;

public enum BlockDataType {
	String(String.class), Integer(int.class), Float(float.class), Double(double.class), StringArray(String[].class),
	IntegerArray(int[].class), FloatArray(float[].class), DoubleArray(double[].class);

	private Class<?> clazz;

	private BlockDataType(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Class<?> getValue() {
		return clazz;
	}
}
