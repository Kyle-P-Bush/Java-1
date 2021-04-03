public class CookingTester
{
	public static void main(String[] args)
	{
		String error;
		error = testTeaspoonToTablespoon();
		if (error != null) { System.out.println(error); return;}
		error = testTablespoonToTeaspoon();
		if (error != null) { System.out.println(error); return;}
		error = testTablespoonToCup();
		if (error != null) { System.out.println(error); return;}
		error = testCupToTablespoon();
		if (error != null) { System.out.println(error); return;}
		error = testOuncesToCup();
		if (error != null) { System.out.println(error); return;}
		error = testCupToOunces();
		if (error != null) { System.out.println(error); return;}
		error = testPintToCup();
		if (error != null) { System.out.println(error); return;}
		error = testCupToPint();
		if (error != null) { System.out.println(error); return;}
		System.out.println("Cooking: Correct!");
	}

	public static String testTeaspoonToTablespoon()
	{
		double portion;

		portion = Cooking.teaspoonToTablespoon(0);
		if (portion != 0.0) return "Cooking.teaspoonToTablespoon(0)";
		portion = Cooking.teaspoonToTablespoon(60);
		if (portion != 1.0) return "Cooking.teaspoonToTablespoon(60)";
		portion = Cooking.teaspoonToTablespoon(3600);
		if (portion != 60.0) return "Cooking.teaspoonToTablespoon(3600)";
		portion = Cooking.teaspoonToTablespoon(999999);
		if (portion != 16666.65) return "Cooking.teaspoonToTablespoon(999999)";
		return null;
	}

	public static String testTablespoonToTeaspoon()
	{
		double portion;

		portion = Cooking.tablespoonToTeaspoon(0);
		if (portion != 0.0) return "Cooking.tablespoonToTeaspoon(0)";
		portion = Cooking.tablespoonToTeaspoon(60);
		if (portion != 0.016666666666666666) return "Cooking.tablespoonToTeaspoon(60)";
		portion = Cooking.tablespoonToTeaspoon(3600);
		if (portion != 1.0) return "Cooking.tablespoonToTeaspoon(3600)";
		portion = Cooking.tablespoonToTeaspoon(999999);
		if (portion != 277.77750000000003) return "Cooking.getportionCirlce(999999)";
		return null;
		
	}

	public static String testTablespoonToCup()
	{
		double portion;

		portion = Cooking.tablespoonToCup(0);
		if (portion != 0) return "Cooking.tablespoonToCup(0)";
		portion = Cooking.tablespoonToCup(60);
		if (portion != 6.944444444444445E-4) return "Cooking.tablespoonToCup(60)";
		portion = Cooking.tablespoonToCup(3600);
		if (portion != 0.041666666666666664) return "Cooking.tablespoonToCup(3600)";
		portion = Cooking.tablespoonToCup(999999);
		if (portion != 11.574062500000002) return "Cooking.tablespoonToCup(999999)";
		return null;
	}

	public static String testCupToTablespoon()
	{
		double portion;

		portion = Cooking.cupToTablespoon(0);
		if (portion != 0.0) return "Cooking.cupToTablespoon(0)";
		portion = Cooking.cupToTablespoon(60);
		if (portion != 1.9025875190258753E-6) return "Cooking.cupToTablespoon(60)";
		portion = Cooking.cupToTablespoon(3600);
		if (portion != 1.1415525114155251E-4) return "Cooking.cupToTablespoon(3600)";
		portion = Cooking.cupToTablespoon(999999);
		if (portion != 0.031709760273972605) return "Cooking.cupToTablespoon(999999)";
		return null;
	}

	public static String testOuncesToCup()
	{
		double portion;

		portion = Cooking.ouncesToCup(1);
		if (portion != 60.0) return "Cooking.ouncesToCup(1)";
		portion = Cooking.ouncesToCup(60);
		if (portion != 3600.0) return "Cooking.ouncesToCup(60)";
		portion = Cooking.ouncesToCup(3600);
		if (portion != 216000.0) return "Cooking.ouncesToCup(3600)";
		portion = Cooking.ouncesToCup(999999);
		if (portion != 5.999994E7) return "Cooking.getportionCirlce(999999)";
		return null;
	}

	public static String testCupToOunces()
	{
		double portion;

		portion = Cooking.cupToOunces(1);
		if (portion != 3600.0) return "Cooking.cupToOunces(1)";
		portion = Cooking.cupToOunces(60);
		if (portion != 216000.0) return "Cooking.cupToOunces(60)";
		portion = Cooking.cupToOunces(3600);
		if (portion != 1.296E7) return "Cooking.cupToOunces(3600)";
		portion = Cooking.cupToOunces(999999);
		if (portion != 3.5999964E9) return "Cooking.cupToOunces(999999)";
		return null;
	}

	public static String testPintToCup()
	{
		double portion;

		portion = Cooking.pintToCup(1);
		if (portion != 86400.0) return "Cooking.pintToCup(1)";
		portion = Cooking.pintToCup(60);
		if (portion != 5184000.0) return "Cooking.pintToCup(60)";
		portion = Cooking.pintToCup(3600);
		if (portion != 3.1104E8) return "Cooking.pintToCup(3600)";
		portion = Cooking.pintToCup(999999);
		if (portion != 8.63999136E10) return "Cooking.pintToCup(999999)";
		return null;
	}

	public static String testCupToPint()
	{
		double portion;

		portion = Cooking.cupToPint(1);
		if (portion != 3.1536E7) return "Cooking.cupToPint(1)";
		portion = Cooking.cupToPint(60);
		if (portion != 1.89216E9) return "Cooking.cupToPint(60)";
		portion = Cooking.cupToPint(3600);
		if (portion != 1.135296E11) return "Cooking.cupToPint(3600)";
		portion = Cooking.cupToPint(999999);
		if (portion != 3.1535968464E13) return "Cooking.cupToPint(999999)";
		return null;
	}




}