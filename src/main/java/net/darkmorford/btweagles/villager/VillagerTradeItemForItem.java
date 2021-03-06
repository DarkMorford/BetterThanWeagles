package net.darkmorford.btweagles.villager;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

public class VillagerTradeItemForItem implements EntityVillager.ITradeList
{
	private ItemStack buyingItemStack;
	private EntityVillager.PriceInfo buyingPriceInfo;
	private ItemStack sellingItemStack;
	private EntityVillager.PriceInfo sellingPriceInfo;

	public VillagerTradeItemForItem(ItemStack buyingItem, EntityVillager.PriceInfo buyingPrice, ItemStack sellingItem, EntityVillager.PriceInfo sellingPrice)
	{
		this.buyingItemStack = buyingItem;
		this.buyingPriceInfo = buyingPrice;
		this.sellingItemStack = sellingItem;
		this.sellingPriceInfo = sellingPrice;
	}

	@Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
	{
		int buyingPrice = this.buyingPriceInfo.getPrice(random);
		int sellingPrice = this.sellingPriceInfo.getPrice(random);

		ItemStack buying = buyingItemStack.copy();
		buying.setCount(buyingPrice);

		ItemStack selling = sellingItemStack.copy();
		selling.setCount(sellingPrice);

		MerchantRecipe tradeRecipe = new MerchantRecipe(buying, selling);
		recipeList.add(tradeRecipe);
	}
}
