package Bot;
import com.sun.net.httpserver.Authenticator;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Actions extends ListenerAdapter {




    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
        String [] args = event.getMessage().getContentRaw().split("\\s+");
        String User = event.getAuthor().getAsMention();
        String msg = event.getMessage().getContentRaw().toLowerCase();
        // Command List -


        // Getting the user Avatar
         if(args[0].equalsIgnoreCase(BotMain.Prefix + "UA")) {
             String ua = event.getMessage().getMentions().getUsers().get(0).getAvatarUrl();
             String usr = event.getMessage().getMentions().getUsers().get(0).getAsMention();
             if (ua == null) {
                 event.getChannel().sendMessage(usr + " Has the default discord icon").queue();
             } else {
                 event.getChannel().sendMessage(ua).queue();
             }
         }
         // ENDS HERE ( UA )


             if(args[0].equalsIgnoreCase(BotMain.Prefix + "Info")) {
                     EmbedBuilder Em = new EmbedBuilder();
                     Em.setTitle("mom_rage");
                     Em.setDescription("A semi-private bot for Mature Zone DS.");
                     Em.addField("Developer", "This has been developed by Ibrahim.", false);
                     Em.addField("Which API?", "This bot utilizes JDA API by JDA team;", false);
                     Em.setColor(Color.PINK);
                     Em.setFooter(" > " + formatter.format(date), event.getGuild().getIconUrl());
                     event.getChannel().asTextChannel().sendMessageEmbeds(Em.build()).queue();

             }

             if(args[0].equalsIgnoreCase(BotMain.Prefix + "Clear")){

                 String sender = event.getMember().getUser().getAsMention();
                 if(args.length < 2){
                     EmbedBuilder usage = new EmbedBuilder();
                     usage.setColor(0xff3923);
                     usage.setTitle("Clear Command");
                     usage.setDescription("Usage: " + BotMain.Prefix + " Clear [Number of Messages]");
                     usage.setFooter("Request to clear was made @" + formatter.format(date), event.getGuild().getIconUrl());
                     event.getChannel().asTextChannel().sendMessageEmbeds(usage.build()).queue();
                 }else{
                     try{
                         List<Message> Messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                         event.getChannel().getLatestMessageId();
                         event.getChannel().asTextChannel().deleteMessages(Messages).queue();
                         // If successful ---> send success message for confirmation
                         EmbedBuilder success = new EmbedBuilder();
                         success.setTitle("Successfully deleted " + args[1] + " messages");
                         success.setColor(Color.GREEN);
                         success.setDescription(sender + " admitted to being a femboy so he had to delete " + args[1] + " images of him dressing as a femboy LMFAOOO, EXPOSED BABY.");
                         event.getChannel().asTextChannel().sendMessageEmbeds(success.build()).queue();
                         success.clear();

                         // Catching the error - exception
                     }catch(IllegalArgumentException ex){
                         if(ex.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                             EmbedBuilder error = new EmbedBuilder();
                             error.setColor(Color.BLACK);
                             error.setTitle("Too many messages selected");
                             error.setDescription("Limit is 1 to 100");
                             event.getChannel().sendMessageEmbeds(error.build()).queue();
                         }
                     }
                 }
             }
      /*  if(msg.contains("n3ia")){
            event.getGuild().getDefaultChannel().asTextChannel().sendMessage("just another person from this lovely world " + User + " Don't you agree uwu?").queue();
         }*/


        }

    }


