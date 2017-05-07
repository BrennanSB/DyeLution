package com.outlook.iprogramit.DyeLution;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CauldronInteraction {
	@SuppressWarnings("deprecation")
	public static void grabWater(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		Block clickedBlock = event.getClickedBlock();
		Inventory playerInv = event.getPlayer().getInventory();
		if (item.getAmount() == 1) {
			playerInv.remove(item);
		} else {
			item.setAmount(item.getAmount() - 1);
		}
		playerInv.addItem(new ItemStack(Material.WATER_BUCKET, 1));
		if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			clickedBlock.setData((byte) 0);
		}
		event.getPlayer().updateInventory();
	}

	@SuppressWarnings("deprecation")
	public static void diluteDye(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		Block clickedBlock = event.getClickedBlock();
		if (clickedBlock.getData() > (short) 0 && item.getAmount() >= Main.Cauldron_InputAmount) {
			byte outData = 0;
			boolean remove = true;
			switch (item.getData().getData()) {
			case (byte) 0:
				outData = (byte) 8;
				break;
			case (byte) 1:
				outData = (byte) 14;
				break;
			case (byte) 2:
				outData = (byte) 10;
				break;
			case (byte) 3:
				outData = (byte) 15;
				break;
			case (byte) 4:
				outData = (byte) 6;
				break;
			case (byte) 5:
				outData = (byte) 13;
				break;
			case (byte) 6:
				outData = (byte) 12;
				break;
			case (byte) 7:
				outData = (byte) 15;
				break;
			case (byte) 8:
				outData = (byte) 7;
				break;
			case (byte) 9:
				outData = (byte) 15;
				break;
			case (byte) 10:
				outData = (byte) 15;
				break;
			case (byte) 11:
				outData = (byte) 15;
				break;
			case (byte) 12:
				outData = (byte) 15;
				break;
			case (byte) 13:
				outData = (byte) 9;
				break;
			case (byte) 14:
				outData = (byte) 11;
				break;
			default:
				outData = 15;
				remove = false;
			}
			if (outData == 15 && Main.Global_EnableBonemeal != true) {
				return;
			}
			if (remove) {
				Inventory playerInv = event.getPlayer().getInventory();
				ItemStack outStack = new ItemStack(Material.INK_SACK, Main.Cauldron_OutputAmount, (short) outData);
				playerInv.addItem(outStack);
				event.getPlayer().updateInventory();
				if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
					clickedBlock.setData((byte) (clickedBlock.getData() - 1));
				}
				if (item.getAmount() == Main.Cauldron_InputAmount) {
					playerInv.remove(item);
				} else {
					item.setAmount(item.getAmount() - Main.Cauldron_InputAmount);
				}
			}
		}
	}
}
