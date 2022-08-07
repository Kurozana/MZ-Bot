package Bot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Random;

public class Mj extends ListenerAdapter {
    String[] msgs = {
            "[member] joined. Hide your chocolate.",
            "[member] is a bit shy, tag'em.",
            "[member] is a disgusting verified weeb.",
            "[member] hates people.",
            "[member] could use a friend.",
            "It's dangerous to go alone, take [member]!",
            "Swoooosh. [member] just landed.",
            "I. AM. [member] THE WORLD ENDEEEEEEEER!",
            "E-Girl spotted. Ahm h-hey [member] *nuzzles*"
    };


    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
      Random rand = new Random();
      int num = rand.nextInt(msgs.length);
      EmbedBuilder join = new EmbedBuilder();
      join.setDescription(msgs[num].replace("[member]", e.getMember().getAsMention()));
      e.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
      // Adding a role to the member once he joins the server
        // TODO Error  ( Member does not get a rank when joining the server).
      e.getGuild().getController().addRolesToMember(e.getMember(), e.getGuild().getRolesByName("Member", true));

    }

}
