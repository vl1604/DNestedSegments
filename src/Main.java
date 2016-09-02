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
		int jl, jr, il, ir;
		int lmin = a.get(0), rmax = a.get(1);


		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int j = 0; j < size; j += 3)
		{
			ArrayList<Integer> item = new ArrayList<Integer>();
			item.add(a.get(j));
			item.add(a.get(j + 1));
			item.add(a.get(j + 2));

			list.add(item);
		}
		Collections.sort(list, 
			new Comparator<ArrayList>(){
				public int compare(ArrayList<Integer> obj1, 
								   ArrayList<Integer> obj2)
				{
					return  obj1.get(0) - obj2.get(0);
				}
			});


		for (int j = 0; j < size; j += 3)
		{
			jl = a.get(j);
			jr = a.get(j + 1);

			for (int i = j + 3; i < size; i += 3)
			{
				il = a.get(i);
				ir = a.get(i + 1);

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
						a.set(j + 2, a.get(j + 2) + 1);
				}
				else
				if (ir > jr)
					a.set(i + 2, a.get(i + 2) + 1);
			}
		}
	}

	private static void printArray(ArrayList<Integer> a)
	{
		StringBuilder s = new StringBuilder();

		for (int j = 0; j < a.size(); j += 3)
			s.append(a.get(j + 2)).append('\n');

		System.out.print(s);
	}

	private class Segment
	{
		int l,r,num,pos;


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
		}}
}


