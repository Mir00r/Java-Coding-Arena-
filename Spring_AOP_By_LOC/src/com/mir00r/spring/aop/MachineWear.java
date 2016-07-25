package com.mir00r.spring.aop;

public class MachineWear implements IMachine {
	/* (non-Javadoc)
	 * @see com.mir00r.spring.aop.IMachine#Star()
	 */
	@Override
	public void Start (){
		System.out.println("Machine is Starting........");
	}
}
