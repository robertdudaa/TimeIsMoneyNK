package de.robasse.timeismoney;

public class Payout {

    private final int interval;
    private final int amount;
    private final int itemId;
    private final String itemName;
    private final String permission;
    private final PayoutType payoutType;
    private final String messageReceive;

    public Payout(int interval, int amount, int itemId, String itemName, String permission, PayoutType payoutType, String messageReceive) {
        this.interval = interval;
        this.amount = amount;
        this.itemId = itemId;
        this.itemName = itemName;
        this.permission = permission;
        this.payoutType = payoutType;
        this.messageReceive = messageReceive;
    }

    public Payout() {
        this.interval = 120;
        this.amount = 500;
        this.itemId = 264;
        this.itemName = "§cYOUR NEW ITEM";
        this.permission = "tim.receive.starter";
        this.payoutType = PayoutType.BOTH;
        this.messageReceive = "§a§lWOW %player%! §7You just received %amount% DOLLAR!";
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

    public String getMessageReceive() {
        return messageReceive;
    }

    @Override
    public String toString() {
        return "Payout{" +
                "interval=" + interval +
                ", amount=" + amount +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", permission='" + permission + '\'' +
                ", payoutType=" + payoutType +
                ", messageReceive='" + messageReceive + '\'' +
                '}';
    }
}
