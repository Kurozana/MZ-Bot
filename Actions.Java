package Bot;



import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Actions extends ListenerAdapter {



    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        String User = event.getUser().getAsMention();
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage("Welcome" + User + "! You are literally a test subject for me frfr ongod").queue();



    }


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String User = event.getAuthor().getAsMention();
        String msg = event.getMessage().getContentRaw().toLowerCase();
        if(msg.contains("n3ia")){
            event.getGuild().getDefaultChannel().asTextChannel().sendMessage("just another person from this lovely world " + User + " Don't you agree uwu?").queue();

        }

    }
}
