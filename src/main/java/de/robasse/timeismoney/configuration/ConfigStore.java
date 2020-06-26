package de.robasse.timeismoney.configuration;

import de.robasse.timeismoney.Payout;

import java.util.Arrays;
import java.util.List;

public class ConfigStore {

    private final boolean afkPayout;
    private final List<Payout> payouts;
    private final String prefix;

    public ConfigStore(boolean afkPayout, List<Payout> payouts, String prefix, String messageAfk) {
        this.afkPayout = afkPayout;
        this.payouts = payouts;
        this.prefix = prefix;
    }

    public ConfigStore() {
        this.afkPayout = false;
        this.payouts = Arrays.asList(new Payout(), new Payout());
        this.prefix = "§e§lTIM §7> ";
    }

    public boolean isAfkPayout() {
        return afkPayout;
    }

    public List<Payout> getPayouts() {
        return payouts;
    }

    public String getPrefix() {
        return prefix;
    }
}
