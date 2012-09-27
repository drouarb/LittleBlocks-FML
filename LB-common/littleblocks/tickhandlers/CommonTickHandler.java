package littleblocks.tickhandlers;

import java.util.EnumSet;

import littleblocks.core.LBCore;
import littleblocks.tileentities.TileEntityLittleBlocks;
import net.minecraft.src.World;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class CommonTickHandler implements ITickHandler {
	private int ticked = 0;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.SERVER)) || type
				.equals(EnumSet.of(TickType.CLIENT))) {
			if (ticked >= 40) {
				World[] worlds = DimensionManager.getWorlds();
				for (World world : worlds) {
					LBCore.getLittleWorld(world, false).tickUpdates(false);
				}
				ticked = 0;
			}
			ticked++;
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.SERVER, TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "LittleBlocks Tick Handler";
	}

}
