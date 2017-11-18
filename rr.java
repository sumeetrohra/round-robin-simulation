import java.util.Scanner;
//import javax.net.ssl.ExtendedSSLSession;
class rr
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("\nRound Robin simulation of Wi-Fi routers\nCreated by Sumeet\n");
		int n; //n is for number of users
		System.out.println("Enter number of users");
		n=sc.nextInt();

		String ip[]=new String[n]; //dhcp ip allocation array
		float data[]=new float[n]; //data input array for each ip

		System.out.println("\nEnter data to be transmitted in MB for each device");//accepting data in mbs and converting it into kbs
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextFloat();
			data[i] *= 1024;
		}

		int j=101; //allocation of ips to devices start here
		System.out.println();
		try {
		System.out.println("Allocated ips are");
		for(int i=0;i<n;i++)
		{	
			Thread.sleep(500);
			ip[i]="192.168.1."+(j+i);
			System.out.println(ip[i]);
		}	
			Thread.sleep(1000);
		// keep the transfer rate of 1024 kb/s or 1 mb/s
		//now starts the main logic
		int m=n;
		System.out.println();
		System.out.println("Starting data tranfer with a transfer rate of 1024 KBs/sec");
		System.out.println("IP allocated\tdata");
		Thread.sleep(500);
		while(m>=0)
		{
			for(int i=0;i<n;i++)
			{
				if(data[i]>=1024)
				{
					System.out.print(ip[i]+"\t");
					System.out.print("1024 KBs\n");
					data[i]-=1024;
				}
				else if(data[i]>0 && data[i]<1024)
				{
					System.out.print(ip[i] + "\t");
					System.out.print(data[i]+"KBs\n");
					data[i]=0;
				}
				else if(data[i]==0)
					continue;
				Thread.sleep(500);
			}
			System.out.println();
			Thread.sleep(1000);
			m--;
		}
		}
		catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}
}
	
/*
OUTPUT:

Round Robin simulation of Wi-Fi routers
Created by Sumeet

Enter number of users
5

Enter data to be transmitted in MB for each device
10
2
13
12
8

Allocated ips are
192.168.1.101
192.168.1.102
192.168.1.103
192.168.1.104
192.168.1.105

Starting data tranfer with a transfer rate of 1024 KBs/sec
IP allocated    data
192.168.1.101   1024 KBs
192.168.1.102   1024 KBs
192.168.1.103   1024 KBs
192.168.1.104   1024 KBs
192.168.1.105   1024 KBs

192.168.1.101   1024 KBs
192.168.1.102   1024 KBs
192.168.1.103   1024 KBs
192.168.1.104   1024 KBs
192.168.1.105   1024 KBs

192.168.1.101   1024 KBs
192.168.1.103   1024 KBs
192.168.1.104   1024 KBs
192.168.1.105   1024 KBs

192.168.1.101   1024 KBs
192.168.1.103   1024 KBs
192.168.1.104   1024 KBs
192.168.1.105   1024 KBs

192.168.1.101   1024 KBs
192.168.1.103   1024 KBs
192.168.1.104   1024 KBs
192.168.1.105   1024 KBs

192.168.1.101   1024 KBs
192.168.1.103   1024 KBs
192.168.1.104   1024 KBs
192.168.1.105   1024 KBs

*/