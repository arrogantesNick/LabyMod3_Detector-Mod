package de.nick.detector;

import de.nick.detector.events.RenderEvent;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ServerData;

import java.util.List;


public final class DetectorMOD extends LabyModAddon{
	public static String SERVER_IP;
	private boolean SETTINGS_TNT = true;
	private boolean SETTINGS_EP = true;
	private boolean SETTINGS_RP = true;

	@Override
	protected void fillSettings(final List<SettingsElement> subSettings) {
		final BooleanElement booleanElement = new BooleanElement("EP-Detector", new ControlElement.IconData(Material.ENDER_PEARL), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean aBoolean) {
				DetectorMOD.this.SETTINGS_EP = aBoolean;
				DetectorMOD.this.getConfig().addProperty("SETTINGS_EP", aBoolean);
				DetectorMOD.this.saveConfig();
			}
		}, this.SETTINGS_EP);
		subSettings.add(booleanElement);

		final BooleanElement booleanElement2 = new BooleanElement("TNT-Detector", new ControlElement.IconData(Material.TNT), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean aBoolean) {
				DetectorMOD.this.SETTINGS_TNT = aBoolean;
				DetectorMOD.this.getConfig().addProperty("SETTINGS_TNT", aBoolean);
				DetectorMOD.this.saveConfig();
			}
		}, this.SETTINGS_TNT);
		subSettings.add(booleanElement2);

		final BooleanElement booleanElement3 = new BooleanElement("RP-Detector", new ControlElement.IconData(Material.BLAZE_ROD), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean aBoolean) {
				DetectorMOD.this.SETTINGS_RP = aBoolean;
				DetectorMOD.this.getConfig().addProperty("SETTINGS_RP", aBoolean);
				DetectorMOD.this.saveConfig();
			}
		}, this.SETTINGS_RP);
		subSettings.add(booleanElement3);
		
	}

	@Override
	public void loadConfig() {
		this.SETTINGS_EP = !getConfig().has("SETTINGS_EP") || this.getConfig().get("SETTINGS_EP").getAsBoolean();
		this.SETTINGS_TNT = !getConfig().has("SETTINGS_TNT") || this.getConfig().get("SETTINGS_TNT").getAsBoolean();
		this.SETTINGS_RP = !getConfig().has("SETTINGS_RP") || this.getConfig().get("SETTINGS_RP").getAsBoolean();
		
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		System.out.println("[Detector] started");
		this.getApi().registerForgeListener(new RenderEvent());
		this.getApi().getEventManager().registerOnJoin(new Consumer<ServerData>() {
			@Override
			public void accept(ServerData serverData) {
				SERVER_IP = serverData.getIp();
			}
		});
	}
}
