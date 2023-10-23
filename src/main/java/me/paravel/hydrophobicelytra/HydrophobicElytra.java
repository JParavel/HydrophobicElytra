package me.paravel.hydrophobicelytra;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.entity.player.PlayerEntity;

public class HydrophobicElytra implements ModInitializer {

	@Override
	public void onInitialize() {

		EntityElytraEvents.CUSTOM.register((entity, tickElytra) -> {

			if (entity instanceof PlayerEntity playerEntity){
				if (playerEntity.isInLava() || playerEntity.isSubmergedInWater()){
					playerEntity.stopFallFlying();
				}
			}

			return true;
		});

	}
}