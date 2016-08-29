package TestingBundle.assertReflectEqual;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.util.Random;
import java.lang.Math;
public class ReflectiveRandomSetter {

	public static void settingRandomFieldValue(Object obj)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] allMethods = obj.getClass().getMethods();
		
		// ArrayList<Method> setters = new ArrayList<Method>();

		for (Method method : allMethods) {
			if (method.getName().startsWith("set")) {
				Class[] allParam = method.getParameterTypes();
				for (Class param : allParam) {
					if (param.isPrimitive()) {
						if (Integer.TYPE.equals(param)) {
							Random random = new Random();
							int randomInt = Math.abs(random.nextInt());
							method.invoke(obj, randomInt);
							// random.nextInt();
						} else if (Double.TYPE.equals(param)) {
							
							Random random = new Random();
							Double randomDouble = Math.abs(random.nextDouble());
							method.invoke(obj, randomDouble *100 );

						} else if (Long.TYPE.equals(param)) {
							Random random = new Random();
							long randomLong = Math.abs(random.nextLong());
							method.invoke(obj, randomLong);

						} else if (Short.TYPE.equals(param)) {
							Random random = new Random();
							short randomShort = (short) Math.abs(random.nextInt());
							method.invoke(obj, randomShort);
						} else if (Byte.TYPE.equals(param)) {
							Random random = new Random();
							byte[] randomBytes = new byte[1];
							random.nextBytes(randomBytes);
							method.invoke(obj, (byte) Math.abs( (int) randomBytes[0]));
						} 
					} else {
						if (java.util.Date.class.equals(param)) {
							Date date = genRandomDate();
							method.invoke(obj, date);
						}else if (String.class.equals(param)) {
							String uuid = UUID.randomUUID().toString();
							method.invoke(obj, uuid);
						}
					}
				}
			}
		}
	}

	public static Date genRandomDate() {
		Random rnd;
		Date dt;
		long ms;

		// Get a new random instance, seeded from the clock
		rnd = new Random();

		// Get an Epoch value roughly between 1940 and 2010
		// -946771200000L = January 1, 1940
		// Add up to 70 years to it (using modulus on the next long)
		ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));

		// Construct a date
		dt = new Date(ms);
		return dt;
	}
}