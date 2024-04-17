package net.findsnow.ellemobsplenty;

import com.mojang.logging.LogUtils;
import net.findsnow.ellemobsplenty.block.ModBlocks;
import net.findsnow.ellemobsplenty.datagen.ModBlockStateProvider;
import net.findsnow.ellemobsplenty.entity.ModBlockEntities;
import net.findsnow.ellemobsplenty.item.ModCreativeModeTabs;
import net.findsnow.ellemobsplenty.item.ModItems;
import net.findsnow.ellemobsplenty.recipe.ModRecipes;
import net.findsnow.ellemobsplenty.screen.AncientFurnaceScreen;
import net.findsnow.ellemobsplenty.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ElleMobsPlenty.MOD_ID)
public class ElleMobsPlenty {
    public static final String MOD_ID = "ellemobsplenty";
    private static final Logger LOGGER = LogUtils.getLogger();
    public ElleMobsPlenty() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.NEPHRITE);
            event.accept(ModItems.RAW_NEPHRITE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.NEPHRITE_BLOCK);
            event.accept(ModBlocks.RAW_NEPHRITE_BLOCK);
            event.accept(ModBlocks.NEPHRITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
            event.accept(ModBlocks.ANCIENT_FURNACE_BLOCK);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                MenuScreens.register(ModMenuTypes.ANCIENT_FURNACE_MENU.get(), AncientFurnaceScreen::new);
            });
        }
    }
}
