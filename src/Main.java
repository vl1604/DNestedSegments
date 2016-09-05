import java.util.*;

public class Main
{
	private static ArrayList<Segment> segments; 

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		runDNested(input);
	}

	private static void runDNested(Scanner input)
	{
		int size = input.nextInt();
		segments = new ArrayList<Segment>(size);

		for (int i = 0; i < size; i++)
		{
			segments.add(new Segment(
							 input.nextInt(),
							 input.nextInt(), 0, i));
		}

		solveArray(segments);
		printArray(segments);
	}

	private static void solveArray(ArrayList<Segment> a)
	{
		int size = a.size();
		int jl, jr, il, ir;
		int lmin = a.get(0).getL(), rmax = a.get(0).getR();

		sort(a);

		for (int j = 0; j < size; j++)
		{
			jl = a.get(j).getL();
			jr = a.get(j).getR();

			for (int i = j + 1; i < size; i++)
			{
				il = a.get(i).getL();
				ir = a.get(i).getR();

				if (j == 0)
				{
					if (il < lmin)
						lmin = il;
					if (ir > rmax)
						rmax = ir;
				}

				if (jl < il)
				{
					if (jr > ir)
						a.get(j).setNum(a.get(j).getNum() + 1);
				}
				else
				if (ir > jr)
					a.get(i).setNum(a.get(i).getNum() + 1);
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

	private static void unsort(ArrayList<Segment> a)
	{
		Collections.sort(a, 
			new Comparator<Segment>(){
				public int compare(Segment obj1, 
								   Segment obj2)
				{
					return  obj1.getPos() - obj2.getPos();
				}
			});
	}

	private static void printArray(ArrayList<Segment> a)
	{
		StringBuilder s = new StringBuilder();

		unsort(a);

		for (int j = 0; j < a.size(); j++)
			s.append(a.get(j).getNum()).append('\n');

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
