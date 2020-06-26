package de.robasse.timeismoney;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import me.onebone.economyapi.EconomyAPI;

public class Payout {

    private final int interval;
    private final int amount;
    private final int itemId;
    private final boolean repeat;
    private final String itemName;
    private final String permission;
    private final PayoutType payoutType;
    private final String messageReceive;
    private final String messageAfk;

    public Payout(int interval, int amount, int itemId, boolean repeat, String itemName, String permission, PayoutType payoutType, String messageReceive, String messageAfk) {
        this.interval = interval;
        this.amount = amount;
        this.itemId = itemId;
        this.repeat = repeat;
        this.itemName = itemName;
        this.permission = permission;
        this.payoutType = payoutType;
        this.messageReceive = messageReceive;
        this.messageAfk = messageAfk;
    }

    public Payout() {
        this.interval = 600;
        this.amount = 500;
        this.itemId = 264;
        this.repeat = true;
        this.itemName = "§cYOUR NEW ITEM";
        this.permission = "tim.receive.starter";
        this.payoutType = PayoutType.BOTH;
        this.messageReceive = "§a§lWOW %player%! §7You just received %amount% DOLLAR for being online another 10 minutes!";
        this.messageAfk = "§cYou just missed %amount% DOLLAR because you were afk!";
    }

    public void pay(Player player) {
        Item item = new Item(itemId);
        if (payoutType.equals(PayoutType.ITEM) || payoutType.equals(PayoutType.BOTH))
            player.getInventory().addItem(item.setCustomName(itemName));
        if (payoutType.equals(PayoutType.MONEY) || payoutType.equals(PayoutType.BOTH))
            EconomyAPI.getInstance().addMoney(player, amount);
    }

    public int getInterval() {
        return interval;
    }

    public int getAmount() {
        return amount;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPermission() {
        return permission;
    }

    public PayoutType getPayoutType() {
        return payoutType;
    }

    public String getMessageReceive(Player player) {
        String s = messageReceive.replaceAll("%player%", player.getName());
        return s.replace("%amount%", String.valueOf(amount));
    }

    public boolean isRepeat() {
        return repeat;
    }

    public String getMessageAfk(Player player) {
        String s = messageAfk.replaceAll("%player%", player.getName());
        return s.replace("%amount%", String.valueOf(amount));
    }
}
