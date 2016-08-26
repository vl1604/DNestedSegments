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
//		SegmentList list = new SegmentList(size);

//		for (int i = 0; i < size; i++)
//			list.addPair(input.nextInt(), input.nextInt());

		array = new ArrayList<Integer>(3 * size);

		for (int i = 0; i < size; i++)
		{
			array.add(input.nextInt());
			array.add(input.nextInt());
			array.add(0);
		}

		solveArray(array);
		printArray(array);

//		list.solve();
//		list.printOutput();
	}

	private static void solveArray(ArrayList<Integer> a)
	{
		int size = a.size();

		for (int j = 0; j < size; j += 3)
			for (int i = 0; i < size; i += 3)
			{
				if (j == i)
					continue;

				if (a.get(j) < a.get(i) && 
					a.get(j + 1) > a.get(i + 1))
					a.set(j + 2, a.get(j + 2) + 1);

				System.out.printf(
					"(%d, %d) contains " +
					"(%d, %d)" +
					" - %d times\n",
					a.get(j), a.get(j + 1),
					a.get(i), a.get(i + 1),
					a.get(j + 2)
				);
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

class Segment
{
	private int l,r,n;

	public Segment(int l, int r)
	{
		this.l = l;
		this.r = r;
		this.n = 0;
	}

	public void setL(int l)
	{
		this.l = l;
	}

	public int getL()
	{
		return l;
	}

	public void setR(int r)
	{
		this.r = r;
	}

	public int getR()
	{
		return r;
	}

	public void incN()
	{
		n++;
	}

	public int getN()
	{
		return n;
	}

	public boolean contains(Segment seg)
	{
		return this.l < seg.l && this.r > seg.r;
	}
}

class SegmentList
{
	private List<Segment> list = new ArrayList<Segment>();
	private int size;

	public SegmentList(int size)
	{
		this.size = size;
	}

	public void addPair(int l, int r)
	{
		list.add(new Segment(l, r));
	}

	public void setL(int index, int value)
	{
		list.get(index).setL(value);
	}

	public int getL(int index)
	{
		return list.get(index).getL();
	}

	public void setR(int index, int value)
	{
		list.get(index).setR(value);
	}

	public int getR(int index)
	{
		return list.get(index).getR();
	}

	public void solve()
	{
		for (int j = 0; j < size; j++)
			for (int i = 0; i < size; i++)
			{
				if (j == i)
					continue;

				if (list.get(j)
					.contains(list.get(i)))
				{
					list.get(j).incN();

					System.out.printf(
						"(%d, %d) contains " +
						"(%d, %d)" +
						" - %d times\n",
						list.get(j).getL(),
						list.get(j).getR(),
						list.get(i).getL(),
						list.get(i).getR(),
						list.get(j).getN()
					);
				}
			}
	}

	public void printOutput()
	{
		for (int j = 0; j < size; j++)
			System.out.println(
				list.get(j).getN());
	}
}
