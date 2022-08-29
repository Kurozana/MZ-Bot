package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        String User = event.getAuthor().getAsMention();
        String msg = event.getMessage().getContentRaw().toLowerCase();

        // Building the Embed
        if (args[0].equalsIgnoreCase(BotMain.Prefix + "Commands")) {
            EmbedBuilder Com = new EmbedBuilder();
            Com.setTitle("Commands");
            Com.setColor(new Color(101, 190, 0));
            Com.setDescription("These are the current available commands, if any are to be added, this embed will be updated" + event.getMember().getAsMention());
            Com.setFooter(event.getMember().getAsMention() + " Made this request");
            Com.addField("-Commands", "Shows commands", false);
            Com.addField("-info", "Shows bot info", false);
            Com.addField("-Clear", "Clears specific amount of msgs", false);
            Com.addField("-UA", "This command with a mention will yoink the mentioned user's avatar", false);
            Com.addField("Prefix", "Prefix before any command is [-]", false);
            Com.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
            Com.setTimestamp(Instant.now());
            event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(Com.build()).queue();
        }
    }
}
