package com.mir00r.spring.aop;

public interface ICamera {
	public abstract void Snap();

	public abstract void Snap(int exposure);

	public abstract String Snap(String name);

	public abstract void SnapNighttime();

	public abstract void SnapCar(Car car);

	void Snap(int exposure, double aperture);

	void Snap(double exposure);
}
