package Bot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.awt.*;
import java.util.Random;

public class ML extends ListenerAdapter {
    String[] msgs = {
            "[m] left us cause big gay.",
            "I. AM. [m]. THE SERVER LEAAAAAAAAVER",
            "Sometimes [m] can be sensitive",
            "[m] plays TERA a lot so he's a bit autistic"
    };




    public void onGuildMemberLeave(GuildMemberLeaveEvent e) throws NullPointerException{
     Random r = new Random();
     int n = r.nextInt(msgs.length);
     EmbedBuilder leave = new EmbedBuilder();
     leave.setDescription(msgs[n].replace("[m]", e.getMember().getAsMention()));
     leave.setColor(Color.BLACK);
    try{
        e.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
    }
     catch(NullPointerException ex){
        ex.printStackTrace();
     }
    }
}
