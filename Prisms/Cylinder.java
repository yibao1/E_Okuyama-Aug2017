/* Write this concrete (non-abstract) class called Cylinder that extends Prism.  
 * It has a private field (radius) and inherits its height from its superclass, Prism 
 *    (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class Cylinder extends Prism 
{
	
	private double radius;
	public Cylinder(double radius, double height) {
		super(height);
		this.radius = radius;
	}

	public double calcAreaOfBase() {
		return Math.PI * radius * radius;
	}

	public double calcPerimeter() {
		return Math.PI * 2 * radius;
	}	

	
}
