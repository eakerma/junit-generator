package edu.uark.util.junit.generator;

import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Method;

public final class Main
{
	public static void main ( final String[] args ) throws ClassNotFoundException
	{
		final String className = args[0].replace("/",".");
		final Class c = Class.forName ( className );

		System.out.println ( "package " + c.getPackage ().getName () + ";" );
		System.out.println ( "" );
		System.out.println ( "import org.junit.Test;" );
		System.out.println ( "import static org.junit.Assert.*;" );
		System.out.println ( "" );
		System.out.println ( "public class " + c.getSimpleName () + "Test" );
		System.out.println ( "{" );

		for ( final Method m : c.getDeclaredMethods () )
		{
			System.out.println ( indent ( "@Test" ) );
			System.out.println ( indent ( "public void test" + StringUtils.capitalize ( m.getName () ) + " ()" ) );
			System.out.println ( indent ( "{" ) );
			System.out.println ( indent ( "}" ) );
			System.out.println ( "" );
		}

		System.out.println ( "}" );
	}

	private static String indent ( String value )
	{
		return "\t" + value;
	}
}