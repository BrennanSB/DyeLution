package com.outlook.iprogramit.DyeLution;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Listeners implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerUse(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		Block clickedBlock = event.getClickedBlock();
		if (item != null && item.getType().equals(Material.INK_SACK)) {
			if (clickedBlock != null && clickedBlock.getType().equals(Material.CAULDRON)
					&& event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (!Main.Permission_UseCauldron) {
					CauldronInteraction.diluteDye(event);
				} else {
					if (event.getPlayer().hasPermission("dyelution.cauldrondilute")) {
						CauldronInteraction.diluteDye(event);
					} else {
						event.getPlayer().sendMessage(
								ChatColor.translateAlternateColorCodes('&', Main.Permission_CauldronMessage));
					}
				}
			}
		} else if (item != null && item.getType().equals(Material.BUCKET)) {
			if (Main.Cauldron_AllowWaterGrab && clickedBlock.getData() == (short) 3) {
				if (!Main.Permission_GrabWater) {
					CauldronInteraction.grabWater(event);
				} else {
					if (event.getPlayer().hasPermission("dyelution.grabwater")) {
						CauldronInteraction.grabWater(event);
					} else {
						event.getPlayer().sendMessage(
								ChatColor.translateAlternateColorCodes('&', Main.Permission_WaterGrabMessage));
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void preCraft(PrepareItemCraftEvent event) {
		boolean equal = false;
		for (ShapedRecipe r : Recipes.DyeRecipes) {
			if (RecipeUtil.areEqual(event.getRecipe(), r)) {
				equal = true;
			}
		}
		if (equal) {
			HumanEntity human = event.getView().getPlayer();
			if (Main.Permission_CraftDye && !human.hasPermission("dyelution.craftdye")) {
				event.getInventory().setResult(null);
				if (human instanceof Player) {
					Player player = (Player) human;
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.Permission_CraftDyeMessage));
				}
			}
		}
	}
}
