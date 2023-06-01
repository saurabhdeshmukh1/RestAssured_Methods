import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import commonFunctionPackage.utility_Common_Function;
import testClassPackage.Post_tc_1;

public class Driver_Class {
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException,
	ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Post_tc_1.execute();
	}
}