package littleblocks.tickhandlers;

import java.util.EnumSet;

import littleblocks.api.ILBCommonProxy;
import littleblocks.core.LBCore;
import littleblocks.core.LBInit;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraft.src.WorldServer;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler {
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		World world = DimensionManager.getWorld(0);
		if (world != null) {
			((ILBCommonProxy)LBInit.LBM.getProxy()).getLittleWorld(world, false).tick();
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "LittleBlocks Client Tick Handler";
	}
}