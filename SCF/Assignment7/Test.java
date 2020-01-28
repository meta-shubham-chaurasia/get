package Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
	

	public static void main(String[] args)throws IOException {

		int choice,choice2;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<NorthZone> cages1=new ArrayList<NorthZone>();
		ArrayList<SouthZone> cages2=new ArrayList<SouthZone>();
		ArrayList<WestZone> cages3=new ArrayList<WestZone>();
		
		int cages1Size=2;
		int cages2Size=3;
		int cages3Size=4;
		
		Cow cow1=new Cow("rama",2);
		Crocodile croc1=new Crocodile("magar",4);
		Ant ant1=new Ant("chiti",12);		
		
		NorthZone cage1=new NorthZone();
		SouthZone cage2=new SouthZone();
		WestZone cage3=new WestZone();
		
		cage1.AddAnimal(cow1);
		cages1.add(cage1);
		
		cage2.AddAnimal(croc1);
		cages2.add(cage2);
		
		cage3.AddAnimal(ant1);
		cages3.add(cage3);

		int l=0,m=0,n=0;
		for(int i=1;i>0;i++)
		{
			boolean o=true,op=true,opq=true;
			System.out.println("Enter 1 to add animals,2 to remove,3 to display zone information,4 to stop");
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:System.out.println("Enter 1 if you want to add mammal,2 for reptile,3 for insect");
					choice2=Integer.parseInt(br.readLine());
					switch(choice2)
					{
					case 1:
						if(cages1.get(l).AvailableSpace()==false&&l==cages1Size-1){
							System.out.println("No space left");
							continue;
							}
						
						else if(cages1.get(l).AvailableSpace()==false&&l!=cages1Size-1)
						{
							System.out.println("NEW CAGE FOR COW ");
							l++;
							cages1.add(new NorthZone());
						}
			
						System.out.println("Enter the name of the animal");
						String name1=br.readLine();						
						System.out.println("Enter the id of the animal");
						int id1=Integer.parseInt(br.readLine());
						
						Cow cow=new Cow(name1,id1);						
						
						if(cages1.get(l).ShowAnimal().contains(cow)==false){
							cages1.get(l).AddAnimal(cow);
							System.out.println("COW ADDED");
						}
						else
						{
							System.out.println("ALREADY EXISTS");
						}
						break;
					case 2:
						if(cages2.get(m).AvailableSpace()==false&&m==cages2Size-1){
							System.out.println("No space left");continue;}
						else if(cages2.get(m).AvailableSpace()==false&&m!=cages2Size-1)
						{
							System.out.println("NEW CAGE FOR CROCODILE");
							m++;
							cages2.add(new SouthZone());
						}
						
						
							System.out.println("Enter the name of the animal");
							String name2=br.readLine();
							System.out.println("Enter the id of the animal");
							int id2=Integer.parseInt(br.readLine());
						
							Crocodile crocodile=new Crocodile(name2,id2);
						
							if(cages2.get(m).ShowAnimal().contains(crocodile)==false){
								cages2.get(m).AddAnimal(crocodile);		
								System.out.println("CROCODILE ADDED");
							}
							else
							{
								System.out.println("ALREADY EXISTS");
							}

							break;
					case 3:
						if(cages3.get(n).AvailableSpace()==false&&n==cages3Size-1){
							System.out.println("No space left");continue;}
						
						else if(cages3.get(n).AvailableSpace()==false&&n!=cages3Size-1)
						{
							System.out.println("NEW CAGE FOR ANTS");
							n++;
							cages3.add(new WestZone());
						}
						
							System.out.println("Enter the name of the animal");
							String name3=br.readLine();
							System.out.println("Enter the id of the animal");
							int id3=Integer.parseInt(br.readLine());
						
							Ant ant=new Ant(name3,id3);
						
							if(cages3.get(n).ShowAnimal().contains(ant)==false){
								cages3.get(n).AddAnimal(ant);
								System.out.println("ANT ADDED");
							}
							else
							{
								System.out.println("ALREADY EXISTS");
							}
				
							break;
					default:System.out.println("Invalid");
					}
					break;
				case 2:System.out.println("Enter 1 if you want to remove mammal,2 for reptile,3 for insect");
					int choice3=Integer.parseInt(br.readLine());
					switch(choice3)
					{
					case 1:					
					System.out.println("Enter the name of the animal");
					String name4=br.readLine();					
					System.out.println("Enter the id of the animal");
					int id4=Integer.parseInt(br.readLine());
					
					Cow cow=new Cow(name4,id4);		
					
					while(o==true){
					if(cages1.get(l).ShowAnimal().contains(cow)==true){
						cages1.get(l).RemoveAnimal(cow);
						System.out.println("COW REMOVED");
						o=false;
						break;
					}
					else if(l>0)
					{
						l--;
						continue;
					}
					else
					{
						System.out.println("no one exists");
						o=false;
						break;
					}
					}
					
					break;
				case 2:				
					System.out.println("Enter the name of the animal");
					String name5=br.readLine();
					System.out.println("Enter the id of the animal");
					int id5=Integer.parseInt(br.readLine());
					
					Crocodile crocodile=new Crocodile(name5,id5);
					
					while(op==true){
					if(cages2.get(m).ShowAnimal().contains(crocodile)==true){
						cages2.get(m).RemoveAnimal(crocodile);
						System.out.println("CROCODILE REMOVED");
						op=false;
						break;
					}
					else if(m>0)
					{
						m--;
						continue;
					}
					
					else
					{
						System.out.println("no one exists");
						op=false;
						break;
					}
					}
					
					break;
				case 3:			
					System.out.println("Enter the name of the animal");
					String name6=br.readLine();
					System.out.println("Enter the id of the animal");
					int id6=Integer.parseInt(br.readLine());
					
					Ant ant=new Ant(name6,id6);
					
					while(opq==true){
					if(cages3.get(n).ShowAnimal().contains(ant)==true){
						cages3.get(n).RemoveAnimal(ant);
						System.out.println("ANT REMOVED");
						opq=false;
						break;
					}
					else if(n>0)
					{
						n--;
						continue;
					}
					
					else
					{
						System.out.println("no one exists");
						opq=false;
						break;
					}
					}
					break;
				default:System.out.println("Invalid");
				}                          
					
					break;
				case 3:				
				System.out.println("ZONES INFORMATION");
				System.out.println("NORTH ZONE has park: "+cage1.HasPark());
				System.out.println("NORTH ZONE has canteen: "+cage1.HasCanteen());
				
				System.out.println("SOUTH ZONE has park: "+cage2.HasPark());
				System.out.println("SOUTH ZONE has canteen: "+cage2.HasCanteen());
				
				System.out.println("WEST ZONE has park: "+cage3.HasPark());
				System.out.println("WEST ZONE has canteen: "+cage3.HasCanteen());
				System.out.println("ANIMAL SOUND INFORMATION");
				System.out.println("COW has SOUND: "+cages1.get(0).ShowAnimal().get(0).GetSound());
				System.out.println("CROCODILE has SOUND: "+cages2.get(0).ShowAnimal().get(0).GetSound());
				System.out.println("ANT has SOUND: "+cages3.get(0).ShowAnimal().get(0).GetSound());
				
				
					break;
				case 4:
					break;
				default:System.out.println("Invalid choice");
			
			}
		}

	}


}