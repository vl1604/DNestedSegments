import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		runDNested(input);
	}

	private static void runDNested(Scanner input)
	{
		int size = input.nextInt();
		SegmentList list = new SegmentList(size);

		for (int i = 0; i < size; i++)
			list.addPair(input.nextInt(), input.nextInt());

		list.solve();
		list.printOutput();
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
