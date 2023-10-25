package CoreJava;

import java.util.Random;

public class EmployeeGenerator {

	int age;

	int experience;

	int level;

	Random random = new Random();

	public void nameGenertor() {

		String inputChar = "abcdefghijklmnopqrstuvwxyz";

		String FirstName = "";

		int len = random.nextInt(3, 8);

		char[] text = new char[len];

		for (int i = 0; i < len; i++) {

			if (i == 0) {

				text[i] = Character.toUpperCase(inputChar.charAt(random.nextInt(inputChar.length())));

			}

			else

			{

				text[i] = inputChar.charAt(random.nextInt(inputChar.length()));

			}

		}

		for (int i = 0; i < text.length; i++) {

			FirstName += Character.toString(text[i]);

		}

		String LastName = "";

		int len1 = random.nextInt(0, 6);

		char[] text1 = new char[len1];

		for (int i = 0; i < len1; i++) {

			if (i == 0) {

				text1[i] = Character.toUpperCase(inputChar.charAt(random.nextInt(inputChar.length())));

			}

			else

			{

				text1[i] = inputChar.charAt(random.nextInt(inputChar.length()));

			}

		}

		for (int i = 0; i < text1.length; i++) {

			LastName += Character.toString(text1[i]);

		}

		System.out.println("Name = "+FirstName + " " + LastName);

	}

	public void ageGenerator() {

		age = random.nextInt(22, 60);

		System.out.println("Age = " + age);

	}

	public void experianceGenerator() {

		if (age == 22)
			experience = 0;

		if (age == 23)
			experience = random.nextInt(0, 1);

		if (age == 24)
			experience = random.nextInt(0, 2);

		if (age == 25)
			experience = random.nextInt(0, 3);

		if (age >= 26) {

			experience = age - random.nextInt(22, 25);
		}

		System.out.println("Experience = " + experience);

	}

	public void levelGenerator() {

		if (experience < 3) {

			level = random.nextInt(1, 2);

		}

		else if (experience < 5 && experience >= 3) {

			level = random.nextInt(2, 3);

		}

		else if (experience < 8 && experience >= 5) {

			level = random.nextInt(3, 5);

		}

		else {

			level = 5;

		}

		System.out.println("L" + level);

	}

	public void details() {
    int n=random.nextInt(1,10);
    for(int i=0;i<n;i++) {
		nameGenertor();

		ageGenerator();

		experianceGenerator();

		levelGenerator();
		System.out.println();
		
    }
	}

	public static void main(String[] args) {

		EmployeeGenerator e1 = new EmployeeGenerator();

		e1.details();

	}

}