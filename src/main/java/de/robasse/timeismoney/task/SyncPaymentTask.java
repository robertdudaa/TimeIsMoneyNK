package de.robasse.timeismoney.task;

import cn.nukkit.Player;
import cn.nukkit.level.Location;
import cn.nukkit.scheduler.Task;
import de.robasse.timeismoney.Payout;
import de.robasse.timeismoney.TimeIsMoney;

public class SyncPaymentTask extends Task {

    private final TimeIsMoney plugin;
    private final Player player;
    private final Payout payout;
    private final Location location;

    public SyncPaymentTask(TimeIsMoney plugin, Player player, Payout payout, Location location) {
        this.plugin = plugin;
        this.player = player;
        this.payout = payout;
        this.location = location;
    }

    @Override
    public void onRun(int i) {
        if (player.isOnline()) {
            if (player.getLocation().equals(location)) {
                player.sendMessage(plugin.getConfigStore().getPrefix() + payout.getMessageAfk(player));
            } else {
                player.sendMessage(plugin.getConfigStore().getPrefix() + payout.getMessageReceive(player));
                payout.pay(player);
            }
            if (payout.isRepeat())
                plugin.getServer().getScheduler().scheduleDelayedTask(new SyncPaymentTask(plugin, player, payout, location), payout.getInterval()*20);
        }
    }
}
