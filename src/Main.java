import java.util.*;

public class Main
{
	private static ArrayList<Integer> array; 

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		runDNested(input);
	}

	private static void runDNested(Scanner input)
	{
		int size = input.nextInt();
		array = new ArrayList<Integer>(3 * size);

		for (int i = 0; i < size; i++)
		{
			array.add(input.nextInt());
			array.add(input.nextInt());
			array.add(0);
		}

		solveArray(array);
		printArray(array);
	}

	private static void solveArray(ArrayList<Integer> a)
	{
		int size = a.size();

		for (int j = 0; j < size; j += 3)
			for (int i = 0; i < size; i += 3)
			{
				if (j == i)
					continue;

				if (a.get(j) < a.get(i)
					&& a.get(j + 1) > a.get(i + 1))
					a.set(j + 2, a.get(j + 2) + 1);
			}
	}

	private static void printArray(ArrayList<Integer> a)
	{
		StringBuilder s = new StringBuilder();

		for (int j = 0; j < a.size(); j += 3)
			s.append(a.get(j + 2)).append('\n');

		System.out.print(s);
	}
}
