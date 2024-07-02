package net.rpgmyth.digitaltransactions.events;

import net.essentialsx.api.v2.events.TransactionEvent;
import net.rpgmyth.digitaltransactions.DigitalTransactions;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.math.BigDecimal;
import java.util.Map;

public class TransactionTax implements Listener {
    @EventHandler
    public void onTransactions(TransactionEvent event){
        double amount = event.getAmount().doubleValue();
        for(Map.Entry<Double, Integer> entry : DigitalTransactions.taxBrackets.entrySet()){
            double value = entry.getKey();
            if(amount <= value) {
                double tax = amount * ((double) entry.getValue() / 100);
                event.getTarget().takeMoney(BigDecimal.valueOf(tax));
                break;
            }
        }
    }
}
