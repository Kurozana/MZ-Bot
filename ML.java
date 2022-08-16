package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class ML extends ListenerAdapter {
       String[] msgs = {
               "[member] left, thank god lmao ",
               "W H :OMEGALUL: [member]",
               "[member] killed himself",
               "[member] couldn't handle Waffie much more..",
               "راح نشتاق لك يا [member] بس موب مرااااّ~",

       };
    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) throws NullPointerException {
      Random rand = new Random();
      int num = rand.nextInt(msgs.length);
      EmbedBuilder leave = new EmbedBuilder();
         leave.setDescription(msgs[num].replace("[member]", event.getMember().getUser().getAsTag()));
         try{
             event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(leave.build()).queue();
         }catch (NullPointerException ex){
             ex.printStackTrace();
         }
    }
}
