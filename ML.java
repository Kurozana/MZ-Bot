package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;

public class ML extends ListenerAdapter {
       String[] msgs = {
               "[member] left, thank god lmao ",
               "W H :OMEGALUL: [member]",
               "[member] killed himself",
               "[member] can't handle Waffie anymore..",
               "راح نشتاق لك يا [member] بس موب مرااااّ~",

       };
    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) throws NullPointerException {
      Random rand = new Random();
      int num = rand.nextInt(msgs.length);
      EmbedBuilder leave = new EmbedBuilder();
        leave.setColor(new Color(92, 220, 216));
        leave.setFooter("About time, damn.");
        leave.setThumbnail(event.getUser().getAvatarUrl());
        leave.setTimestamp(Instant.now());
      leave.setDescription(msgs[num].replace("[member]", event.getUser().getAsMention()));
         try{
             event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(leave.build()).queue();
         }catch (NullPointerException ex){
             ex.printStackTrace();
         }
    }
}
