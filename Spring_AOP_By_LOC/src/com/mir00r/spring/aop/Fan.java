package com.mir00r.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Fan implements IFan  {
	/* (non-Javadoc)
	 * @see com.mir00r.spring.aop.IFan#Active(int)
	 */
	@Override
	public void Active ( int level ){
		System.out.println("Fan Running level is: " + level);
	}
}
