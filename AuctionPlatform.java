package com.am.streams;

import java.util.HashMap;
import java.util.Map;

public class AuctionPlatform
{
	static Integer itemID = 1;
	static Integer userID = 1;
	
	Map<Integer , AuctionItem > auctionItems = new HashMap<>();
	
	Map<Integer , AuctionItem > userBids = new HashMap<>();
	
	public void addItem(String itemID, String itemName, String description)
	{
		
	}
}
