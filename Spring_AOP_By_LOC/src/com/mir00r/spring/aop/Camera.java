package com.mir00r.spring.aop;

import org.springframework.stereotype.Component;

@Component("camera")
public class Camera implements PhotoSnapper, Machine, ICamera {
	
	//@Override
	//@Deprecated
	/*public void Snap () throws Exception {
		System.out.println("Take a one Snapshot");
	
		throw new Exception("bye bye.....");
	}

	public void SnapCar(Car car) {
		
	}
	
	@Override
	  public void Snap( int exposure ){
		System.out.println("Snap with exposure is: "+ exposure);
	}
	@Override
	public String Snap(String name){
		System.out.println("Snap with name: " + name);
		return name;
	}
	@Override
	public void SnapNightTime(){
		System.out.println("Snap Night Time is begin so please silent");
	}*/
	
	
	// Getting Target Method Arguments by using joinpoint
	/*public Camera() {
		System.out.println("Hello from camera constructor");
	}*/
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snap()
	 */
	@Override
	@Deprecated
	public void Snap() {
		System.out.println("SNAP!");

	}
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snap(int)
	 */
	@Override
	public void Snap(int exposure) {
		System.out.println("SNAP! Exposure:" + exposure);
	}
	
	@Override
	public void Snap(double exposure) {
		System.out.println("SNAP! Exposure:" + exposure);
	}
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snap(java.lang.String)
	 */
	@Override
	public String Snap(String name) {
		System.out.println("SNAP! Name:" + name);
		
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.caveofprogramming.spring.aop.ICamera#snapNighttime()
	 */
	@Override
	public void SnapNighttime() {
		System.out.println("SNAP! Night mode.");
	}
	
	public void SnapCar(Car car) {
		System.out.println("Snapping car!");
	}

	@Override
	public void Snap(int exposure, double aperture) {
		System.out.printf("SNAP with exposure %d aperture %.2f\n", exposure, aperture);
		
	}
	
	
	
	
	
	
}
