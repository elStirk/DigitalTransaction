package net.rpgmyth.digitaltransactions.events;

import net.essentialsx.api.v2.events.TransactionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.math.BigDecimal;


public class TransactionTax implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onTransaction(TransactionEvent event) {
        double[][] taxBrackets = {
            {12450.0, 19},
            {20199.0, 24},
            {35199.0, 30},
            {59999.0, 37},
            {299999.0, 45},
            {Double.MAX_VALUE, 47}
        };

        double amount = event.getAmount().doubleValue();
        for (double[] bracket: taxBrackets) {
            if (amount <= bracket[0]) {
                double tax = amount * bracket[1] / 100;
                event.getTarget().takeMoney(BigDecimal.valueOf(tax));
                break;
            }
        }
    }
}
