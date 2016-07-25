package com.mir00r.spring.aop;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.mir00r.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("com/mir00r/spring/aop/beans.xml");
		
		//Camera camera = (Camera) context.getBean("camera");
		
/*		ICamera camera = (ICamera) context.getBean("camera");
		Lens lens = (Lens) context.getBean("lens");*/
		
		/*try {
			camera.Snap();
		} 
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		/*camera.Snap();
		camera.Snap(1000);
		camera.Snap("Black & White");
		camera.Snap(500);
		camera.Snap(1.8);
		camera.Snap(500, 1.8);
		camera.SnapNighttime();
		
		lens.zoom(5);
		
		Car car = (Car) context.getBean("car");
		car.Srart();
		
		camera.SnapCar(car);*/
		
		
		IBlender blender = (IBlender)context.getBean("blender");
		( (IMachine) blender).Start();
		blender.Blend();
		
		
		IFan fan = (IFan) context.getBean("fan");
		( (IMachine) fan).Start();
		fan.Active(3);
		
		context.close();
//		((ClassPathXmlApplicationContext) context).close();
	}	

}
