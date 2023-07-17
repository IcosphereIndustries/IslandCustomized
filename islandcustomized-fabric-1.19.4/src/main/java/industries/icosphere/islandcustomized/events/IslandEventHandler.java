package industries.icosphere.islandcustomized.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Event system for the IslandCustomized fabric mod.
 * <p>
 * <h2>Usage</h2>
 * <h3>Creating an event</h3>
 * To use the event system, you must first create an event class that implements {@link IslandEvent}.
 * For example, if you want to create an event that is fired when you win a game, you would create a class
 * called GameWinEvent that implements IslandEvent.
 * <p>
 * <pre>
 *     public class GameWinEvent implements IslandEvent {
 *          public IslandGameMode gameMode;
 *
 *          public GameWinEvent(IslandGameMode gameMode) {
 *              this.gameMode = gameMode;
 *              // You can add more parameters if you want
 *          }
 *      }
 *     </pre>
 * <p>
 * <h3>Calling events</h3>
 * You must then somehow fire the event when needed. IslandCustomized does this by listening for the
 * "Victory!" title to be displayed on the screen using mixins. When this happens, it fires a GameWinEvent.
 * <p>
 * <pre>
 *     eventManager.fireEvent(new GameWinEvent(getCurrentGame()));
 *     </pre>
 * <p>
 * <h3>Listening for events</h3>
 * Finally, you must listen for the event to be fired. You can do this by creating a class that contains
 * methods with the {@link EventListener} annotation. The method must have a single parameter that is the
 * event class that you want to listen for.
 * <p>
 * <pre>
 *     public class GameWinListener {
 *         {@literal @}EventListener(GameWinEvent.class)
 *          public void onGameWin(GameWinEvent event) {
 *               // Do something
 *          }
 *     }
 *     </pre>
 * <p>
 * You should store the {@link IslandEventHandler} as a static variable in your mod's main class.
 * You can then register your listeners at startup using {@link IslandEventHandler#registerEventListener(Class)}.
 * <p>
 * <pre>
 *     eventManager.registerEventListener(TitleReplacer.class);
 *     </pre>
 *
 * @author Candycup
 * @see IslandEvent
 * @see EventListener
 */
public class IslandEventHandler {
    private Map<Class<? extends IslandEvent>, List<Method>> eventListeners;

    /**
     * Constructs an EventListenerManager.
     */
    public IslandEventHandler() {
        eventListeners = new HashMap<>();
    }

    /**
     * Registers an event listener object by scanning for methods with the @EventListener annotation.
     *
     * @param clazz the class of the event listener object
     */
    public void registerEventListener(Class<?> clazz) {
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(EventListener.class)) {
                for (Class<? extends IslandEvent> eventClass : method.getAnnotation(EventListener.class).value()) {
                    List<Method> listeners = eventListeners.getOrDefault(eventClass, new ArrayList<>());
                    listeners.add(method);
                    eventListeners.put(eventClass, listeners);
                }
            }
        }
    }

    /**
     * Fires an event by invoking all the registered event listener methods for the given event.
     *
     * @param event the event to be fired
     */
    public void fireEvent(IslandEvent event) {
        List<Method> listeners = eventListeners.get(event.getClass());
        if (listeners != null) {
            for (Method listener : listeners) {
                Object listenerObject = null;
                try {
                    listenerObject = listener.getDeclaringClass().newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                try {
                    if (listener.getParameterCount() == 0) {
                        listener.invoke(listenerObject);
                    } else {
                        listener.invoke(listenerObject, event);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
