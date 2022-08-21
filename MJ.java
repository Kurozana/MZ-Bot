package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.Random;

public class MJ extends ListenerAdapter {
      String [] msgs = {
              "[member] joined. Hide your chocolate.",
              "[member] could use a friend.",
              "[member] avoid the guy called Waffie, or is it a girl? idk.",
              "[member] we've seen your search histroy.",
              "Holy shit, is that [member] ? the one and only!",
              "[member] was gay, then they joined /r/SaudiArabia..",
              "[member] who's the king of snakes? (Spoiler, it's Ammar)",

      };


    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        Random rand = new Random();
        int num = rand.nextInt(msgs.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(new Color(101, 190, 0));
        join.setDescription(msgs[num].replace("[member]", event.getMember().getAsMention()));
        join.setFooter("You're autist number " + event.getGuild().getMemberCount() + " on the server.");
        join.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());
        join.setTimestamp(Instant.now());
        event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(join.build()).queue();



    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        // Role NUMBER Id is needed here and not the actual string**

        // event.getGuild().addRoleToMember(UserSnowflake.fromId(event.getMember().getAsMention()), event.getGuild().getRoleById("Sllom")).queue();
    }
}
