package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class MJ extends ListenerAdapter {
      String [] msgs = {
              "[member] joined. Hide your chocolate",
              "[member] could use a friend.",
              "Holy shit, is that [member] ? the one and only!",
              "[member] was gay, then they joined /r/SaudiArabia..",
              "[member] who's the king of snakes? (Spoiler, it's Ammar)",

      };


    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        Random rand = new Random();
        int num = rand.nextInt(msgs.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setDescription(msgs[num].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getDefaultChannel().asTextChannel().sendMessageEmbeds(join.build()).queue();
        // Adding a role to the member once he joins the server
        // TODO Error -- Member does not get a rank when joining the server
        // e.getGuild().getController().addRolesToMember(e.getMember(), e.getGuild().getRolesByName("Member", true));


    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {

        event.getGuild().addRoleToMember(UserSnowflake.fromId(event.getMember().getAsMention()), event.getGuild().getRoleById("Sllom")).queue();
    }
}
