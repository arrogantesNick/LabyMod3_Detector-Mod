package de.nick.detector.events;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import de.nick.detector.DetectorMOD;
import de.nick.detector.util.MessageMethod;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemNameTag;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * copyright by Nick 05.11.2017
 */
public class RenderEvent {
    private ArrayList<EntityPlayer> epearl = new ArrayList<EntityPlayer>();
    private ArrayList<EntityPlayer> rp = new ArrayList<EntityPlayer>();
    private ArrayList<Entity> epearl_event = new ArrayList<Entity>();
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent e) {
        if(DetectorMOD.SERVER_IP == null) {//DetectorMOD.SERVER_IP.contains("gommehd.net")
            for(EntityPlayer entityPlayer : Minecraft.getMinecraft().theWorld.playerEntities) {
                //if(entityPlayer != Minecraft.getMinecraft().thePlayer) {
                if(entityPlayer.getHeldItem() != null) {
                    if(entityPlayer.getHeldItem().getItem() == Item.getItemById(368)) {
                        if(entityPlayer.getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) {
                            if(!epearl.contains(entityPlayer)) {
                                LabyMod.getInstance().displayMessageInChat("§8§l[§6§lEP§8§l] §c§lDer Spieler §6§l" + entityPlayer.getName() + " §c§lhat eine EP");
                                epearl.add(entityPlayer);
                            }
                        }else{
                            if(!epearl.contains(entityPlayer)) {
                                LabyMod.getInstance().displayMessageInChat(MessageMethod.sendMessage("EP", "Du hast deine EP gezeigt!"));
                                epearl.add(entityPlayer);
                            }

                        }

                    }else if(entityPlayer.getHeldItem().getItem() == Item.getItemById(369)){
                        if(entityPlayer.getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) {
                            if(!rp.contains(entityPlayer)) {
                                LabyMod.getInstance().displayMessageInChat(MessageMethod.sendMessage("RP", "Der Spieler §6§l" + entityPlayer.getName() + " §c§lhat eine RP!"));
                                rp.add(entityPlayer);
                            }
                        }


                    }else if(entityPlayer.getHeldItem().getItem() == Item.getItemById(46)) {
                        if(entityPlayer.getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) {
                            if(!rp.contains(entityPlayer)) {
                                LabyMod.getInstance().displayMessageInChat(MessageMethod.sendMessage("TNT", "Der Spieler §6§l" + entityPlayer.getName() + " §c§lhat TNT!"));
                                rp.add(entityPlayer);
                            }
                        }
                    }else{
                        if(epearl.contains(entityPlayer)) {
                            epearl.remove(entityPlayer);
                        }
                        if(rp.contains(entityPlayer)) {
                            rp.remove(entityPlayer);
                        }
                    }
                }else{
                    if(epearl.contains(entityPlayer)) {
                        epearl.remove(entityPlayer);
                    }
                    if(rp.contains(entityPlayer)) {
                        rp.remove(entityPlayer);
                    }
                }

                //}
            }
            for(Entity entityPlayer : Minecraft.getMinecraft().theWorld.loadedEntityList) {
                if(entityPlayer.getName() != Minecraft.getMinecraft().thePlayer.getDisplayNameString()) {
                    if(entityPlayer instanceof EntityEnderPearl) {
                        if(!epearl_event.contains(entityPlayer)) {
                            LabyMod.getInstance().displayMessageInChat("§8§l[§6§lEP§8§l] §c§lEine §6§lEP §c§lwurde geworfen!");
                            epearl_event.add(entityPlayer);
                        }

                    }else{
                        epearl_event.remove(entityPlayer);
                    }

                }
            }
        }


    }


}
