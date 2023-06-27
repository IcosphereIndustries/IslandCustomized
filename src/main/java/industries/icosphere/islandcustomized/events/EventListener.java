package industries.icosphere.islandcustomized.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a method as an event listener.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventListener {
    /**
     * Specifies the event class that the annotated method listens to.
     *
     * @return the event class
     */
    Class<? extends IslandEvent>[] value();
}
