package Bot;



import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Actions extends ListenerAdapter {




    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        String [] args = event.getMessage().getContentRaw().split("\\s+");
        String User = event.getAuthor().getAsMention();
        String msg = event.getMessage().getContentRaw().toLowerCase();
         if(args[0].equalsIgnoreCase(BotMain.Prefix + "UA")){
             String ua = event.getMessage().getMentions().getUsers().get(0).getAvatarUrl();
             String usr = event.getMessage().getMentions().getUsers().get(0).getAsMention();
             if (ua == null){
                 event.getChannel().sendMessage(usr + " Has the default discord icon").queue();
             }else{
                 event.getChannel().sendMessage(ua).queue();
             }
         }
        if(msg.contains("n3ia")){
            event.getGuild().getDefaultChannel().asTextChannel().sendMessage("just another person from this lovely world " + User + " Don't you agree uwu?").queue();

        }

    }

}
