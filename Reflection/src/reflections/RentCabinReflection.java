package reflections;


//import java.lang.reflect.Constructor;
import java.lang.reflect.*;
import java.util.Arrays;

/**
 * 
 */

/**
 *  Program to utilize reflection and several class methods related to reflection
 *  
 * @author lance brown
 * @version 1.0
 * @since 2021-06-29
 *
 */
public class RentCabinReflection {

	/**
	 * Method main
	 * Abstract main method
	 * @param args none
	 */
	public static void main(String[] args) {
		Class<RentCabin> rental = RentCabin.class;
		try {
			String rentalClassPackage = rental.getCanonicalName();
			System.out.println("Class Name is: " + rentalClassPackage);
			String rentalClassNoPackage = rental.getSimpleName();
			System.out.println("Class Name without package is : " + rentalClassNoPackage);
			String rentalPackage = rental.getPackageName();
			System.out.println("Package name is: " + rentalPackage);
			Constructor[] constructors = rental.getConstructors();
			System.out.println("Constructors are: " + Arrays.toString(constructors));
			Class cls[] = new Class[] {int.class};
			Constructor constructorWithArgs = rental.getConstructor(int.class);
			System.out.println("Constructor with arg of type int: " + constructorWithArgs.toString());
			RentCabin largeRental = (RentCabin) constructorWithArgs.newInstance(2001);
			Method[] methods = rental.getDeclaredMethods();
			System.out.println("Declared methods are: " + Arrays.toString(methods));
			for(Method method : methods) {
				System.out.println("method = " + method.getName());
			}
			
			Method oneMethod = rental.getDeclaredMethod("computeRentalCost", int.class);
			System.out.println("Method is: " + oneMethod);
			oneMethod.invoke(largeRental, 2);
			int price = largeRental.price;
			System.out.println("The cost of your rental cabin is " + price + " USD");
			Class[] parameterTypes = oneMethod.getParameterTypes();
			System.out.println("Parameter types of computeRentalCost() are: " + Arrays.toString(parameterTypes));
			Class returnType = oneMethod.getReturnType();
			System.out.println("Return type is: " + returnType);
			Field[] fields = rental.getFields();
			System.out.println("Public Fields are: ");
			for(Field field : fields) {
				String fieldname = field.getName();
				System.out.println("Fieldname is: " + fieldname);
				
				Object fieldType = field.getType();
				System.out.println("Type of field " + fieldname + " is: " + fieldType);
				
				Object value = field.get(largeRental);
				System.out.println("Value of field " + fieldname + " is: " + value);
			}
			Field privateField = rental.getDeclaredField("type");
			String name = privateField.getName();
			System.out.println("One private Fieldname is: " + name);
			privateField.setAccessible(true);
			Object fieldValue = privateField.get(largeRental);
			System.out.println("fieldValue = " + fieldValue);
		} catch(NoSuchFieldException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
