package slimevoid.littleblocks.tickhandlers;

import java.util.EnumSet;

import slimevoid.littleblocks.api.ILittleWorld;
import slimevoid.littleblocks.core.LBCore;
import slimevoid.littleblocks.core.LittleBlocks;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class LittleWorldServerTickHandler implements ITickHandler {

	public void doLittleWorldServerTick(Object... tickData) {
		WorldServer[] worlds = DimensionManager.getWorlds();
		if (worlds != null && worlds.length > 0) {
			for (World world : worlds) {
				if (world != null && !world.isRemote && world instanceof ILittleWorld) {
					//world.updateEntities();
					//world.tick();
				}
			}
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.SERVER))) {
			this.doLittleWorldServerTick(tickData);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return "LittleBlocks Tick Handler";
	}

}