package Bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class invite extends ListenerAdapter {


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        int timeLimit = 3600;
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if (msg[0].equalsIgnoreCase(BotMain.Prefix + "Invite") && msg.length == 1) {
            event.getChannel().sendMessage("Type [-invite create] to create an invite").queue();

        } else if (msg.length >= 2 && msg[0].equalsIgnoreCase(BotMain.Prefix + "Invite") && msg[1].equalsIgnoreCase( "create")) {
            event.getChannel().sendMessage("Your invite --- > " + event.getGuild().getDefaultChannel().createInvite().setMaxAge(timeLimit).complete().getUrl()).queue();
        }
    }

}
