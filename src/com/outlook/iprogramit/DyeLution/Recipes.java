package com.outlook.iprogramit.DyeLution;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {

	public static List<ShapedRecipe> DyeRecipes = new ArrayList<ShapedRecipe>();
	@SuppressWarnings("deprecation")
	public static void AddStandardDye(int in, int out) {
		ItemStack dye = new ItemStack(Material.INK_SACK, Main.Crafting_OutputAmount, (short) out);
		ItemStack bucket = new ItemStack(Material.BUCKET, 1);

		ShapedRecipe Dye = new ShapedRecipe(dye);
		ShapedRecipe Bucket = new ShapedRecipe(bucket);

		Dye.shape("***", "*!*", "***");
		Dye.setIngredient('*', Material.INK_SACK, in);
		Dye.setIngredient('!', Material.WATER_BUCKET);

		Bucket.shape("***", "*!*", "***");
		Bucket.setIngredient('*', Material.INK_SACK, in);
		Bucket.setIngredient('!', Material.WATER_BUCKET);

		DyeRecipes.add(Dye);
		Main.plugin.getServer().addRecipe(Dye);
		Main.plugin.getServer().addRecipe(Bucket);
	}
}
