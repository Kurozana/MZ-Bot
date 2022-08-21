package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class MKick extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        // Declaring all vars
        String [] args = event.getMessage().getContentRaw().split("\\s+");
        Member Author = event.getMessage().getMember();
        Guild guild = event.getGuild();
        String authorName = event.getAuthor().getName();
        String authorAvatar = event.getAuthor().getAvatarUrl();
        String message = event.getMessage().getContentRaw();
        MessageChannel channel = event.getChannel();

        if(args[0].equalsIgnoreCase(BotMain.Prefix + "Kick")){
            // Check for eligibility . . .
            if(!Author.hasPermission(Permission.KICK_MEMBERS)){
                channel.sendMessage(event.getMember().getAsMention() + " You do not have permission to kick").queue();
            }
            if(event.getMessage().getMentions().getMembers().isEmpty()){
                channel.sendMessage(event.getMember().getAsMention() + " You need to mention whoever is about to hold the door").queue();
            }
            event.getGuild().kick(event.getMessage().getMentions().getUsers().get(0)).complete();
            channel.sendMessage("Kicked successfully").queue();

            // DMing the user with the unfortunate news
            PrivateChannel dm = event.getMessage().getMentions().getUsers().get(0).openPrivateChannel().complete();
            EmbedBuilder embedDM = new EmbedBuilder();
            embedDM.setTitle("You got kicked from the Discord server", null);
            embedDM.setDescription("Hey bud, you've been kicked from " + guild.getName() + " Discord. \nNothing personal really, it's either you were a test subject of Ibrahim ooooor you're just unfortunate");
            embedDM.setThumbnail(event.getGuild().getIconUrl());
            embedDM.setAuthor(authorName, null, authorAvatar);
            embedDM.setColor(Color.BLACK);
            dm.sendMessageEmbeds(embedDM.build()).queue();
            embedDM.clear();
        }

    }
}
