package com.playapp.util;

public class Queries {
	public static final String CREATEQUERY=
			"create table if not exists game(name varchar(20),place varchar(20),gameId integer primary key auto_increment,level int,price double)";
	public static final String INSERTQUERY=
			"insert into game(name,place,level,price) values(?,?,?,?);";
	public static final String UPDATEQUERY=
			"update game set price=? where gameId=?";
	public static final String DELETEQUERY=
			"delete from game where gameId=?";
	public static final String QUERYALL="select * from game";
	public static final String QUERYBYID=
			"select * from game where gameId=?";
	public static final String QUERYBYPLACE=
			"select * from game where place=?";
	public static final String QUERYBYPLACEANDNAME=
			"select * from game where place=? and name=?";
	public static final String QUERYBYPLACEANDPRICE=
			"select * from game where place=? and price=?";
	public static final String QUERYBYNAME=
			"select * from game where name=?";
	public static final String QUERYBYPRICE=
			"select * from game where price=?";
	public static final String BOOKINGTABLE=
			"create table if not exists booking(name varchar(20),place varchar(20),gameId int primary key ,level int,price double)";
	public static final String BOOKINGCOURT=
			"insert into booking(name,place,gameId,level,price) values(?,?,?,?,?);";
	public static final String COURTS=
			"select * from booking";
	
	

}
