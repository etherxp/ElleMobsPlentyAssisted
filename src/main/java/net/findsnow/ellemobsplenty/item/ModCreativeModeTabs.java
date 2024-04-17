package net.findsnow.ellemobsplenty.item;

import net.findsnow.ellemobsplenty.ElleMobsPlenty;
import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
          DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElleMobsPlenty.MOD_ID);

  public static final RegistryObject<CreativeModeTab> ELLE_MOBS_PLENTY_TAB = CREATIVE_MODE_TABS.register("elle_mobs_plenty",
          () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NEPHRITE.get()))
                  .title(Component.translatable("creativetab.ellemobsplenty_tab")).displayItems((displayParameters, output) -> {
                    output.accept(ModItems.NEPHRITE.get());
                    output.accept(ModItems.RAW_NEPHRITE.get());

                    output.accept(ModBlocks.NEPHRITE_BLOCK.get());
                    output.accept(ModBlocks.RAW_NEPHRITE_BLOCK.get());
                    output.accept(ModBlocks.NEPHRITE_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_NEPHRITE_ORE.get());
                    output.accept(ModBlocks.ANCIENT_FURNACE_BLOCK.get());

                    output.accept(ModItems.RAW_CRAB_MEAT.get());
                    output.accept(ModItems.COOKED_CRAB_MEAT.get());



                  }).build());

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
