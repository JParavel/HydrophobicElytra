package me.paravel.hydrophobicelytra;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.entity.player.PlayerEntity;

public class HydrophobicElytra implements ModInitializer {

	@Override
	public void onInitialize() {

		EntityElytraEvents.ALLOW.register((entity) -> {

			if (entity instanceof PlayerEntity playerEntity && playerEntity.isFallFlying()){

				if (playerEntity.isSubmergedInWater() || playerEntity.isInLava()){
					playerEntity.stopFallFlying();
					return false;
				}

			}

			return true;
		});

	}
}