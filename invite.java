package Bot;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        int timeLimit = 3600;
        String[] msg = e.getMessage().getContentRaw().split(" ") ;
        if (msg[0].equalsIgnoreCase(BotMain.PFX + "Invite") && msg.length == 1) {
            e.getChannel().sendMessage("Type [-Invite create] to create an invite!").queue();
        }else if(msg.length >= 2 && msg[0].equalsIgnoreCase(BotMain.PFX + "Invite") && msg[1].equalsIgnoreCase("create")){
            e.getChannel().sendMessage("Hey " + e.getAuthor().getName() + " your invite will be ready in a second!").queue();
            e.getChannel().sendMessage("Your invite is ready ! --> "+ e.getChannel().createInvite().setMaxAge(timeLimit).complete().getURL()).queue();
            e.getChannel().sendMessage("By the way your invite expires in " + timeLimit + " seconds! (1 hour)").queue();
        }

    }

}
