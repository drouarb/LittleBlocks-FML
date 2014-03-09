package com.slimevoid.littleblocks.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.slimevoid.library.util.helpers.ReflectionHelper;
import com.slimevoid.littleblocks.blocks.BlockLBDoor;
import com.slimevoid.littleblocks.blocks.BlockLBPistonBase;
import com.slimevoid.littleblocks.blocks.BlockLittleChunk;
import com.slimevoid.littleblocks.core.lib.BlockLib;
import com.slimevoid.littleblocks.core.lib.BlockUtil;
import com.slimevoid.littleblocks.core.lib.ConfigurationLib;
import com.slimevoid.littleblocks.core.lib.ItemLib;
import com.slimevoid.littleblocks.core.lib.LocalizationLib;
import com.slimevoid.littleblocks.items.EntityItemLittleBlocksCollection;
import com.slimevoid.littleblocks.items.ItemLittleBlocksWand;
import com.slimevoid.littleblocks.tileentities.TileEntityLittleChunk;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class LBCore {

    public static void registerItems() {
        ConfigurationLib.littleBlocksWand = new ItemLittleBlocksWand(ConfigurationLib.littleBlocksWandID).setUnlocalizedName(ItemLib.WAND);
        GameRegistry.registerItem(ConfigurationLib.littleBlocksWand, ItemLib.WAND);
    }

    public static void registerNames() {
        LocalizationLib.registerLanguages();
    }

    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(ConfigurationLib.littleBlocksWand),
                               new Object[] {
                                       "LIL",
                                       "BGB",
                                       "BWB",
                                       Character.valueOf('L'),
                                       new ItemStack(Items.dye, 9, 4),
                                       Character.valueOf('I'),
                                       Items.iron_ingot,
                                       Character.valueOf('B'),
                                       new ItemStack(Items.dye, 1, 0),
                                       Character.valueOf('G'),
                                       Items.gold_nugget,
                                       Character.valueOf('W'),
                                       Blocks.wool });
    }

    public static void registerBlocks() {
        ConfigurationLib.littleChunk = new BlockLittleChunk(ConfigurationLib.littleChunkID, TileEntityLittleChunk.class, Material.wood, 2F, true).setBlockName(BlockLib.LITTLECHUNK);
        
        GameRegistry.registerBlock(ConfigurationLib.littleChunk,
                                   BlockLib.LITTLECHUNK);
        EntityRegistry.registerModEntity(EntityItemLittleBlocksCollection.class,
                                         "LittleBlocksCollection",
                                         ConfigurationLib.littleBlocksCollectionID,
                                         LittleBlocks.instance,
                                         256,
                                         1,
                                         false);
        GameRegistry.registerTileEntity(TileEntityLittleChunk.class,
                                        BlockLib.LITTLEBLOCKS);
        BlockUtil.registerPlacementInfo();
    }

    public static void registerPistonOverride() {
//        BlockRemover.removeVanillaBlock(Block.pistonBase,
//                                        false);
//        BlockRemover.removeVanillaBlock(Block.pistonStickyBase,
//                                        false);
//        Block newPistonSticky = new BlockLBPistonBase(Block.pistonStickyBase.blockID, true).setUnlocalizedName("pistonStickyBase");
//        Block newPistonBase = new BlockLBPistonBase(Block.pistonBase.blockID, false).setUnlocalizedName("pistonBase");
//        ReflectionHelper.getInstance(Block.class).setFinalStaticFieldAtIndex(ConfigurationLib.pistonStickyIndex,
//                                                                             newPistonSticky);
//        ReflectionHelper.getInstance(Block.class).setFinalStaticFieldAtIndex(ConfigurationLib.pistonBaseIndex,
//                                                                             newPistonBase);
    }

    public static void registerDoorOverride() {
//        BlockRemover.removeVanillaBlock(Block.doorWood,
//                                        false);
//        BlockRemover.removeVanillaBlock(Block.doorIron,
//                                        false);
//        Block newDoorWood = new BlockLBDoor(64, Material.wood).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("doorWood").setTextureName("door_wood");
//        Block newDoorIron = new BlockLBDoor(71, Material.iron).setHardness(5.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("doorIron").setTextureName("door_iron");
//        ReflectionHelper.getInstance(Block.class).setFinalStaticFieldAtIndex(ConfigurationLib.doorWoodIndex,
//                                                                             newDoorWood);
//        ReflectionHelper.getInstance(Block.class).setFinalStaticFieldAtIndex(ConfigurationLib.doorIronIndex,
//                                                                             newDoorIron);
    }
}