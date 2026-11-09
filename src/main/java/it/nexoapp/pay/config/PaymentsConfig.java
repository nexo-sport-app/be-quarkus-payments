package it.nexoapp.pay.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

/**
 * Payments microservice settings, mapped from configuration properties with the {@code pay} prefix.
 * <p>
 * Every property is optional and falls back to a default when not set.
 */
@StaticInitSafe
@ConfigMapping(prefix = "pay")
public interface PaymentsConfig {

    /**
     * Messaging settings (properties with the {@code pay.messaging} prefix).
     */
    Messaging messaging();

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Settings of the event messaging, mapped from the {@code pay.messaging} prefix.
     */
    interface Messaging {

        /**
         * Name of the topic exchange the outbox relay publishes this service's events on
         * (property {@code pay.messaging.exchange}). Optional, defaults to {@code nexo.pay}.
         */
        @WithDefault("nexo.pay")
        String exchange();

    }

}
