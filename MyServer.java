import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer
{
	public static void main(String[] args)
	{
		try
		{							
			ServerSocket ser=new ServerSocket(8000);
			
			Socket client=ser.accept();
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			int a[]=new int[10];
			int i,s=0,max,min;
			
			for(i=0;i<10;i++)
			{
				a[i]=dis.readInt();
				s=s+a[i];
			}
			min=a[0];
			max=a[0];
			for(i=0;i<10;i++)
			{
			
				if(a[i]<min)
				{
					min=a[i];
				}
				if(a[i]>max)
				{
					max=a[i];
				}
			}
			dos.writeInt(s);
			dos.writeInt(max);
			dos.writeInt(min);
			
			dis.close();
			dos.close();
			client.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SERVER ERROR : "+e.getMessage());
		}
	}
}