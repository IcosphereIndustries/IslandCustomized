package industries.icosphere.islandcustomized.screens;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.HorizontalAlignment;
import io.wispforest.owo.ui.core.OwoUIAdapter;
import io.wispforest.owo.ui.core.Surface;
import io.wispforest.owo.ui.core.VerticalAlignment;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.NotNull;

public class UpdateNotifierScreen extends BaseOwoScreen<FlowLayout> {

    public UpdateNotifierScreen(ServerInfo entry) {

        this.entry = entry;

    }

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        rootComponent
                .surface(Surface.VANILLA_TRANSLUCENT)
                .horizontalAlignment(HorizontalAlignment.CENTER)
                .verticalAlignment(VerticalAlignment.CENTER);

        rootComponent.child(
                Components.label(
                        Text.literal("Hey! There's an update out for Island Customized! Be sure to update as soon as possible!\n")
                                .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.AQUA)))
                )
        );

        // TODO: Change the link to modrinth when we get around to that
        rootComponent.child(
                Components.label(Text.literal("Click to get the update!")
                        .setStyle(Style.EMPTY.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/IcosphereIndustries/IslandCustomized/tags"))
                                .withUnderline(true).withColor(TextColor.fromFormatting(Formatting.GOLD))))
        );

        rootComponent.child(
                Components.label(
                        Text.literal("(Press ESC to close this screen)")
                                .setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GRAY)).withItalic(true))
                )
        );
    }

    ServerInfo entry;

    @Override
    public void close() {
        super.close();

        ConnectScreen.connect(
                new MultiplayerScreen(this), client, ServerAddress.parse(entry.address), entry
        );
    }
}
