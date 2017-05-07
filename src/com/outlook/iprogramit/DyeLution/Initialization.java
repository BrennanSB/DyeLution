package com.outlook.iprogramit.DyeLution;

import org.bukkit.plugin.Plugin;

public class Initialization {
	public static Plugin plugin = Main.plugin;
	public static void configMe() {
		// GLOBAL
		plugin.getConfig().addDefault("Global.EnableBonemeal", true);
		// CRAFTING
		plugin.getConfig().addDefault("Crafting.Enabled", true);
		plugin.getConfig().addDefault("Crafting.OutputAmount", 8);
		// CAULDRON
		plugin.getConfig().addDefault("Cauldron.Enabled", true);
		plugin.getConfig().addDefault("Cauldron.AllowWaterGrab", true);
		plugin.getConfig().addDefault("Cauldron.InputAmount", 4);
		plugin.getConfig().addDefault("Cauldron.OutputAmount", 4);

		plugin.getConfig().addDefault("Permission.UseCauldron", false);
		plugin.getConfig().addDefault("Permission.GrabWater", false);
		plugin.getConfig().addDefault("Permission.CraftDye", false);
		plugin.getConfig().addDefault("Permission.CauldronMessage", "&cYou don't have permission to dilute dyes.");
		plugin.getConfig().addDefault("Permission.WaterGrabMessage",
				"&cYou don't have permission to grab water from cauldrons.");
		plugin.getConfig().addDefault("Permission.CraftDyeMessage", "&cYou don't have permission to craft diluted dyes.");
		
		// SAVE
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();

		// VARIABLE ASSIGNMENT
		Main.Global_EnableBonemeal = plugin.getConfig().getBoolean("Global.EnableBonemeal");

		Main.Crafting_Enabled = plugin.getConfig().getBoolean("Crafting.Enabled");
		Main.Crafting_OutputAmount = plugin.getConfig().getInt("Crafting.OutputAmount");

		Main.Cauldron_Enabled = plugin.getConfig().getBoolean("Cauldron.Enabled");
		Main.Cauldron_InputAmount = plugin.getConfig().getInt("Cauldron.InputAmount");
		Main.Cauldron_OutputAmount = plugin.getConfig().getInt("Cauldron.OutputAmount");
		Main.Cauldron_AllowWaterGrab = plugin.getConfig().getBoolean("Cauldron.AllowWaterGrab");

		Main.Permission_UseCauldron = plugin.getConfig().getBoolean("Permission.UseCauldron");
		Main.Permission_GrabWater = plugin.getConfig().getBoolean("Permission.GrabWater");
		Main.Permission_CraftDye = plugin.getConfig().getBoolean("Permission.CraftDye");
		Main.Permission_CauldronMessage = plugin.getConfig().getString("Permission.CauldronMessage");
		Main.Permission_WaterGrabMessage = plugin.getConfig().getString("Permission.WaterGrabMessage");
		Main.Permission_CraftDyeMessage = plugin.getConfig().getString("Permission.CraftDyeMessage");
	}

	public static void craftMe() {
		plugin.getServer().resetRecipes();
		if (Main.Crafting_Enabled) {
			// Light Gray / Gray
			Recipes.AddStandardDye(8, 7);
			Recipes.AddStandardDye(0, 8);
			// Dandelion Yellow / Orange
			Recipes.AddStandardDye(14, 11);
			Recipes.AddStandardDye(1, 14);
			// Green
			Recipes.AddStandardDye(2, 10);
			// Light Blue / Cyan
			Recipes.AddStandardDye(6, 12);
			Recipes.AddStandardDye(4, 6);
			// Pink / Magenta
			Recipes.AddStandardDye(13, 9);
			Recipes.AddStandardDye(5, 13);
			// White
			if (Main.Global_EnableBonemeal) {
				Recipes.AddStandardDye(7, 15);
				Recipes.AddStandardDye(11, 15);
				Recipes.AddStandardDye(3, 15);
				Recipes.AddStandardDye(12, 15);
				Recipes.AddStandardDye(9, 15);
				Recipes.AddStandardDye(10, 15);
			}
		}
	}
}
