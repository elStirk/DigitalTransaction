package net.rpgmyth.digitaltransactions.events;

import net.ess3.api.IUser;
import net.essentialsx.api.v2.events.TransactionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.math.BigDecimal;


public class TransactionTax implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onTransaction(TransactionEvent event) {
        IUser target = event.getTarget();
        target.takeMoney(
                event.getAmount()
                        .multiply(BigDecimal.valueOf(0.20))
        );

        target.sendMessage("Has pagado un impuesto del 20% del importe de la transacción.");
    }
}
