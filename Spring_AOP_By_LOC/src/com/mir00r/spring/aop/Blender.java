package com.mir00r.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Blender implements IBlender {
	/* (non-Javadoc)
	 * @see com.mir00r.spring.aop.IBlender#Blend()
	 */
	@Override
	public void Blend (){
		System.out.println("Blending........");
	}
}
