package com.outlook.iprogramit.DyeLution;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DyeMain extends JavaPlugin implements Listener {
	public static Plugin plugin;

	public static boolean Global_EnableBonemeal = true;

	public static boolean Crafting_Enabled = true;
	public static int Crafting_OutputAmount = 8;

	public static boolean Cauldron_Enabled = true;
	public static boolean Cauldron_AllowWaterGrab = true;
	public static int Cauldron_InputAmount = 4;
	public static int Cauldron_OutputAmount = 4;

	public static boolean Permission_UseCauldron = false;
	public static boolean Permission_GrabWater = false;
	public static boolean Permission_CraftDye = false;
	public static String Permission_CauldronMessage = "&cYou don't have permission to dilute dyes.";
	public static String Permission_WaterGrabMessage = "&cYou don't have permission to grab water from cauldrons.";
	public static String Permission_CraftDyeMessage = "&cYou don't have permission to craft diluted dyes.";

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		plugin = this;
		Initialization.configMe();
		Initialization.craftMe();
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String cs = command.getName();
		if (cs.equalsIgnoreCase("dyelution")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {
					plugin.reloadConfig();
					Initialization.configMe();
					Initialization.craftMe();
					sender.sendMessage(ChatColor.GREEN + "DyeLution's configuration should have been reloaded!");
					return true;
				}
			} else if (args.length == 0) {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "DyeLution version " + this.getDescription().getVersion());
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Coded by iProgramIt. DO NOT DECOMPILE.");
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Thanks for using this plugin! :)");
				return true;
			}
		}
		return false;
	}
}
