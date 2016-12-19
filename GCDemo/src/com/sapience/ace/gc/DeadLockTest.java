package com.sapience.ace.gc;

public class DeadLockTest
{

	public static void main(String[] args)
	{
		String str1 = "dfgfd";
		String str2 = "fdgfg";
		new Thread(new Thread1(str1, str2)).start();
		new Thread(new Thread2(str1, str2)).start();
	}
}

class Thread1 implements Runnable
{
	String str1;
	String str2;

	public Thread1(String str1, String str2)
	{
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public void run()
	{
		synchronized (str2)
		{

			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (str1)
			{
				while (true)
					;
			}
		}
	}
}

class Thread2 implements Runnable
{
	String str1;
	String str2;

	public Thread2(String str1, String str2)
	{
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public void run()
	{
		synchronized (str1)
		{

			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (str2)
			{
				while (true)
					;
			}
		}

	}
}
