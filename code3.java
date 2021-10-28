class Code3
{
	public static void main(String[] args)
	{
		int n = 123;
		fun(n);
	}
}

public static void fun(int n)
{
	int last;
	for (int i = 0; n != 0; i++)
	{
		last = n % 10;
		n = n / 10;
		System.out.print(last);
	}
}
