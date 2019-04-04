package Bot;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;







public class MyEventListener extends ListenerAdapter {



    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        Date date = new Date();
        String UR = event.getMember().getAsMention();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(BotMain.PFX + "prefix")){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("The PREFIX is '-'").queue();
        }
        if (args[0].equalsIgnoreCase(BotMain.PFX+ "UA"))
        {
            List<User> Userino;
            String ua = event.getMessage().getMentionedUsers().get(0).getAvatarUrl();
            String urr = event.getMessage().getMentionedUsers().get(0).getAsMention();
            if(ua == null){
                event.getChannel().sendMessage(urr  + " has the default discord avatar!").queue();
            }else{
                event.getChannel().sendMessage(ua).queue();
            }



        }
        if (args[0].equalsIgnoreCase(BotMain.PFX + "Ava"))
        {
            String AVATAR = event.getMember().getUser().getAvatarUrl();
            if (AVATAR == null){
                event.getChannel().sendMessage(UR +" has the default discord avatar!").queue();
            } else
                event.getChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();
        }


        if(args[0].equalsIgnoreCase(BotMain.PFX + "Info")){
            EmbedBuilder Em = new EmbedBuilder();
            Em.setTitle("General Information");
            Em.setDescription("This bot has been made by Ibrahim");
            Em.addField("Purpose","For fun/learning.", false);
            Em.setColor(Color.BLACK);
            Em.setFooter(" > " + formatter.format(date), event.getGuild().getIconUrl());
            event.getChannel().sendMessage(Em.build()).queue();
            Em.clear();
        }
        if(args[0].equalsIgnoreCase(BotMain.PFX + "Clear")){
            if(args.length < 2){
                // TODO Error
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("Specify the amount of messages  ");
                usage.setDescription("Usage:"+BotMain.PFX + "Clear [Num of Messages]");
                usage.setFooter("Request was made @ " + formatter.format(date), event.getGuild().getIconUrl());
                event.getChannel().sendMessage(usage.build()).queue();
            }else{
                try{
                    List<Message> msgs =  event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(msgs).queue();
                    // Success
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(Color.GREEN);
                    success.setTitle("Successfully deleted "+ args[1]+ " Messages");
                    success.setDescription("Yay!");
                    event.getChannel().sendMessage(success.build()).queue();
                    success.clear();


                }catch(IllegalArgumentException ex){
                    if(ex.toString().startsWith("java.lang.IllegalArgumentException: Message retrivial")){
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("Too many messages selected ! ");
                        error.setDescription("Limit is 1 to 100 messages");
                        event.getChannel().sendMessage(error.build()).queue();

                    }else {
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("Messages too old");
                        error.setDescription("Messages older than 2 weeks can not be deleted!");
                        event.getChannel().sendMessage(error.build()).queue();

                    }

                }

            }

        }
        if (args[0].equalsIgnoreCase(BotMain.PFX + "Commands")){
            EmbedBuilder em = new EmbedBuilder();
            em.setTitle("Commands of the bot");
            em.addField("-prefix","Replies with the prefix of the bot. 'WILL ONLY WORK IF YOU HAVE PERMISSIONS.'", false);
            em.addField("-UA","Use this command and tag a person in the same message. 'The user has to be in the server!' to get their avatar.", false);
            em.addField("-Info","Gives you the general info about the bot.", false);
            em.addField("-Ava","Get your OWN avatar.", false);
            em.addField("-Ping","Shows you the ping of the bot!", false);
            em.addField("-Clear","Type '-Clear' To see the usage of that command.", false);
            em.addField("-Invite", "A command to create an invite link", false);
            em.setColor(Color.BLACK);
            em.setFooter("Request was made @ " + formatter.format(date), event.getGuild().getIconUrl());
            event.getChannel().sendMessage(em.build()).queue();
            em.clear();
        }
    }


        public void onMessageReceived(MessageReceivedEvent event){


            Message msg = event.getMessage();
            String content = msg.getContentRaw();

            if (content.startsWith(BotMain.PFX + "Ping"))
            {
                event.getChannel().sendMessage("The ping of the bot is " + event.getJDA().getPing()).queue();
            }

    }

}
