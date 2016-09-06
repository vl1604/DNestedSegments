import java.util.*;

public class Main
{
	private static ArrayList<Segment> segments;
	private static HashMap<Integer, Integer> map;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		runDNested(input);
	}

	private static void runDNested(Scanner input)
	{
		int size = input.nextInt();
		segments = new ArrayList<Segment>(size);
		map = new HashMap<Integer, Integer>(size);

		for (int i = 0; i < size; i++)
			segments.add(new Segment(
							 input.nextInt(),
							 input.nextInt(), 0, i));

		solveArray(segments);
		printArray(segments);
	}

	private static void solveArray(ArrayList<Segment> a)
	{
		int size = a.size();
		int jr, ir;
		Segment segJ, segI;

		sort(a);

		for (int j = 0; j < size; j++)
		{
			segJ = a.get(j);
			jr = segJ.getR();

			map.put(segJ.getPos(), j);

			for (int i = j + 1; i < size; i++)
			{
				segI = a.get(i);
				ir = segI.getR();

				if (jr > ir && jr > segI.getL())
					segJ.setNum(segJ.getNum() + 1);
			}
		}
	}

	private static void sort(ArrayList<Segment> a)
	{
		Collections.sort(a, 
			new Comparator<Segment>(){
				public int compare(Segment obj1, 
								   Segment obj2)
				{
					return  obj1.getL() - obj2.getL();
				}
			});
	}

	private static void printArray(ArrayList<Segment> a)
	{
		StringBuilder s = new StringBuilder();

		for (int j = 0; j < a.size(); j++)
			s.append(a.get(map.get(j)).getNum())
				.append('\n');

		System.out.print(s);
	}
};

class Segment
{
	int l,r,num,pos;

	public Segment(int l, int r, int num, int pos)
	{
		this.l = l;
		this.r = r;
		this.num = num;
		this.pos = pos;
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

	public void setNum(int num)
	{
		this.num = num;
	}

	public int getNum()
	{
		return num;
	}

	public void setPos(int pos)
	{
		this.pos = pos;
	}

	public int getPos()
	{
		return pos;
	}
}
