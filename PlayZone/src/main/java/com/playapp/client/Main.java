package com.playapp.client;

import java.util.List;
import java.util.Scanner;

import com.playapp.model.Booking;
import com.playapp.model.Game;
import com.playapp.service.IPlayService;
import com.playapp.service.PlayServiceImpl;

public class Main {

	public static void main(String[] args) {
		//IPlayService playService=new PlayServiceImpl();
//		Game game=new Game("Table Tennis","coimbatore",3,600);
//		playService.addGame(game);
//		//Game game=new Game("volleyball","bellandur",4,200);
        
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the user type -admin or client");
		String user=scanner.nextLine();
		IPlayService playService=new PlayServiceImpl();
		user=user.toLowerCase();
		if(user.equals("admin")) {
			boolean flag=true;
			while(flag) {
			System.out.println("Choose the options\n 1.Add Game\n "
					+ "2.Delete Game\n 3.Update game \n 4.Exit");
			int temp=scanner.nextInt();
			switch(temp) {
			case 1: 
				System.out.println("Enter Game Details");
				System.out.println("Name: ");
				String name = scanner.next();
				System.out.println("Place: ");
				String place = scanner.next();
				System.out.println("Category: ");
				int level = scanner.nextInt();
				System.out.println("Price: ");
				double price = scanner.nextDouble();
				scanner.nextLine();
				Game game=new Game(name,place,level,price);
			playService.addGame(game);
			System.out.println("Game added successfully");
			break;
			case 2:
				System.out.println("Enter the id ");
				int id=scanner.nextInt();
				playService.deleteGame(id);
				break;
				
			case 3:
				System.out.println("Enter the id ");
				int bookid=scanner.nextInt();
				System.out.println("Enter the price ");
				int price1=scanner.nextInt();
				playService.updateGame(bookid,price1 );
				break;
				
			case 4:
				System.out.println("Thank you");
				flag=false;
				break;
				
			default:System.out.println("Enter a valid option");
			
			}
			}
		}
		else if(user.equals("client")) {
			System.out.println("Welcome to Playzone booking App");
			boolean flag=true;
			List<Game>games;
			while(flag) {
				System.out.println("choose the option\n 1.Find by place \n 2.Find by gameName\n3.Find by place and price\n4.Find by Game Name\n 5.Find by Price\n 6.Find All\n7.Book a court\n 8.Courts Booked\n 9.Exit");
				int temp=scanner.nextInt();
				switch(temp) {
				case 1:
					System.out.println("Enter the place name");
					String place=scanner.next();
					 System.out.println();
					 System.out.println("Fileterd by place");
					 games=playService.getByPlace(place);
					 games.forEach(System.out::println);
					 break;
				case 2:
					System.out.println("Enter the gameName");
					String name=scanner.next();
					System.out.println("Enter the place");
					String place1=scanner.next();
					System.out.println("Filtered by name");
					games=playService.getByPlaceAndName(place1, name);
					games.forEach(System.out::println);
					break;
				case 3:
					System.out.println("Enter the place");
					 place=scanner.next();
					 System.out.println("Enter the Price");
					 double price=scanner.nextDouble();
					 System.out.println("Filtered by place and price");
					 games=playService.getByPlaceAndPrice(place, price);
						games.forEach(System.out::println);
				case 4:
					System.out.println("Enter the name");
					name=scanner.next();
					System.out.println("Fileterd by name");
					 games=playService.getByName(name);
						games.forEach(System.out::println);
					break;
				case 5:
					System.out.println("Enter the price");
					price=scanner.nextDouble();
					System.out.println("Filterd by price");
					games=playService.getByPrice(price);
					games.forEach(System.out::println);
				    break;
				case 6:
					System.out.println("Get all the games");
					games=playService.getAllGames();
					games.forEach(System.out::println);
				    break;
				case 7:
					System.out.println("Enter the details");
					System.out.println("Name: ");
				    name = scanner.next();
					System.out.println("Place: ");
					place = scanner.next();
					System.out.println("Enter id");
					int id=scanner.nextInt();
					System.out.println("Category: ");
					int level = scanner.nextInt();
					System.out.println("Price: ");
					price = scanner.nextDouble();
					scanner.nextLine();
					Booking game=new Booking(name,place,id,level,price);
				playService.addCourt(game);
				System.out.println("booked successfully");
				break;
				case 8:
					System.out.println("Get all the  booked games ");
					List<Booking>booking=playService.getBookingDetails();
					booking.forEach(System.out::println);
					break;
				case 9:
					flag=false;
					System.out.println("Thank you!\n Have a good day");
					break;
					
				}
			}
			
		}
		else {
			System.out.println("Enter a valid user");
		}
	}

}
