package de.robasse.timeismoney.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import de.robasse.timeismoney.TimeIsMoney;
import de.robasse.timeismoney.task.SyncPaymentTask;

public class PlayerJoinListener implements Listener {

    private final TimeIsMoney plugin;

    public PlayerJoinListener(TimeIsMoney plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getConfigStore().getPayouts().forEach(payout -> {
            if (!event.getPlayer().hasPermission(payout.getPermission())) return;
            plugin.getServer().getScheduler().scheduleDelayedTask(new SyncPaymentTask(plugin, event.getPlayer(), payout,
                    event.getPlayer().getLocation()), payout.getInterval() * 20);
        });
    }
}
